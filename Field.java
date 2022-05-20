import java.util.ArrayList;
import java.util.Random;

//This class represents a field on the game map
public class Field {

    //The attribute name is an id
    private String name;
    //The attribute neighbours contains the neighbour fields of this field
    private ArrayList<Field> neighbours;
    //This attribute contains the virologists, that stand on this field
    private ArrayList<Virologist> virologists;
    //constructor
    public Field(){
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
        System.out.println("Field() - Field constructed: " + this);
    }
    //Check if the given field is a neighbour
    public boolean IsNeighbour(Field f){
        System.out.println("IsNeighbour(Field f) - Checking, if the fields are neighbours.");
        return neighbours.contains(f);
    }

    //Removes the virologist from this field
    public void RemoveVirologist(Virologist v){
        System.out.println(" RemoveVirologist(Virologist v) - Virologist is removed from the old field.");
        virologists.remove(v);
    }

    //Adds the virologist to this field
    public void AddVirologist(Virologist v){
        System.out.println("AddVirologist(Virologist v) - The virologist  stepped on the new field.");
        virologists.add(v);
    }

    //Returns the list of the virologists, who are standing on this field
    public ArrayList<Virologist> getVirologists(){
        return virologists;
    }

    //Checks, if the virologist stands there
    public boolean containsVirologist(Virologist v){
        return virologists.contains(v);
    }

    //Public getters and setters////////////
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName: "+name);
        this.name = name;
    }

    public ArrayList<Field> getNeighbours() {
        System.out.println("getNeighbours() - Searching for neighbours.");
        for(int i=0;i<neighbours.size();i++)
            System.out.println(i+". neighbour of the fild is: "+neighbours.get(i));
        return neighbours;
    }

    //Returns with a random field, wich is neighbor with this field
    public Field getRandomneighbor(){
        int neighborCount = neighbours.size();
        int retNum = new Random().nextInt(neighborCount);
        return neighbours.get(retNum);
    }

    public void setNeighbours(ArrayList<Field> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Field neighbour){
        System.out.println("addNeughbour(Field neighbour) - Add a new neighbour to the neighbours list.");
        neighbours.add(neighbour);
    }

    public void Remove(Equipment e, Material m, Virologist v){}

    //with this function, the Game will count all the Laboratories
    //Laboratory class must override this
    public int LabCount(){
        return 0;
    }

    //warehouse and shelter getters in the parent class

    public ArrayList<Material> getMaterials(){return null;}

    public ArrayList<Equipment> getEquipment(){return null;}

    public int GetAminoAcidCount(){return 0;}

    public int GetNukleoditeCount(){return 0;}

    public int GetAxeCount(){return 0;}

    public int GetCapeCount(){return 0;}

    public int GetGloveCount(){return 0;}

    public int GetSackCount(){return 0;}
}
