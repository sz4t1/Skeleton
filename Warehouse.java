import java.util.ArrayList;
//Warehouse is a field on the map that contains materials
//It extends the Field class
public class Warehouse extends Field{
    //Constructor
    public Warehouse(){
        materials=new ArrayList<>();
        System.out.println("Warehouse() - Warehouse constructed: " + this);
    }
    //The materials it contains
    private ArrayList<Material> materials;
    //Remove the material that was given in a parameter
    public void Remove(Equipment e, Material m,Virologist v){
        System.out.println("RemoveMaterial(Material m) - The picked up materials are removed from the Warehouse.");
    }
    public void addMaterial(Material m){
        materials.add(m);
    }
    public void removeMaterial(Material m){
        materials.remove(m);
    }
}
