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
    //Ezek a prototípusnál kellettek, most per pillanat haszontalanok
    private Map<String, Equipment> equipments;
    private Map<String, Virus> viruses;
    private Map<String, Recipe> recipes;

    private int numberOfLaboratories;

    private int Round = 1;
    private int activeVirologistIndex = 0;
    private int stepCount = 2;

    private GameScreen gameScreen;

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
    //Changes the activeVirologist to the next one
    public void NextVirologist(){
        stepCount = 2;
        activeVirologistIndex += 1;
        if(activeVirologistIndex >= virologists.size()){
            activeVirologistIndex = 0;
            Round++;
        }

        

        //Check for movement restrictions!!!!
    }

    //TODO - ezen változtatni kell!!!!!!
    //Starts the game
    public void StartGame(){
        System.out.println("StartGame() - The game is started.");
        //Counting all the laboratories, because all of them have a unique genetic code
        for(String key : fields.keySet()){
            numberOfLaboratories += fields.get(key).LabCount();
        }

        for(String key : virologists.keySet()){
            //StepVirologist(virologists.get(key));
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

    //GETTERS AND SETTERS//////////////////////////

    public int GetRound(){
        return Round;
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

    public int getActiveVirologistIndex(){
        return activeVirologistIndex;
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

    //returns with the virologists arrayList
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

    //returns with the active wirologist's name
    public String getActiveVirologistName(){
        ArrayList<String> nameList = new ArrayList<String>(virologists.keySet());
        return nameList.get(activeVirologistIndex);
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

    public void setGameScreen(GameScreen gs){
        gameScreen = gs;
    }

    //COMMANDS OF STEPS///////////////

    //The active virologist attacks another one with vorus or axe
    //If the attack was successful, the stepCounter decrements
    //If the stepCounter reaches 0, the activeVirologist will change
    public void AttackCommand(String virologist, String virus, boolean axe){
        boolean validCommand = false;
        //attack with virus
        Virus v = null;
        for(Virus vir : virologists.get(getActiveVirologistName()).getViruses()){
            if(vir.getName().equals(virus)){
                v = vir;
            }
        }

        if(virus != null && !axe){
            validCommand = virologists.get(getActiveVirologistName()).Attack(v, virologists.get(virologist));
            if(validCommand){
                stepCount -= 1;
            }
        }
        else if(virus == null && axe){
            //attack with axe
            validCommand = virologists.get(getActiveVirologistName()).AttackWithAxe(virologists.get(virologist));
            if(validCommand){
                stepCount -= 1;
            }
        }
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    //Moves the active virologist to the new destination
    //If the move is successful, the stepCounter decrements
    //If the stepCounter reaches 0, the activeVirologist will change
    public void MoveCommand(String fName){
        boolean validCommand = false;
        Field field = fields.get(fName);
        validCommand = virologists.get(getActiveVirologistName()).Move(field);
        if(validCommand){
            stepCount -= 1;
        }
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    //The active virologist crafts a virus
    //If the craft is successful, the stepCounter decrements
    //If the stepCounter reaches 0, the activeVirologist will change
    public void CraftCommand(String virus){
        boolean validCommand = false;
        switch (virus){
            case "Amnesia":{
                validCommand = virologists.get(getActiveVirologistName()).CraftVirus(new AmnesiaRecipe());
                break;
            }
            case "Protection":{
                validCommand = virologists.get(getActiveVirologistName()).CraftVirus(new ProtectionRecipe());
                break;
            }
            case "Paralyzing":{
                validCommand = virologists.get(getActiveVirologistName()).CraftVirus(new ParalyzingRecipe());
                break;
            }
            case "Dance":
                validCommand = virologists.get(getActiveVirologistName()).CraftVirus(new DanceRecipe());
                break;
            default:{
            }   
        }
        if(validCommand){
            stepCount -= 1;
        }
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    //Scans the field
    //It always decrements the stepCounter
    //Checks the genCodeCountre
    //If the stepCounter reaches 0, the activeVirologist will change
    public void ScanCommand(){
        virologists.get(getActiveVirologistName()).ScanCode();
        stepCount -= 1;

        if(CheckGeneticCodes(virologists.get(getActiveVirologistName()))){
            System.out.println(getActiveVirologistName() + " knows all the codes.");
            EndGame();
        }

        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    public void PickUpCommand(int am, int nuk, int axe, int cape, int glove, int sack){
        boolean validCommand = false;
        if (am > 0 || nuk > 0) {
            ArrayList<Material> mats;
            ArrayList<Material> removemats= new ArrayList<>();
            mats = virologists.get(getActiveVirologistName()).getField().getMaterials();
            int max= virologists.get(getActiveVirologistName()).getField().getMaterials().size();
            for(int j=0;j<am;j++)
                for (int i=0;i<mats.size();i++){
                    if(mats.get(i).getName().equals("aminoacid")){
                        virologists.get(getActiveVirologistName()).addMaterial(mats.get(i));
                        virologists.get(getActiveVirologistName()).getField().Remove(null, mats.get(i),null);
                        mats=virologists.get(getActiveVirologistName()).getField().getMaterials();
                        break;
                    }
                }

            for(int j=0;j<nuk;j++)
                for (int i=0;i<mats.size();i++){
                    if(mats.get(i).getName().equals("nukleotide") ){
                        virologists.get(getActiveVirologistName()).addMaterial(mats.get(i));
                        virologists.get(getActiveVirologistName()).getField().Remove(null, mats.get(i),null);
                        mats=virologists.get(getActiveVirologistName()).getField().getMaterials();
                        break;
                    }
                }

            validCommand = true;
        } else if (axe > 0 || cape > 0 || glove > 0 || sack > 0) {

            ArrayList<Equipment> equips;
            equips = virologists.get(getActiveVirologistName()).getField().getEquipment();
            System.out.println(equips.size());
            if(equips.size()==1){
                virologists.get(getActiveVirologistName()).AddEquipment(equips.get(0));
            }
            validCommand = true;
        }
        if(validCommand){
            stepCount -= 1;
        }
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    public void DropCommand(int am, int nuk, int axe, int cape, int glove, int sack){
        boolean validCommand = false;
        ArrayList<Material> mat = virologists.get(getActiveVirologistName()).getMaterials();
        if(am != 0){
            int i = am;
            for (int ind = 0; ind < mat.size(); ind++) {
                if(mat.get(ind).getName().equals("aminoacid") && i > 0){
                    i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveMaterial(mat.get(ind));
                }
            }
        }
        if(nuk != 0){
            int i = nuk;
            for (int ind = 0; ind < mat.size(); ind++) {
                if(mat.get(ind).getName().equals("nukleotide") && i > 0){
                     i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveMaterial(mat.get(ind));
                }
            }
        }

        ArrayList<Equipment> equ = virologists.get(getActiveVirologistName()).getEquipments();
        if(axe != 0){
            int i = axe;
            for (int ind = 0; ind < equ.size(); ind++) {
                if(equ.get(ind).getName().equals("axe") && i > 0){
                     i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveEquipment(equ.get(ind));
                }
            }
        }
        if(cape != 0){
            int i = cape;
            for (int ind = 0; ind < equ.size(); ind++) {
                if(equ.get(ind).getName().equals("cape") && i > 0){
                     i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveEquipment(equ.get(ind));
                }
            }
        }
        if(glove != 0){
            int i = glove;
            for (int ind = 0; ind < equ.size(); ind++) {
                if(equ.get(ind).getName().equals("glove") && i > 0){
                     i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveEquipment(equ.get(ind));
                }
            }
        }
        if(sack != 0){
            int i = sack;
            for (int ind = 0; ind < equ.size(); ind++) {
                if(equ.get(ind).getName().equals("sack") && i > 0){
                     i--;
                    validCommand = virologists.get(getActiveVirologistName()).RemoveEquipment(equ.get(ind));
                }
            }
        }
        if(validCommand){
            stepCount -= 1;
        }
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    public void UseVirusCommand(String virus){
        if(virus == null){
            return;
        }
        for(Virus v : virologists.get(getActiveVirologistName()).getViruses()){
            if(v.getName().equals(virus)){
                virologists.get(getActiveVirologistName()).UseVirusOnSelf(v);
                break;
            }
        }
        stepCount -= 1;
        if(stepCount <= 0){
            NextVirologist();
        }
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    public void StealCommand(int am, int nuk, int axe, int cape, int glove, int sack){
        //TODO
        gameScreen.UpdateScreenData(virologists.get(getActiveVirologistName()));
    }

    //EZ NEM HISZEM, HOGY KELL!!!!!
    /*
    //virologist steps
    private void StepVirologist(Virologist v){
        System.out.println(v + " stepped.");
    }
    */

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
        //counting the laboratories
        for(String key : fields.keySet()){
            numberOfLaboratories += fields.get(key).LabCount();
        }
        

    }

    private void BuildMap(){

        for(int i=1;i<=14;i++){
            fields.put("Field"+i,new Field());
            fields.get("Field"+i).setName("Field"+i);
        }
        for(int i=1;i<=4;i++) {
            fields.put("Warehouse" + i, new Warehouse());
            fields.get("Warehouse" + i).setName("Warehouse" + i);
        }
        for(int i=1;i<=2;i++) {
            fields.put("Shelter" + i, new Shelter());
            fields.get("Shelter" + i).setName("Shelter" + i);
        }
        for(int i=1;i<=5;i++) {
            fields.put("Laboratory" + i, new Laboratory());
            fields.get("Laboratory"+i).setName("Laboratory"+i);
        }
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
