import java.util.ArrayList;
//The virologist class represents the character which is being controlled by the player
public class Virologist {
    //Virologist constructor
    public Virologist(){
        System.out.println("Virologist() - Virologist constructed");
    }
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
    //Add material to the virologists inventory
    public void AddMaterial(Material m){
        System.out.println("AddMaterial(Material m) - Material is added to the virologist's inventory.");
    }
    //Addd virus to the inventory
    public void AddVirus(Virus v){
        System.out.println("AddVirus(Virus v) - Virus is added to the virologist's inventory.");
    }
    //Add equipment to the virologists inventory
    public void AddEquipment(Equipment e){
        System.out.println("AddEquipment(Equipment e) - Equipment is added to the virologist's inventory.");
    }
    //Remove material from the virologists inventory
    public void RemoveMaterial(Material m){
        System.out.println("RemoveMaterial(Material m) - Matrial is removed from the virologist's inventory.");
    }
    //Remove virus from the virologists inventory
    public void RemoveVirus(Virus v){
        System.out.println("RemoveVirus(Virus v) - Virus is removed from the virologist's inventory.");
    }
    //Remove equipment from the virologists inventory
    public void RemoveEquipment(Equipment e){
        System.out.println("RemoveEquipment(Equipment e) - Equipment is removed from the virologist's inventory.");
    }
    //Virologist move to another field that was given as a parameter
    public void Move(Field f){
        System.out.println("Move(Field f) - The virologist moves to another field.");
    }
    //Add a new genetic code to the known ones
    public void AddGeneticCode(Integer gen){
        System.out.println("AddGeneticCode(Integer gen) - A genetic code is stored.");
    }
    //Remove a genetic code from the virologist's knowledge
    public void RemoveGeneticCodes(){
        System.out.println("RemoveGeneticCodes() - Lost the genetic codes.");
    }
    //Creates a new virus
    public void CraftVirus( Recipe recipe){
        if(recipe.IsCraftable(this)) {
            recipe.RemoveUsedMaterials(this);
            this.AddVirus(recipe.CreateVirus(this));
        }
        System.out.println("CraftVirus(Virus v) - Virologist wants to craft a virus.");
    }
    //Attacks another virologist with the chosen virus
    public void Attack(Virus v, Virologist vir){
        System.out.println("Attack(Virus v, Virologist vir) - Virologist attacks a virologist.");
    }
    //Uses virus
    public void UseVirus(Virus v){
        System.out.println("UseVirus(Virus v) - A virus effects the virologist.");
    }
    //Uses virus on self
    public void UseVirusOnSelf(Virus v){
        System.out.println("UseVirusOnSelf(Virus v) - The virologist uses a virus on himself.");
    }
    //Scans a code on a laboratory
    public void ScanCode(){
        System.out.println("ScanCode() - Scanned a code");
    }
    //Checks if the virologist have a genetic code
    public boolean HaveGeneticCode(Integer gen){
        System.out.println(" HaveGeneticCode(Integer gen) - Checks if the genetic code s stored already.");
        return false;
    }
    //Steal an equipment from another virologist
    public void StealEquipment(Virologist v, Equipment e){
        System.out.println("StealEquipment(Virologist v, Equipment e) - Virologist steals equipment.");
    }
    //Steak a material from another virologist
    public void StealMaterial(Virologist v, Material m){
        System.out.println("StealMaterial(Virologist v, Material m) - Stolen materials.");
    }
    //Being attacked by another virologist it passes the virus that was used by the attacker
    public void AttackedBy(Virologist vir, Virus v){
        System.out.println("AttackedBy(Virologist vir, Virus v) - The virologist recieves an attack.");
    }
    //Getters and setters
    public Virus getVirusOn() {
        return virusOn;
    }

    public void setVirusOn(Virus virusOn) {
        this.virusOn = virusOn;
    }

    public Integer getEquipmentSize() {
        return equipmentSize;
    }

    public void setEquipmentSize(Integer equipmentSize) {
        this.equipmentSize = equipmentSize;
    }

    public Integer getMaterialSize() {
        System.out.println("getMaterialSize()");
        return materialSize;
    }

    public void setMaterialSize(Integer materialSize) {
        this.materialSize = materialSize;
    }

    public Integer getVirusSize() {
        return virusSize;
    }

    public void setVirusSize(Integer virusSize) {
        this.virusSize = virusSize;
    }

    public CapacityAbility getCapacityAbility() {
        System.out.println("getCapacityAbility()");
        return capacityAbility;
    }

    public void setCapacityAbility(CapacityAbility capacityAbility) {
        this.capacityAbility = capacityAbility;
    }

    public MovementAbility getMovementAbility() {
        return movementAbility;
    }

    public void setMovementAbility(MovementAbility movementAbility) {
        this.movementAbility = movementAbility;
    }

    public ReflectionAbility getReflectionAbility() {
        return reflectionAbility;
    }

    public void setReflectionAbility(ReflectionAbility reflectionAbility) {
        this.reflectionAbility = reflectionAbility;
    }

    public ProtectionAbility getProtectionAbility() {
        return protectionAbility;
    }

    public void setProtectionAbility(ProtectionAbility protectionAbility) {
        this.protectionAbility = protectionAbility;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        System.out.println("setField");
        this.field = field;
    }
}
