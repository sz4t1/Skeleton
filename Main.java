import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer input=0;
        Scanner sc = new Scanner(System.in);
        while(input!=-1){
            Menu.menuElements();
            input=sc.nextInt();

            switch(input){
                case 1:{
                    System.out.println("1. Check Environment"); break;
                }
                case 2:{
                    System.out.println("2. Craft Virus"); break;
                }
                case 3:{
                    System.out.println("3. Drop Equipment"); break;
                }
                case 4:{
                    System.out.println("4. Drop Material"); break;
                }
                case 5:{
                    System.out.println("5. End Game"); break;
                }
                case 6:{
                    System.out.println("6. Move Virologist"); break;
                }
                case 7:{
                    System.out.println("7. Pick Up Equipment"); break;
                }
                case 8:{
                    System.out.println("8. Pick Up Material"); break;
                }
                case 9:{
                    System.out.println("9. Scan Genetic"); break;
                }
                case 10:{
                    System.out.println("10. Steal Equipment"); break;
                }
                case 11:{
                    System.out.println("11. Steal Material"); break;
                }
                case 12:{
                    System.out.println("12. Use Virus On Other Virologist"); break;
                }
                case 13:{
                    System.out.println("13. Use Virus On Self"); break;
                }
                case 14:{
                    System.out.println("14."); break;
                }
                case 15:{
                    System.out.println("15."); break;
                }
                case 16:{
                    System.out.println("16."); break;
                }


            }
        }
    }


}
