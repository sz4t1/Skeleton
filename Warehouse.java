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
        removeMaterial(m);
    }
    @Override
    public ArrayList<Material> getMaterials(){
        return materials;
    }

    //erre talán nem lesz szükség
    public void addMaterial(Material m){
        materials.add(m);
    }
    public void removeMaterial(Material m){
        materials.remove(m);
    }

    @Override
    public int GetAminoAcidCount(){
        int am = 0;
        for (Material m : getMaterials()) {
            if(m.getName().equals("aminoacid")){
                am++;
            }
        }
        return am;
    }

    @Override
    public int GetNukleoditeCount(){
        int nuk = 0;
        for (Material m : getMaterials()) {
            if(m.getName().equals("nukleotide")){
                nuk++;
            }
        }
        return nuk;
    }
}
