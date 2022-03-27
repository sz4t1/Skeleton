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
                    Menu.CheckEnviroment(); break;
                }
                case 2:{
                    Menu.CraftVirus(); break;
                }
                case 3:{
                    Menu.DropEquipment(); break;
                }
                case 4:{
                    Menu.DropMaterial(); break;
                }
                case 5:{
                    Menu.EndGame(); break;
                }
                case 6:{
                    Menu.MoveVirologist(); break;
                }
                case 7:{
                    Menu.PickUpEquipment(); break;
                }
                case 8:{
                    Menu.PickUpMaterial(); break;
                }
                case 9:{
                    Menu.VirologistScans(); break;
                }
                case 10:{
                    Menu.StealEquipment(); break;
                }
                case 11:{
                    Menu.StealMaterial(); break;
                }
                case 12:{
                    Menu.UseVirusOnOtherVirologist(); break;
                }
                case 13:{
                    Menu.UseVirusOnSelf(); break;
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
