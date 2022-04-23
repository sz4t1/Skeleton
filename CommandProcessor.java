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
            processCommand(game, line);
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
                    case "amnesiavirus": {}
                    case "beardancevirus": {}
                    case "dancevirus": {}
                    case "stunvirus": {}
                    case "protectionvirus": {}
                    //materials
                    case "aminoacid": {}
                    case "nukleotide": {}
                    //equipments
                    case "axe": {}
                    case "cape": {}
                    case "glove": {}
                    case "sack": {}
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
            default: {
                System.out.println(command[0] + " <=== ISMERETLEN PARANCS");
                return true;
            }
	    }
    }
}
