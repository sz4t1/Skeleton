import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println("|        The World of Wordless        |");
        
        Game game  = new Game();
        Integer input=0;
        Scanner sc = new Scanner(System.in);

       MainMenuScreen mms = new MainMenuScreen(game);

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
                    
                    CommandProcessor.readCommandLine(sc, game);
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
                        System.out.println("---------------------------------------");
                        System.out.println("[End Game]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_endgame.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_endgame.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 4:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Use Virus On Self]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_virusself.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_virusself.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 5:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Use Dance On Other Virologist]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_usedance.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_usedance.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Use Stun On Other Virologist]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_usestun.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_usestun.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 7:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Use Amnesia On Other Virologist]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_useamnesia.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_useamnesia.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 8:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Craft Dance Virus]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_craftdance.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_craftdance.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 9:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Craft Amnesia Virus]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_craftamnesia.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_craftamnesia.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 10:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Craft Stun Virus]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_craftstun.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_craftstun.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 11:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Craft Stun Virus]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_craftprotection.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_craftprotection.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 12:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Pick Up Equipment Drop Equipment Steal Equipment]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_equipment.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_equipment.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 13:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Attack Other Virologist With Axe]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_axeattack.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_axeattack.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 14:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Pick Up Material Steal Material Drop Material]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_material.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_material.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 15:{
                    try {
                        System.out.println("---------------------------------------");
                        System.out.println("[Use Up Glove]");
                        System.out.println("Initialization:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "init_useglove.txt");
                        System.out.println("---------------------------------------");
                        System.out.println("Output:");
                        System.out.println("---------------------------------------");
                        CommandProcessor.readCommandFile(game, "input_useglove.txt");
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
