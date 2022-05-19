import java.util.ArrayList;
import java.util.Random;

//Shelter is a field on the map that contains an equipment
//It extends the Field class
public class Shelter extends Field{
    //Constructor
    public Shelter(){
        System.out.println("Shelter() - Shelter constructed: " + this);
        equipments = new ArrayList<>();
        //Generating the random equipment
        int eq = new Random().nextInt(4);
        switch(eq){
            case 0:{
                equipments.add(new Cape());
                break;
            }
            case 1:{
                equipments.add(new Sack());
                break;
            }
            case 2:{
                equipments.add(new Glove());
                break;
            }
            case 3:{
                equipments.add(new Axe());
                break;
            }
        }
    }
    //The equipment it have
    private ArrayList<Equipment> equipments;
    //Removes the equipment from the shelter

    public void Remove(Equipment e, Material m, Virologist v){
        if(e == null){
            return;
        }
        System.out.println("RemoveEquipment(Equipment e) - the picked up equipment is removed from the Shelter.");
        equipments.remove(e);
    }
    //Get-set
    @Override
    public ArrayList<Equipment> getEquipment() {
        return equipments;
    }

    @Override
    public int GetAxeCount(){
        int pa = 0;
        for(Equipment v : equipments){
            if(v.getName().equals("axe")){
                pa++;
            }
        }
        return pa;
    }

    @Override
    public int GetCapeCount(){
        int pa = 0;
        for(Equipment v : equipments){
            if(v.getName().equals("cape")){
                pa++;
            }
        }
        return pa;
    }

    @Override
    public int GetGloveCount(){
        int pa = 0;
        for(Equipment v : equipments){
            if(v.getName().equals("glove")){
                pa++;
            }
        }
        return pa;
    }

    @Override
    public int GetSackCount(){
        int pa = 0;
        for(Equipment v : equipments){
            if(v.getName().equals("sack")){
                pa++;
            }
        }
        return pa;
    }
}
