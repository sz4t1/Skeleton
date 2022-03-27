import java.util.ArrayList;
//The virologist class represents the character which is being controlled by the player
public class Virologist {
    //Virologist constructor
    public Virologist(){
        System.out.println("Virologist constructed");
    }
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
        System.out.println("Yes I got a new material");
    }
    //Addd virus to the inventory
    public void AddVirus(Virus v){
        System.out.println("I have a new virus in my pocket");
    }
    //Add equipment to the virologists inventory
    public void AddEquipment(Equipment e){
        System.out.println("I got an equipment");
    }
    //Remove material from the virologists inventory
    public void RemoveMaterial(Material m){
        System.out.println("Removed material");
    }
    //Remove virus from the virologists inventory
    public void RemoveVirus(Virus v){
        System.out.println("Removed virus from inventory");
    }
    //Remove equipment from the virologists inventory
    public void RemoveEquipment(Equipment e){
        System.out.println("Removed item");
    }
    //Virologist move to another field that was given as a parameter
    public void Move(Field f){
        System.out.println("Moved to new field");
    }
    //Add a new genetic code to the known ones
    public void AddGeneticCode(Integer gen){
        System.out.println("New genetic I checked: "+gen);
    }
    //Remove a genetic code from the virologist's knowledge
    public void RemoveGeneticCodes(){
        System.out.println("Lost genetic codes :(");
    }
    //Creates a new virus
    public void CraftVirus(Virus v){
        System.out.println("Crafted a new virus");
        v.
    }
    //Attacks another virologist with the chosen virus
    public void Attack(Virus v, Virologist vir){
        System.out.println("Attacked another virologist");
    }
    //Uses virus
    public void UseVirus(Virus v){
        System.out.println("Used a virus");
    }
    //Uses virus on self
    public void UseVirusOnSelf(Virus v){
        System.out.println("Used a virus on myslef :/)");
    }
    //Scans a code on a laboratory
    public void ScanCode(){
        System.out.println("Scanned a code");
    }
    //Checks if the virologist have a genetic code
    public boolean HaveGeneticCode(Integer gen){
        System.out.println("I hope i don't have it, just kidding i know i don't have any in the skeleton part :') ");
        return false;
    }
    //Steal an equipment from another virologist
    public void StealEquipment(Virologist v, Equipment e){
        System.out.println("Stolen cool item");
    }
    //Steak a material from another virologist
    public void StealMaterial(Virologist v, Material m){
        System.out.println("Stolen mats");
    }
    //Being attacked by another virologist it passes the virus that was used by the attacker
    public void AttackedBy(Virologist vir, Virus v){
        System.out.println("Somebody attacked me :( let's hope I have reverse UNO card :8)");
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
}
