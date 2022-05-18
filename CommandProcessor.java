import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class processes the commands.
 * It can read from the standard input or from files.
 */
public class CommandProcessor {
    
    /**
     * Reades the commands from the standard input.
     * @param game
     */
    public static void readCommandLine(Scanner sc, Game game) {
        //Here is stored the processCommand's return value, which is gona be the while loop's condition
        boolean readMore = true;

        /**
         * In this loop we read the commands and pass them on to the processCommand().
         * It breaks with an "exit" command
         */
        while(readMore) {
            String cmd;
            System.out.print(">");
            cmd = sc.nextLine();
            readMore = processCommand(game, cmd);
        }
    }

    /**
     * Read commands from a file
     * @param game
     * @param fileName
     * @throws FileNotFoundException
     */
    public static void readCommandFile(Game game, String fileName) throws FileNotFoundException {
  	
        BufferedReader br = new BufferedReader(new FileReader("tests/" + fileName));
        String line = null;
        while(true) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //If no more lines are found in the file, the while loop breaks
            if(line == null) break;
            processCommand(game, line);
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Processes the command
     * Returns with a bool, just for the readCommandLine's while loop, so it can break.
     * @param game
     * @param line
     * @return
     */
    private static boolean processCommand(Game game, String line){
        //To lower case, no need to pay attention when typing
        line = line.toLowerCase();
        //Parsing with at least one whitespace
	    String[] command = line.split(" +");
	    
	    switch(command[0]) 
	    {
            //ez csak a felesleges enterek végett jön jól
            case "": {
                return true;
            }
            //Create commands
            case "create": {
                //The Create commands always have 2 parameters: object type and name
                if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: Create <type> <name>");
                    return true;
                }

                switch(command[1]){
                    //virologist
                    case "virologist":{
                        game.AddVirologist(command[2], new Virologist());
                        break;
                    }
                    //fields
                    case "field": {
                        game.AddField(command[2], new Field());
                        break;
                    }
                    case "laboratory": {
                        game.AddField(command[2], new Laboratory());
                        break;
                    }
                    case "shelter": {
                        game.AddField(command[2], new Shelter());
                        break;
                    }
                    case "warehouse": {
                        game.AddField(command[2], new Warehouse());
                        break;
                    }
                    //recipes
                    case "amnesiarecipe": {
                        AmnesiaRecipe ar = new AmnesiaRecipe();
                        game.AddRecipe(command[2], ar);
                        break;
                    }
                    case "dancerecipe": {
                        DanceRecipe dr = new DanceRecipe();
                        game.AddRecipe(command[2], dr);
                        break;
                    }
                    case "stunrecipe": {
                        ParalyzingRecipe sr = new ParalyzingRecipe();
                       game.AddRecipe(command[2], sr);
                        break;
                    }
                    case "protectionrecipe": {
                        ProtectionRecipe pr = new ProtectionRecipe();
                        game.AddRecipe(command[2], pr);
                        break;
                    }
                    //viruses
                    case "amnesiavirus": {
                        Amnesia amn = new Amnesia();
                        game.AddVirus(command[2], amn);
                        break;
                    }
                    case "beardancevirus": {
                        BearDance bear = new BearDance();
                        game.AddVirus(command[2], bear);
                        break;
                    }
                    case "dancevirus": {
                        Dance dan = new Dance();
                        game.AddVirus(command[2], dan);
                        break;
                    }
                    case "stunvirus": {
                        Paralyzing par = new Paralyzing();
                       game.AddVirus(command[2], par);
                        break;
                    }
                    case "protectionvirus": {
                        Protection pro = new Protection();
                        game.AddVirus(command[2], pro);
                        break;
                    }
                    //materials
                    case "aminoacid": {
                        AminoAcid aa = new AminoAcid();
                        game.AddMaterial(command[2], aa);
                        break;
                    }
                    case "nukleotide": {
                        Nukleotide nu = new Nukleotide();
                        game.AddMaterial(command[2], nu);
                        break;
                    }
                    //equipments
                    case "axe": {
                        Axe axe = new Axe();
                        game.AddEquipment(command[2], axe);
                        break;
                    }
                    case "cape": {
                        Cape cape = new Cape();
                        game.AddEquipment(command[2], cape);
                        break;
                    }
                    case "glove": {
                        Glove glove = new Glove();
                        game.AddEquipment(command[2], glove);
                        break;
                    }
                    case "sack": {
                        Sack sack = new Sack();
                        game.AddEquipment(command[2], sack);
                        break;
                    }
                }
                return true;
            }
            //Connect two fields == making neighbors
            case "connectfields": {
                 //The ConnectFields commands always have 2 parameters: field1 and field2
                 if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: ConnectFields <target_1_name> <target_2_name>");
                    return true;
                }
                Field f1 = game.getField(command[1]);
                Field f2 = game.getField(command[2]);
                //Checking the two given fields' existence
                if(f1 == null || f2 == null){
                    System.out.println(line + " <=== Not existing fields.");
                    return true;
                }
                else{
                    f1.addNeighbour(f2);
                    f2.addNeighbour(f1);
                }
                return true;
            }
            //Add material to virologist
            case "addmaterial": {
                //The AddMaterial commands always have 2 parameters: virologist_name and material_name
                if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: AddMaterial <virologist_name> <material_name>");
                    return true;
                }
                Virologist viro = game.getVirologist(command[1]);
                Material m = game.getMaterial(command[2]);
                if(viro == null || m == null){
                    System.out.println(line + " <=== Not existing virologist or material.");
                    return true;
                }
               viro.addMaterial(m);
                return true;
            }
            //Add virus to virologist
            case "addvirus":{
                //The AddVirus commands always have 2 parameters: virologist and virus
                if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: ConnectFields <virologist_name> <virus_name>");
                    return true;
                }
                Virologist viro = game.getVirologist(command[1]);
                Virus v = game.getVirus(command[2]);
                //Checking the two given fields' existence
                if(viro == null || v == null){
                    System.out.println(line + " <=== Not existing virologist or virus.");
                    return true;
                }
                viro.AddVirus(v);
                return true;
            }
            //Put on equipment
            case "equip": {

                game.getVirologist(command[1]).addEquipment(game.getEquipment(command[2]));
                return true;
            }
            //Take off equipment
            case "unequip": {

                game.getVirologist(command[1]).removeEquipment(game.getEquipment(command[2]));
                return true;
            }
            //Steal material
            case "stealmaterial": {
                game.getVirologist(command[1]).StealMaterial(game.getVirologist(command[2]), game.getMaterial(command[3]));
                return true;
            }
            //Steal equipment
            case "stealequipment": {
                game.getVirologist(command[1]).StealEquipment(game.getVirologist(command[2]), game.getEquipment(command[3]));
                return true;
            }
            //Attack another virologist
            case "attack": {
                //The Attack commands always have 3 parameters: virologist, targeted_virologist and virus
                if(command.length != 4){
                    System.out.println(line + " <=== Bad parameters: Attack <attacking_virologist_name> <targeted_virologist_name> <virus_name>");
                    return true;
                }
                Virologist viroA = game.getVirologist(command[1]);
                Virologist viroT = game.getVirologist(command[2]);
                Virus v = game.getVirus(command[3]);
                //Checking the two given virologists' and the viruses existence
                if(viroA == null || viroT == null || v == null){
                    System.out.println(line + " <=== Not existing virologists or virus.");
                    return true;
                }
                viroA.Attack(v, viroT);
                return true;
            }
            //Use virus
            case "usevirusonself": {
                //The UseVirusOnSelf commands always have 2 parameters: virologist and virus
                if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: UseVirusOnSelf <virologist_name> <virus_name>");
                    return true;
                }
                Virologist viro = game.getVirologist(command[1]);
                Virus v = game.getVirus(command[2]);
                //Checking the two given fields' existence
                if(viro == null || v == null){
                    System.out.println(line + " <=== Not existing virologist or virus.");
                    return true;
                }
                viro.UseVirusOnSelf(v);
                return true;
            }

            //Move virologist
            case "move": {
                //The Move commands always have 2 parameters: virologist and directionField
                if(command.length != 3){
                    System.out.println(line + " <=== Bad parameters: Move <virologist_name> <target_field_name>");
                    return true;
                }
                Virologist v = game.getVirologist(command[1]);
                Field f = game.getField(command[2]);
                if(v == null || f == null){
                    System.out.println(line + " <=== Not existing virologist or field.");
                    return true;
                }
                v.Move(f);
                return true;
            }

            //Place virologist on field
            case "setfield": {
                game.getVirologist(command[1]).setField(game.getField(command[2]));
                return true;
            }
            //Get neighbours of field
            case "getneighbours": {
                game.getField(command[1]).getNeighbours();
                return true;
            }
            //Scan genetic code
            case "scancode": {
                //The Scancode commands always have 1 parameter: virologist
                if(command.length != 2){
                    System.out.println(line + " <=== Bad parameters: ScanCode <virologist_name>");
                    return true;
                }
                Virologist v = game.getVirologist(command[1]);
                if(v == null){
                    System.out.println(line + " <=== Not existing virologist.");
                    return true;
                }
                v.ScanCode();
                return true;
            }
            //Get MovementAbility
            case "getmovementability": {
                game.getVirologist(command[1]).getMovementAbility();
                return true;
            }
            //Return the number of genetic codes the virologist knows
            case "getgencodes": {
                System.out.println("GetGenCodes(): " + game.getVirologist(command[1]).getGenCodesAmmount());
                return true;
            }
            //Craft virus
            case "craftvirus": {
                game.getRecipe(command[1]).CreateVirus(game.getVirologist(command[2]));
                return true;
            }
            //Attack another virologist with axe
            case "attackwithaxe": {
                game.getVirologist(command[1]).AttackWithAxe(game.getVirologist(command[2]));
                return true;
            }
            //Virologist drops material
            case "dropmaterial": {
                game.getVirologist(command[1]).RemoveMaterial(game.getMaterial(command[2]));
                return true;
            }
            //Starts the game
            case "startgame": {
                game.StartGame();
                return true;
            }
            //Adds a genetic code to a virologist
            case "addgeneticcode": {
                game.getVirologist(command[1]).AddGeneticCode(Integer.parseInt(command[2]));
                return true;
            }
            //Listing the playing objects' names
            case "list": {
                switch(command[1]){
                    //virologist
                    case "virologists":{
                        for(String key : game.getVirologistNames()){
                            System.out.println("| " + key);
                        }
                        break;
                    }
                    //Fields
                    case "fields":{
                        for(String key : game.getFieldNames()){
                            System.out.println("| " + key);
                        }
                        break;
                    }
                }
                return true;
            }
            //Cleares the game
            case "cleargame": {
                game.clear();
                return true;
            }
             //Breaking the while loop with the return false
	    	case "exit": {
                return false;
            }
            default: {
                System.out.println(command[0] + " <=== Unknown command");
                return true;
            }
	    }
    }
}