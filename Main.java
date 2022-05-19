import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("|        The World of Wordless        |");
        
        Game game  = new Game();

        Scanner sc = new Scanner(System.in);

        MainMenuScreen mms = new MainMenuScreen(game);
      
        CommandProcessor.readCommandLine(sc, game);
    }
}
