//Shelter is a field on the map that contains an equipment
//It extends the Field class
public class Shelter extends Field{
    //Constructor
    public Shelter(){
        System.out.println("Shelter() - Shelter constructed: " + this);
        this.setName("Shelter");
    }
    //The equipment it have
    private Equipment equipment;
    //Removes the equipment from the shelter

    public void Remove(Equipment e, Material m, Virologist v){
        System.out.println("RemoveEquipment(Equipment e) - the picked up equipment is removed from the Shelter.");
    }
    //Get-set
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
