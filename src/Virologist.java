package src;

import java.util.ArrayList;
//The virologist class represents the character which is being controlled by the player
public class Virologist {
    
    //The actual place of the virologist
    private Field field;
    //The virus on the virologist if she/he have one on self
    private Virus virusOn;
    //Actual equipment count in inventory
    private Integer equipmentSize;
    //actual material count in inventory
    private Integer materialSize;
    //actual virus count in inventory
    private Integer virusSize;
    //Genetic codes obtained by the virologist
    private ArrayList<Integer> genCodes;
    //Viruses that the virologist have in the inventory
    private ArrayList<Virus> viruses;
    //Equipments that the virologist have in the inventory
    private ArrayList<Equipment> equipment;
    //Materials that the virologist have in the inventory
    private ArrayList<Material> materials;
    //Actual capacity ability of the virologist
    private CapacityAbility capacityAbility;
    //Actual movement ability of the virologist
    private MovementAbility movementAbility;
    //Actual protection ability of the virologist
    private ProtectionAbility protectionAbility;
    //Actual reflection ability of the virologist
    private ReflectionAbility reflectionAbility;
    //Actual execute ability of the virologist
    private ExecuteAbility executeAbility;

    //Virologist constructor
    public Virologist(){
        System.out.println("Virologist() - Virologist constructed: " + this);
        viruses= new ArrayList<>();
        equipment=new ArrayList<>();
        materials=new ArrayList<>();
        genCodes=new ArrayList<>();
        this.movementAbility=new FreeMovememnt();
        this.capacityAbility=new DefaultCapacity();
        this.protectionAbility=new NoProtection();
        this.reflectionAbility=new NoReflection();
        this.executeAbility=new CanNotExecute();
        virusOn = null;
        equipmentSize=0;
        virusSize=0;
        materialSize=0;
    }
    
    //Add material to the virologists inventory
    public void AddMaterial(Material m){
        System.out.println("AddMaterial(Material m) - Material is added to the virologist's inventory.");
        this.getField().Remove(null,m,null);
    }
    //Addd virus to the inventory
    public void AddVirus(Virus v){
        System.out.println("AddVirus(Virus v) - Virus is added to the virologist's inventory.");
        viruses.add(v);
        virusSize++;
    }
    //Add equipment to the virologists inventory
    public void AddEquipment(Equipment e){
        System.out.println("AddEquipment(Equipment e) - Equipment is added to the virologist's inventory.");
        this.getField().Remove(e,null,null);
        addEquipment(e);

    }
    //Remove material from the virologists inventory
    public void RemoveMaterial(Material m){
        System.out.println("RemoveMaterial(Material m) - Matrial is removed from the virologist's inventory.");
        m.beingUsed();
        materials.remove(m);
        materialSize--;
    }
    //Remove virus from the virologists inventory
    public void RemoveVirus(Virus v){
        System.out.println("RemoveVirus(Virus v) - Virus is removed from the virologist's inventory.");
        viruses.remove(v);
        virusSize--;
    }
    //Remove equipment from the virologists inventory
    public void RemoveEquipment(Equipment e){
        e.UnEquip(this);
        this.removeEquipment(e);
        System.out.println("RemoveEquipment(Equipment e) - Equipment is removed from the virologist's inventory.");
    }
    //Virologist move to another field that was given as a parameter
    public void Move(Field f){
        System.out.println("Move(Field f) - The virologist attempts to move to another field.");
        getMovementAbility().invokeEffect(this, f);
    }
    //Add a new genetic code to the known ones
    public void AddGeneticCode(Integer gen){
        if(!HaveGeneticCode(gen)){
        System.out.println("AddGeneticCode(Integer gen) - A new genetic code is stored.");
        genCodes.add(gen);
        }
        else{
            System.out.println("AddGeneticCode(Integer gen) - This genetic code is already known.");
        }
    }
    //Remove a genetic code from the virologist's knowledge
    public void RemoveGeneticCodes(){
        System.out.println("RemoveGeneticCodes() - The virologist lost the genetic codes.");
        genCodes.clear();
    }
    //Creates a new virus
    public void CraftVirus( Recipe recipe){
        System.out.println("CraftVirus(Virus v) - Virologist wants to craft a virus.");
        Virus nv = recipe.CreateVirus(this);
        if(nv != null) {
            this.AddVirus(nv);
            return;
        }
        System.out.println("CraftVirus(Virus v) - Not enough resources.");
    }
    //Attacks another virologist with the chosen virus
    public void Attack(Virus v, Virologist vir){
        System.out.println("Attack(Virus v, Virologist vir) - Virologist attacks a virologist.");
        vir.AttackedBy(this, v);
    }
    //Uses virus
    public void UseVirus(Virus v){
        System.out.println("UseVirus(Virus v) - A virus effects the virologist.");
        protectionAbility.invokeEffect(this, v);
    }
    //Uses virus on self
    public void UseVirusOnSelf(Virus v){
        System.out.println("UseVirusOnSelf(Virus v) - The virologist uses a virus on himself.");
        v.Effect(this);
        RemoveVirus(v);
    }
    //Scans a code on a laboratory
    public void ScanCode(){
        System.out.println("ScanCode() - The virologist attempts to scan some genetic code.");
        this.field.Remove(null,null,this);
    }
    //Checks if the virologist have a genetic code
    private boolean HaveGeneticCode(Integer gen){
        System.out.println(" HaveGeneticCode(Integer gen) - Checks if the genetic code is stored already.");
        return genCodes.contains(gen);
    }
    //Steal an equipment from another virologist
    public void StealEquipment(Virologist v, Equipment e){
        System.out.println("StealEquipment(Virologist v, Equipment e) - Virologist steals equipment.");
        if( this.equipmentSize<2){
            v.RemoveEquipment(e);
            this.addEquipment(e);

        }
    }
    //Steak a material from another virologist
    public void StealMaterial(Virologist v, Material m){
        System.out.println("StealMaterial(Virologist v, Material m) - Stolen materials.");
        if(capacityAbility.getMaxMaterialSize()<materialSize+1){
            v.RemoveMaterial(m);
            this.AddMaterial(m);
        }
    }
    //Being attacked by another virologist it passes the virus that was used by the attacker
    public void AttackedBy(Virologist vir, Virus v){
        System.out.println("AttackedBy(Virologist vir, Virus v) - The virologist recieves an attack.");
        reflectionAbility.invokeEffect(vir, this, v);
    }
    //Attacks another virologist with an axe
    public void AttackWithAxe(Virologist vir){
        System.out.println("AttackWithAxe(Virologist v) - The virologist attacked another virologist with an axe");
        executeAbility.invokeEffekt(vir);
    }
    //Getters and setters
    public Virus getVirusOn() {
        return virusOn;
    }

