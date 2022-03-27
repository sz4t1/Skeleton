package src.main.java;

import java.util.ArrayList;

//This class represents a field on the game map
public class Field {
    public Field(){
        System.out.println("src.main.java.Field constructed");
    }
    //The attribute name is an id
    private String name;
    //The attribute neighbours contains the neighbour fields of this field
    private ArrayList<Field> neighbours;
    //Check if the given field is a neighbour
    public boolean IsNeighbour(Field f){
        System.out.println("IsNeighbour(src.main.java.Field f)");
        return true;
    }

    public void RemoveVirologist(Virologist v){
        System.out.println(" RemoveVirologist(src.main.java.Virologist v)");
    }

    public void AddVirologist(Virologist v){
        System.out.println("AddVirologist(src.main.java.Virologist v)");
    }
    //Public getters and setters
    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Field> getNeighbours() {
        System.out.println("src.main.java.Field getNeighbours");
        return neighbours;
    }

    public void setNeighbours(ArrayList<Field> neighbours) {
        this.neighbours = neighbours;
    }
}
