import java.util.Map;
import java.util.TreeMap;
//This class represents the game itself, it contains the players and the map
public class Game {
    //The virologist attribute contains the players in an arrayList
    private Map<String, Virologist> virologists;
    //This attribute contains the fields of the map
    private Map<String, Field> fields;
    //Ezeket a prototípus miatt ide beraktam, a végleges kódban nem biztos, hogy itt is tárolva lesznek
    private Map<String, Material> materials;
    private Map<String, Equipment> equipments;
    private Map<String, Virus> viruses;
    private Map<String, Recipe> recipes;

    //Constructor
    public Game(){
        virologists= new TreeMap<>();
        fields= new TreeMap<>();
        materials = new TreeMap<>();
        equipments = new TreeMap<>();
        viruses = new TreeMap<>();
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

    public void AddMaterial(String key, Material m){
        System.out.println("AddMaterial(String key, Material m) - New material added to the game.");
        materials.put(key, m);
    }
    public void AddEquipment(String key, Equipment e){
        System.out.println("AddEquipment(String key, Equipment e) - New equipment added to the game.");
        equipments.put(key, e);
    }
    public void AddVirus(String key, Virus v){
        System.out.println("AddVirus(String key, Virus v) - New virus added to the game.");
        viruses.put(key, v);
    }
    public void AddRecipe(String key, Recipe r){
        System.out.println("AddRecipe(String key, Recipe r) - New recipe added to the game.");
        recipes.put(key, r);
    }
    //Returns with a field
    public Field getField(String key){
        return fields.get(key);
    }

    //Returns with a virologist
    public Virologist getVirologist(String key)
    {
        return virologists.get(key);
    }
    public Material getMaterial(String key){
        return materials.get(key);
    }
    public Equipment getEquipment(String key){
        return equipments.get(key);
    }
    public Virus getVirus(String key){
        return viruses.get(key);
    }
    public Recipe getRecipe(String key){
        return recipes.get(key);
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
