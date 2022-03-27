import java.util.ArrayList;

//This class represents a field on the game map
public class Field {
    //The attribute name is an id
    private String name;
    //The attribute neighbours contains the neighbour fields of this field
    private ArrayList<Field> neighbours;
    //Check if the given field is a neighbour
    public boolean IsNeighbour(Field f){
        System.out.println("Everythign is neighbour atm in the skeleton");
        return true;
    }

    public void RemoveVirologist(Virologist v){
        System.out.println("Virologist is removed from this field");
    }

    public void AddVirologist(Virologist v){
        System.out.println("A new Virologist etnered this field");
    }
    //Public getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
