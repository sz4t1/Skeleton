package src;

import java.util.ArrayList;

//Shelter is a field on the map that contains an equipment
//It extends the Field class
public class Shelter extends Field{
    //Constructor
    public Shelter(){
        System.out.println("Shelter() - Shelter constructed: " + this);
        this.setName("Shelter");
        equipments = new ArrayList<>();
    }
    //The equipment it have
    private ArrayList<Equipment> equipments;
    //Removes the equipment from the shelter

    public void Remove(Equipment e, Material m, Virologist v){
        System.out.println("RemoveEquipment(Equipment e) - the picked up equipment is removed from the Shelter.");
        equipments.remove(e);
    }
    //Get-set
    @Override
    public ArrayList<Equipment> getEquipment() {
        return equipments;
    }
}
