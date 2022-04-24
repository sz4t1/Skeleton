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
                case 0:{
                    //Exit
                    sc.close();
                    System.out.println("Na csumi!!!");
                    System.exit(0);
                    break;
                }
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
                    CommandProcessor.readCommandFile(game, "input.txt");
                    break;
                }
                case 4:{
                    //Play

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
                    
                    break;
                }
                case 2:{
                    
                    break;
                }
                case 3:{
                    
                    break;
                }
                case 4:{
                    
                    break;
                }
                case 5:{
                    
                    break;
                }
                case 6:{
                    
                    break;
                }
                case 7:{
                    
                    break;
                }
                case 8:{
                    
                    break;
                }
                case 9:{
                    
                    break;
                }
                case 10:{
                   
                    break;
                }
                case 11:{
                   
                    break;
                }
                case 12:{
                    
                    break;
                }
                case 13:{
                    
                    break;
                }
                case 14:{
                    
                    break;
                }
                case 15:{
                    
                    break;
                }
                default:{}
            }
            game.clear();
        }
    }
}
