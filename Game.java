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
        System.out.println("Game() - Game constructed.");
    }
    //Starts the game
    public void StartGame(){
        System.out.println("StartGame() - The game is started.");
        for(Virologist v : virologists){
            StepVirologist(v);
            if(CheckGeneticCodes(v)){
                System.out.println(v + " knows all the codes.");
                EndGame();
            }
            else{
                System.out.println(v + " doesn't know all the codes.");
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
    public void AddVirologist(Virologist v){
        System.out.println("AddVirologist(Virologist v) - New virologist added to the game.");
        virologists.add(v);
    }

    //virologist steps
    private void StepVirologist(Virologist v){
        System.out.println(v + " stepped.");
    }
}
