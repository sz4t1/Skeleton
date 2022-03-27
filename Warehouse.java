import java.util.ArrayList;
//Warehouse is a field on the map that contains materials
//It extends the Field class
public class Warehouse extends Field{
    //Constructor
    public Warehouse(){
        this.setName("Warehouse");
        System.out.println("Warehouse constructed");
    }
    //The materials it contains
    private ArrayList<Material> materials;
    //Remove the material that was given in a parameter
    public void RemoveMaterial(Material m){
        System.out.println("RemoveMaterial(Material m)");
    }
}
