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
                        //hibakezelés ideeee
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
                case 1:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Move Virologist]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_movevir.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_movevir.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 2:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Scan Genetic Code]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_scan.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_scan.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 3:{
                    try {
                        CommandProcessor.readCommandFile(game, "endgame_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:{
                    try {
                        CommandProcessor.readCommandFile(game, "virusself_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:{
                    try {
                        CommandProcessor.readCommandFile(game, "usedance_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6:{
                    try {
                        CommandProcessor.readCommandFile(game, "usestun_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7:{
                    try {
                        CommandProcessor.readCommandFile(game, "useamnesia_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8:{
                    try {
                        CommandProcessor.readCommandFile(game, "craftdance_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 9:{
                    try {
                        CommandProcessor.readCommandFile(game, "craftamnesia_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 10:{
                    try {
                        CommandProcessor.readCommandFile(game, "craftstun_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 11:{
                    try {
                        CommandProcessor.readCommandFile(game, "craftprotection_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 12:{
                    try {
                        CommandProcessor.readCommandFile(game, "equipment_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 13:{
                    try {
                        CommandProcessor.readCommandFile(game, "axeattack_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 14:{
                    try {
                        CommandProcessor.readCommandFile(game, "material_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 15:{
                    try {
                        CommandProcessor.readCommandFile(game, "useglove_input.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 0:{
                    //break the while loop = Back to Main Menu
                    i = -1;
                    break;
                }
                default:{}
            }
            game.clear();
        }
    }
}
