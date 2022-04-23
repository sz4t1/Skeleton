import java.util.Map;
import java.util.TreeMap;
//This class represents the game itself, it contains the players and the map
public class Game {
    //The virologist attribute contains the players in an arrayList
    private Map<String, Virologist> virologists;
    //This attribute contains the fields of the map
    private Map<String, Field> fields;
    //Constructor
    public Game(){
        virologists= new TreeMap<>();
        fields= new TreeMap<>();
        System.out.println("Game() - Game constructed.");
    }
    //Starts the game
    public void StartGame(){
        System.out.println("StartGame() - The game is started.");
        for(String key : virologists.keySet()){
            StepVirologist(virologists.get(key));
            if(CheckGeneticCodes(virologists.get(key))){
                System.out.println(key + " knows all the codes.");
                EndGame();
            }
            else{
                System.out.println(key + " doesn't know all the codes.");
            }
        }
    }
    //Ends the game
    public void EndGame(){
        System.out.println("EndGame() - The game has ended.");
    }
    //Checks if the virologist have all the genetic codes
    public boolean CheckGeneticCodes(Virologist v){

        System.out.println("CheckGeneticCodes(Virologist v) - Checking for the win conditions.");
        //A teszteset egyszerűsítéséért igazat ad, ha legalább egy elemet ismer, hamisat, ha egyet sem
        return !(v.getGenCodes().isEmpty());
    }
    //Move the virologist to a random place
    public void RandomMovement(Virologist v){
        System.out.println("RandomMovement(Virologist v) - The virologist is moved randomly.");
    }
    //Adds a virologist to the game
    //Nem feltétlenül marad meg, a szkeletonhoz kellett egy publikus függvény, mellyel virológust lehet a game-hez adni
    public void AddVirologist(String key, Virologist v){
        System.out.println("AddVirologist(String key, Virologist v) - New virologist added to the game.");
        virologists.put(key, v);
    }

    public void AddField(String key, Field f){
        System.out.println("AddField(String key, Field f) - New field added to the game.");
        fields.put(key, f);
    }

    //Returns with a field
    public Field getField(String key){
        return fields.get(key);
    }

    //Checks, if both fields exist in this game
    public boolean fieldsExist(String k1, String k2){
        return (fields.containsKey(k1) && fields.containsKey(k2));
    }

    //virologist steps
    private void StepVirologist(Virologist v){
        System.out.println(v + " stepped.");
    }

    //Clears the game object: all Virologists, fields, ... should be removed from this object
    public void clear(){
        virologists.clear();
        fields.clear();
    }
}