    public void setVirusOn(Virus virusOn) {
        System.out.println("setVirusOn(Virus virusOn) - The virus on the virologist has been changed.");
        this.virusOn = virusOn;
    }

    public Integer getEquipmentSize() {
        System.out.println("getEquipmentSize()");
        return equipmentSize;
    }

    public void setEquipmentSize(Integer equipmentSize) {
        System.out.println("setEquipmentSize(Integer equipmentSize)");
        this.equipmentSize = equipmentSize;
    }

    public Integer getMaterialSize() {
        System.out.println("getMaterialSize()");
        return materialSize;
    }

    public void setMaterialSize(Integer materialSize) {
        System.out.println("setMaterialSize(Integer materialSize)");
        this.materialSize = materialSize;
    }

    public ArrayList<Material> getMaterials(){
        return materials;
    }

    public Integer getVirusSize() {
        System.out.println("getVirusSize()");
        return virusSize;
    }

    public void setVirusSize(Integer virusSize) {
        System.out.println("setVirusSize(Integer virusSize)");
        this.virusSize = virusSize;
    }

    public CapacityAbility getCapacityAbility() {
        System.out.println("getCapacityAbility()");
        return capacityAbility;
    }

    public void setCapacityAbility(CapacityAbility capacityAbility) {
        System.out.println("setCapacityAbility(CapacityAbility capacityAbility) - The CapacityAbility on the virologist has been changed.");
        this.capacityAbility = capacityAbility;
    }

    public MovementAbility getMovementAbility() {
        System.out.println("getMovementAbility()");
        return movementAbility;
    }

    public void setMovementAbility(MovementAbility movementAbility) {
        System.out.println("setMovementAbility(MovementAbility movementAbility) - The MovementAbility on the virologist has been changed.");
        this.movementAbility = movementAbility;
    }

    public ReflectionAbility getReflectionAbility() {
        System.out.println("getReflectionAbility()");
        return reflectionAbility;
    }

    public void setReflectionAbility(ReflectionAbility reflectionAbility) {
        System.out.println("setReflectionAbility(ReflectionAbility reflectionAbility) - The ReflectionAbility on the virologist has been changed.");
        this.reflectionAbility = reflectionAbility;
    }

    public ProtectionAbility getProtectionAbility() {
        System.out.println("getProtectionAbility()");
        return protectionAbility;
    }

    public void setProtectionAbility(ProtectionAbility protectionAbility) {
        System.out.println("setProtectionAbility(ProtectionAbility protectionAbility) - The ProtectionAbility on the virologist has been changed.");
        this.protectionAbility = protectionAbility;
    }

    public ExecuteAbility gExecuteAbility(){
        System.out.println("gExecuteAbility()");
        return executeAbility;
    }

    public void setExecuteAbility(ExecuteAbility ea){
        System.out.println("setExecuteAbility(ExecuteAbility ea) - The ExecuteAbility on the virologist has been changed.");
        this.executeAbility = ea;
    }

    public Field getField() {
        System.out.println("getField()");
        return field;
    }

    public void setField(Field field) {
        System.out.println("setField(Field field) - The virologist now stands on a field.");
        this.field = field;
    }

    public void removeEquipment(Equipment e){
        System.out.println("addEquipment(Equipment e) - The virologist dropped an equipment.");
        equipment.remove(e);
        equipmentSize--;
    }

    public void addEquipment(Equipment e){
        System.out.println("addEquipment(Equipment e) - The virologist picked up an equipment.");
        equipment.add(e);
        e.Equip(this);
        equipmentSize++;
    }

    public void addMaterial(Material m){
        materials.add(m);
    }

    //returns the ammount of the known genetic codes
    public int getGenCodesAmmount(){
        return genCodes.size();
    }

}
