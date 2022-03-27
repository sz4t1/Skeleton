package src.main.java;

//src.main.java.Shelter is a field on the map that contains an equipment
//It extends the src.main.java.Field class
public class Shelter extends Field{
    //Constructor
    public Shelter(){
        System.out.println("Sgelter constructed");
    }
    //The equipment it have
    private Equipment equipment;
    //Removes the equipment from the shelter
    public void RemoveEquipment(Equipment e){}
    //Get-set
    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
