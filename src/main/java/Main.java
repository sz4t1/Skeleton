package src.main.java;

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
                    System.out.println("2. Craft src.main.java.Virus"); break;
                }
                case 3:{
                    System.out.println("3. Drop src.main.java.Equipment"); break;
                }
                case 4:{
                    System.out.println("4. Drop src.main.java.Material"); break;
                }
                case 5:{
                    System.out.println("5. End src.main.java.Game"); break;
                }
                case 6:{
                    System.out.println("6. Move src.main.java.Virologist"); break;
                }
                case 7:{
                    System.out.println("7. Pick Up src.main.java.Equipment"); break;
                }
                case 8:{
                    System.out.println("8. Pick Up src.main.java.Material"); break;
                }
                case 9:{
                    System.out.println("9. Scan Genetic"); break;
                }
                case 10:{
                    System.out.println("10. Steal src.main.java.Equipment"); break;
                }
                case 11:{
                    System.out.println("11. Steal src.main.java.Material"); break;
                }
                case 12:{
                    System.out.println("12. Use src.main.java.Virus On Other src.main.java.Virologist"); break;
                }
                case 13:{
                    System.out.println("13. Use src.main.java.Virus On Self"); break;
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
