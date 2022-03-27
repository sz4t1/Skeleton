package src.main.java;

import java.util.ArrayList;
//This class represents the game itself, it contains the players and the map
public class Game {
    //The virologist attribute contains the players in an arrayList
    private ArrayList<Virologist> virologists;
    //This attribute contains the fields of the map
    private ArrayList<Field> fields;
    //Constructor
    public Game(){
        virologists= new ArrayList<>();
        fields= new ArrayList<>();
    }
    //Starts the game
    public void StartGame(){
        System.out.println("gl hf");
    }
    //Ends the game
    public void EndGame(){
        System.out.println("wp gg");
    }
    //Checks if the virologist have all the genetic codes
    public boolean CheckGeneticCodes(Virologist v){

        System.out.println("You basically won like a Bantha, yes ");
        return true;
    }
    //Move the virologist to a random place
    public void RandomMovement(Virologist v){
        System.out.println("Am I drunk?");
    }
}
