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
    public static void readCommandLine(Scanner sc, Game game, Map<String, Material> materials, Map<String, Equipment> equipments, Map<String, Virus> viruses) {
        //Here is stored the processCommand's return value, which is gona be the while loop's condition
        boolean readMore = true;

        /**
         * In this loop we read the commands and pass them on to the processCommand().
         * It breaks with an "exit" command
         */
        while(readMore) {
            String cmd;
            cmd = sc.nextLine();
            readMore = processCommand(game, cmd, materials, equipments);
        }
    }

    /**
     * Read commands from a file
     * @param game
     * @param fileName
     * @throws FileNotFoundException
     */
    public static void readCommandFile(Game game, String fileName, Map<String, Material> materials, Map<String, Equipment> equipments, Map<String, Virus> viruses) throws FileNotFoundException {
  	
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = null;
        while(true) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                //hibakezelés.....
            }
            //If no more lines are found in the file, the while loop breaks
            if(line == null) break;
            processCommand(game, line, materials, equipments);
        }

        try {
            br.close();
        } catch (IOException e) {
            //hibakezelééééés ide
        }
    }

    /**
     * Processes the command
     * Returns with a bool, just for the readCommandLine's while loop, so it can break.
     * @param game
     * @param line
     * @return
     */
    private static boolean processCommand(Game game, String line, Map<String, Material> materials, Map<String, Equipment> equipments, Map<String, Virus> viruses){
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
                    System.out.println(line + " <=== NEM MEGFELELO PARAMÉTEREZÉS");
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
                    //viruses
                    case "amnesiavirus": {
                        Amnesia amn = new Amnesia();
                        viruses.put(command[2], amn);
                        break;
                    }
                    case "beardancevirus": {}
                    case "dancevirus": {
                        Dance dan = new Dance();
                        viruses.put(command[2], dan);
                        break;
                    }
                    case "stunvirus": {
                        Paralyzing par = new Paralyzing();
                        viruses.put(command[2], par);
                        break;
                    }
                    case "protectionvirus": {
                        Protection pro = new Protection();
                        viruses.put(command[2], pro);
                        break;
                    }
                    //materials
                    case "aminoacid": {
                        AminoAcid aa = new AminoAcid();
                        materials.put(command[2], aa);
                        break;
                    }
                    case "nukleotide": {
                        Nukleotide nu = new Nukleotide();
                        materials.put(command[2], nu);
                        break;
                    }
                    //equipments
                    case "axe": {}
                    case "cape": {
                        Cape cape = new Cape();
                        equipments.put(command[2], cape);
                        break;
                    }
                    case "glove": {
                        Glove glove = new Glove();
                        equipments.put(command[2], glove);
                        break;
                    }
                    case "sack": {
                        Sack sack = new Sack();
                        equipments.put(command[2], sack);
                        break;
                    }
                }
                return true;
            }
            //Connect two fields == making neighbors
            case "connectfields": {
                 //The ConnectFields commands always have 2 parameters: field1 and field2
                 if(command.length != 3){
                    System.out.println(line + " <=== NEM MEGFELELO PARAMÉTEREZÉS");
                    return true;
                }
                //Checking the two given fields' existence
                if(!game.fieldsExist(command[1], command[2])){
                    System.out.println(line + " <=== NEM LÉTEZIK AZ EGYIK VAGY MINDKÉT MEZo, VAGY ROSSZ NEVET/NEVEKET ADTAL MEG");
                    return true;
                }
                game.getField(command[1]).addNeighbour(game.getField(command[2]));
                game.getField(command[2]).addNeighbour(game.getField(command[1]));
                return true;
            }
            //Breaking the while loop with the return false
	    	case "exit": {
                return false;
            }
            //Add material to virologist
            case "addmaterial": {

                game.getVirologist(command[1]).addMaterial(materials.get(command[2]));

            }
            //Put on equipment
            case "equip": {

                game.getVirologist(command[1]).addEquipment(equipments.get(command[2]));

            }
            //Take off equipment
            case "unequip": {

                game.getVirologist(command[1]).removeEquipment(equipments.get(command[2]));

            }
            //Steal material
            case "stealmaterial": {
                game.getVirologist(command[1]).StealMaterial(game.getVirologist(command[2]), materials.get(command[3]));
                break;
            }
            //Steal equipment
            case "stealequipment": {
                game.getVirologist(command[1]).StealEquipment(game.getVirologist(command[2]), equipments.get(command[3]));
                break;
            }
            //Attack another virologist
            case: "attack": {
                game.getVirologist(command[1]).Attack(viruses.command[3], game.getVirologist(command[2]));
                break;
            }
            //Use virus
            case "usevirusonself": {
                game.getVirologist(command[1]).UseVirusOnSelf(viruses.get(command[2]));
                break;
            } 
            default: {
                System.out.println(command[0] + " <=== ISMERETLEN PARANCS");
                return true;
            }
	    }
    }
}