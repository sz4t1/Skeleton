//package src;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
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

    private int numberOfLaboratories;

    //Constructor
    public Game(){
        virologists= new TreeMap<>();
        fields= new TreeMap<>();
        materials = new TreeMap<>();
        equipments = new TreeMap<>();
        viruses = new TreeMap<>();
        recipes = new TreeMap<>();
        numberOfLaboratories = 0;
        System.out.println("Game() - Game constructed.");
    }

    //TODO
    public int GetRound(){
        return 0;
    }

    //Starts the game
    public void StartGame(){
        System.out.println("StartGame() - The game is started.");
        //Counting all the laboratories, because all of them have a unique genetic code
        for(String key : fields.keySet()){
            numberOfLaboratories += fields.get(key).LabCount();
        }

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
        System.out.println("Score Board:");
        System.out.println("-------------------------");
        for(String key : virologists.keySet()){
            System.out.println("| " + key + ": " + virologists.get(key).getGenCodesAmmount());
        }
        System.out.println("-------------------------");
        clear();
    }
    //Checks if the virologist have all the genetic codes
    public boolean CheckGeneticCodes(Virologist v){
        System.out.println("CheckGeneticCodes(Virologist v) - Checking for the win conditions.");
        //returns true if the virologist has that many gen. codes, as many laboratories are in the game
        return (v.getGenCodesAmmount() == numberOfLaboratories);
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

    public ArrayList<Field> getFields(){
        ArrayList<Field> fs = new ArrayList<Field>();
        for(String key : fields.keySet()){
            fs.add(fields.get(key));
        }
        return fs;
    }

    //Returns with the names of the fields
    public Set<String> getFieldNames(){
        
        return fields.keySet();
    }

    //Returns with a virologist
    public Virologist getVirologist(String key)
    {
        return virologists.get(key);
    }

    public ArrayList<Virologist> getVirologists(){
        ArrayList<Virologist> fs = new ArrayList<Virologist>();
        for(String key : virologists.keySet()){
            fs.add(virologists.get(key));
        }
        return fs;
    }

    //returns with the names of the virologists
    public Set<String> getVirologistNames(){
        return virologists.keySet();
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

    //Clears the game object: all Virologists, fields, ... should be removed from this object after a game ends
    public void clear(){
        virologists.clear();
        fields.clear();
        materials.clear();
        equipments.clear();
        viruses.clear();
        recipes.clear();
        numberOfLaboratories = 0;
    }

    //creates a new game
    public void NewGame(int virNumber){
        clear();
        //Building the Map
        BuildMap();
        //Adding virologists
        Random r = new Random();
        for(int i = 1; i <= virNumber; i++){
            String name = "Virologist" + i;
            AddVirologist(name, new Virologist(name));

            //Placeing the Virologists
            int fieldNum = r.nextInt(14) + 1;
            String fieldName = "Field" + fieldNum;
            virologists.get(name).setField(fields.get(fieldName));
        }
        
        

    }

    private void BuildMap(){


        for(int i=1;i<=14;i++)
            fields.put("Field"+i,new Field());
        for(int i=1;i<=4;i++)
            fields.put("Warehouse"+i,new Warehouse());
        for(int i=1;i<=2;i++)
            fields.put("Shelter"+i,new Shelter());
        for(int i=1;i<=5;i++)
            fields.put("Laboratory"+i,new Laboratory());
        BuildMapHelper(fields.get("Shelter1"),fields.get("Warehouse4"));
        BuildMapHelper(fields.get("Shelter1"),fields.get("Field3"));

        BuildMapHelper(fields.get("Warehouse4"),fields.get("Field4"));
        BuildMapHelper(fields.get("Warehouse4"),fields.get("Field1"));

        BuildMapHelper(fields.get("Field1"),fields.get("Field5"));
        BuildMapHelper(fields.get("Field1"),fields.get("Field2"));

        BuildMapHelper(fields.get("Field2"),fields.get("Laboratory3"));
        BuildMapHelper(fields.get("Field2"),fields.get("Field6"));

        BuildMapHelper(fields.get("Laboratory3"),fields.get("Field7"));

        BuildMapHelper(fields.get("Field3"),fields.get("Field4"));
        BuildMapHelper(fields.get("Field3"),fields.get("Laboratory5"));

        BuildMapHelper(fields.get("Field4"),fields.get("Field5"));
        BuildMapHelper(fields.get("Field4"),fields.get("Laboratory4"));

        BuildMapHelper(fields.get("Field5"),fields.get("Field6"));
        BuildMapHelper(fields.get("Field5"),fields.get("Warehouse1"));

        BuildMapHelper(fields.get("Field6"),fields.get("Field7"));
        BuildMapHelper(fields.get("Field6"),fields.get("Field8"));

        BuildMapHelper(fields.get("Field7"),fields.get("Warehouse3"));

        BuildMapHelper(fields.get("Laboratory5"),fields.get("Field9"));
        BuildMapHelper(fields.get("Laboratory5"),fields.get("Laboratory4"));

        BuildMapHelper(fields.get("Laboratory4"),fields.get("Field10"));
        BuildMapHelper(fields.get("Laboratory4"),fields.get("Warehouse1"));

        BuildMapHelper(fields.get("Warehouse1"),fields.get("Field11"));
        BuildMapHelper(fields.get("Warehouse1"),fields.get("Field8"));

        BuildMapHelper(fields.get("Field8"),fields.get("Warehouse3"));
        BuildMapHelper(fields.get("Field8"),fields.get("Field12"));

        BuildMapHelper(fields.get("Warehouse3"),fields.get("Field13"));

        BuildMapHelper(fields.get("Field9"),fields.get("Warehouse2"));
        BuildMapHelper(fields.get("Field9"),fields.get("Field10"));

        BuildMapHelper(fields.get("Field10"),fields.get("Field11"));
        BuildMapHelper(fields.get("Field10"),fields.get("Laboratory1"));

        BuildMapHelper(fields.get("Field11"),fields.get("Field12"));
        BuildMapHelper(fields.get("Field11"),fields.get("Field14"));

        BuildMapHelper(fields.get("Field12"),fields.get("Field13"));
        BuildMapHelper(fields.get("Field12"),fields.get("Shelter2"));

        BuildMapHelper(fields.get("Field13"),fields.get("Laboratory2"));

        BuildMapHelper(fields.get("Warehouse2"),fields.get("Laboratory1"));

        BuildMapHelper(fields.get("Laboratory1"),fields.get("Field14"));

        BuildMapHelper(fields.get("Field14"),fields.get("Shelter2"));

        BuildMapHelper(fields.get("Shelter2"),fields.get("Laboratory2"));


    }
    private static void BuildMapHelper(Field first, Field second){
        first.addNeighbour(second);
        second.addNeighbour(first);
    }
}
