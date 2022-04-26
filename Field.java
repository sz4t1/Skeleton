import java.util.ArrayList;

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

    public void RemoveVirologist(Virologist v){
        System.out.println(" RemoveVirologist(Virologist v) - Virologist is removed from the old field.");
        virologists.remove(v);
    }

    public void AddVirologist(Virologist v){
        System.out.println("AddVirologist(Virologist v) - The virologist  stepped on the new field.");
        virologists.add(v);
    }
    //Public getters and setters
    public String getName() {
        System.out.println("getName");
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

    public void setNeighbours(ArrayList<Field> neighbours) {
        this.neighbours = neighbours;
    }

    public void addNeighbour(Field neighbour){
        System.out.println("addNeughbour(Field neighbour) - Add a new neighbour to the neighbours list.");
        neighbours.add(neighbour);
    }

    public void Remove(Equipment e, Material m, Virologist v){}
}
