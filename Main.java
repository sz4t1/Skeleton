import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        
        Integer input=0;
        Integer i = 0;
        Scanner sc = new Scanner(System.in);

        while(input!=-1){
            Menu.menuElements();
            input=sc.nextInt();
                    
            switch(input){
                case 0:{
                    sc.close();
                    System.exit(0); break;
                }
                case 1:{
                    while(i != -1){
                        Menu.testMenuElements();
                        i=sc.nextInt();
                        switch(i){
                            case 0:{
                                i = -1; break;
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
                    }
                    break;
                }
                case 2:{
                    CommandProcessor.readCommandLine(game);
                    break;
                }
                case 3:{

                    break;
                }
                case 4:{

                    break;
                }
                default:{}
            }
        }
    }
}
