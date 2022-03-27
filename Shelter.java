//Shelter is a field on the map that contains an equipment
//It extends the Field class
public class Shelter extends Field{
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
