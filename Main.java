import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer input=0;
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
                    Menu.StealCape(); break;
                }
                case 11:{
                    Menu.StealGlove(); break;
                }
                case 12:{
                    Menu.StealSack(); break;
                }
                case 13:{
                    Menu.StealMaterial(); break;
                }
                case 14:{
                    Menu.UseVirusOnOtherVirologistWithACape(); break;
                }
                case 15:{
                    Menu.UseVirusOnOtherVirologistWithGloves(); break;
                }
                case 16:{
                    Menu.UseVirusOnOtherVirologistWithNoProtection(); break;
                }
                case 17:{
                    Menu.UseVirusOnOtherVirologistWithProtectionVirusOn(); break;
                }
                case 18:{
                    Menu.UseAmnesiaOnSelf(); break;
                }
                case 19:{
                    Menu.UseDanceOnSelf(); break;
                }
                case 20:{
                    Menu.UseParalyzingOnSelf(); break;
                }
                case 21:{
                    Menu.UseProtectionOnSelf(); break;
                }
            }
        }
    }
}
