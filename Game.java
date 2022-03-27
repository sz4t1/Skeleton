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
        System.out.println("StartGame()");
    }
    //Ends the game
    public void EndGame(){
        System.out.println("EndGame()");
    }
    //Checks if the virologist have all the genetic codes
    public boolean CheckGeneticCodes(Virologist v){

        System.out.println("CheckGeneticCodes(Virologist v)");
        return true;
    }
    //Move the virologist to a random place
    public void RandomMovement(Virologist v){
        System.out.println("RandomMovement(Virologist v)");
    }
}
