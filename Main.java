import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("|              PROTOTYPE              |");
        
        Game game = null;
        Integer input=0;
        Scanner sc = new Scanner(System.in);

        while(input!=-1){
            Menu.menuElements();
            input=sc.nextInt();
                    
            switch(input){
                case 1:{
                    //Tests
                    testMenu(sc, game);
                    break;
                }
                case 2:{
                    //Manual Testing
                    game  = new Game();
                    CommandProcessor.readCommandLine(sc, game);
                    break;
                }
                case 3:{
                    //Load Custom Test-File
                    game = new Game();
                    try {
                        CommandProcessor.readCommandFile(game, "input.txt");
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:{
                    //Play

                    break;
                }
                case 0:{
                    //Exit
                    sc.close();
                    System.out.println("Na csumi!!!");
                    System.exit(0);
                    break;
                }
                default:{}
            }
        }
    }

    /**
     * Ide mehetnek a tesztek, vagy azokat megvalósító függvényhívások
     * @param sc
     */
    private static void testMenu(Scanner sc, Game game){
        int i = 0;
        game = new Game();
        while(i != -1){
            Menu.testMenuElements();
            i = sc.nextInt();
            switch(i){
                case 0:{
                    //break the while loop = Back to Main Menu
                    i = -1;
                    break;
                }
                case 1:{
                    CommandProcessor.readCommandFile(game, "movevir_input.txt");
                    break;
                }
                case 2:{
                    CommandProcessor.readCommandFile(game, "scan_input.txt");
                    break;
                }
                case 3:{
                    CommandProcessor.readCommandFile(game, "endgame_input.txt");
                    break;
                }
                case 4:{
                    CommandProcessor.readCommandFile(game, "virusself_input.txt");
                    break;
                }
                case 5:{
                    CommandProcessor.readCommandFile(game, "usedance_input.txt");
                    break;
                }
                case 6:{
                    CommandProcessor.readCommandFile(game, "usestun_input.txt");
                    break;
                }
                case 7:{
                    CommandProcessor.readCommandFile(game, "useamnesia_input.txt");
                    break;
                }
                case 8:{
                    CommandProcessor.readCommandFile(game, "craftdance_input.txt");
                    break;
                }
                case 9:{
                    CommandProcessor.readCommandFile(game, "craftamnesia_input.txt");
                    break;
                }
                case 10:{
                    CommandProcessor.readCommandFile(game, "craftstun_input.txt")
                    break;
                }
                case 11:{
                    CommandProcessor.readCommandFile(game, "craftprotection_input.txt")
                    break;
                }
                case 12:{
                    CommandProcessor.readCommandFile(game, "equipment_input.txt")
                    break;
                }
                case 13:{
                    CommandProcessor.readCommandFile(game, "axeattack_input.txt")
                    break;
                }
                case 14:{
                    CommandProcessor.readCommandFile(game, "material_input.txt")
                    break;
                }
                case 15:{
                    CommandProcessor.readCommandFile(game, "useglove_input.txt")
                    break;
                }
                default:{}
            }
            game.clear();
        }
    }
}
