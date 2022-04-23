import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class processes the commands.
 * It can read from the standard input or from files.
 */
public class CommandProcessor {
    private Game game;

    public CommandProcessor(Game g){
        setGame(g);
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Reades the commands from the standard input.
     */
    public void readCommandLine() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Here is stored the processCommand's return value, which is gona be the while loop's condition
        boolean readMore = true;

        /**
         * In this loop we read the commands and pass them on to the processCommand().
         * It breaks with an "exit" command
         */
        while(readMore) {
            String cmd;
            try {
                cmd = br.readLine();
                readMore = processCommand(cmd);
            } catch (IOException e) {
                //itt loggolni kéne vagy nem tom...
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            //itt is loggolni kell...?
        }
    }

    /**
     * Read commands from a file
     * @param fileName
     * @throws FileNotFoundException
     */
    public void readCommandFile(String fileName) throws FileNotFoundException {
  	
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = null;
        while(true) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                //hibakezelés.....
            }
            if(line == null) break;
            processCommand(line);
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
     * @param line
     * @return
     */
    private boolean processCommand(String line){
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
	    	case "exit": {
                return false;
            }
            default: {
                System.out.println("Ismeretlen parancs");
                return true;
            }
	    }
    }
}
