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
                    Virologist vir1 = new Virologist();
                    Virologist vir2 = new Virologist();
                    vir2.AddGeneticCode(1);
                    game.StartGame();
                    game.EndGame();
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
                    Virologist vir1 = new Virologist();
                    Virologist vir2 = new Virologist();
                    Amnesia amn = new Amnesia();
                    Protection prot = new Protection();
                    vir1.Attack(amn, vir2);
                    vir2.getMovementAbility();
                    vir2.UseVirusOnSelf(prot);
                    vir1.Attack(amn, vir2);
                    vir2.getMovementAbility();
                    break;
                }
                case 8:{
                    CommandProcessor.readCommandFile(game, "craftdance_input.txt");
                    Virologist vir = new Virologist();
                    DanceRecipe dr = new DanceRecipe();
                    dr.CreateVirus(vir);
                    AminoAcid aa1 = new AminoAcid();
                    AminoAcid aa2 = new AminoAcid();
                    AminoAcid aa3 = new AminoAcid();
                    AminoAcid aa4 = new AminoAcid();
                    Nukleotide n1 = new Nukleotide();
                    Nukleotide n2 = new Nukleotide();
                    Nukleotide n3 = new Nukleotide();
                    Nukleotide n4 = new Nukleotide();
                    vir.addMaterial(aa1);
                    vir.addMaterial(aa2);
                    vir.addMaterial(aa3);
                    vir.addMaterial(aa4);
                    vir.addMaterial(n1);
                    vir.addMaterial(n2);
                    vir.addMaterial(n3);
                    vir.addMaterial(n4);
                    dr.CreateVirus(vir);
                    break;
                }
                case 9:{
                    CommandProcessor.readCommandFile(game, "craftamnesia_input.txt");
                    Virologist vir = new Virologist();
                    AmnesiaRecipe ar = new AmnesiaRecipe();
                    ar.CreateVirus(vir);
                    AminoAcid aa1 = new AminoAcid();
                    AminoAcid aa2 = new AminoAcid();
                    AminoAcid aa3 = new AminoAcid();
                    AminoAcid aa4 = new AminoAcid();
                    Nukleotide n1 = new Nukleotide();
                    Nukleotide n2 = new Nukleotide();
                    Nukleotide n3 = new Nukleotide();
                    Nukleotide n4 = new Nukleotide();
                    vir.addMaterial(aa1);
                    vir.addMaterial(aa2);
                    vir.addMaterial(aa3);
                    vir.addMaterial(aa4);
                    vir.addMaterial(n1);
                    vir.addMaterial(n2);
                    vir.addMaterial(n3);
                    vir.addMaterial(n4);
                    ar.CreateVirus(vir);
                    break;
                }
                case 10:{
                    CommandProcessor.readCommandFile(game, "craftstun_input.txt")
                    Virologist vir = new Virologist();
                    ParalyzingRecipe ar = new ParalyzingRecipe();
                    ar.CreateVirus(vir);
                    AminoAcid aa1 = new AminoAcid();
                    AminoAcid aa2 = new AminoAcid();
                    AminoAcid aa3 = new AminoAcid();
                    AminoAcid aa4 = new AminoAcid();
                    Nukleotide n1 = new Nukleotide();
                    Nukleotide n2 = new Nukleotide();
                    Nukleotide n3 = new Nukleotide();
                    Nukleotide n4 = new Nukleotide();
                    vir.addMaterial(aa1);
                    vir.addMaterial(aa2);
                    vir.addMaterial(aa3);
                    vir.addMaterial(aa4);
                    vir.addMaterial(n1);
                    vir.addMaterial(n2);
                    vir.addMaterial(n3);
                    vir.addMaterial(n4);
                    ar.CreateVirus(vir);
                    break;
                }
                case 11:{
                    CommandProcessor.readCommandFile(game, "craftprotection_input.txt")
                    Virologist vir = new Virologist();
                    ProtectionRecipe pr = new ProtectionRecipe();
                    pr.CreateVirus(vir);
                    AminoAcid aa1 = new AminoAcid();
                    AminoAcid aa2 = new AminoAcid();
                    AminoAcid aa3 = new AminoAcid();
                    AminoAcid aa4 = new AminoAcid();
                    Nukleotide n1 = new Nukleotide();
                    Nukleotide n2 = new Nukleotide();
                    Nukleotide n3 = new Nukleotide();
                    Nukleotide n4 = new Nukleotide();
                    vir.addMaterial(aa1);
                    vir.addMaterial(aa2);
                    vir.addMaterial(aa3);
                    vir.addMaterial(aa4);
                    vir.addMaterial(n1);
                    vir.addMaterial(n2);
                    vir.addMaterial(n3);
                    vir.addMaterial(n4);
                    pr.CreateVirus(vir);
                    break;
                }
                case 12:{
                    CommandProcessor.readCommandFile(game, "equipment_input.txt")
                    Virologist vir1 = new Virologist();
                    Virologist vir2 = new Virologist();
                    Equipment e1 = new Glove();
                    Equipment e2 = new Cape();
                    vir1.addEquipment(e1);
                    vir2.addEquipment(e2);
                    vir1.removeEquipment(e1);
                    vir1.StealEquipment(vir2, e2);
                    vir1.StealEquipment(vir2, e2);
                    break;
                }
                case 13:{
                    CommandProcessor.readCommandFile(game, "axeattack_input.txt")
                    Virologist vir = new Virologist();
                    Axe axe = new Axe();
                    Virologist vir2 = new Virologist();
                    vir.AttackWithAxe(vir2);
                    vir.addEquipment(axe);
                    vir.AttackWithAxe(vir2);
                    Virologist vir3 = new Virologist();
                    vir.AttackWithAxe(vir3);
                    break;
                }
                case 14:{
                    CommandProcessor.readCommandFile(game, "material_input.txt")
                    Virologist vir1 = new Virologist();
                    Virologist vir2 = new Virologist();
                    AminoAcid aa = new AminoAcid();
                    vir2.addMaterial(aa);
                    vir1.StealMaterial(vir2, aa);
                    vir1.StealMaterial(vir2, aa);
                    vir1.RemoveMaterial(aa);
                    break;
                }
                case 15:{
                    CommandProcessor.readCommandFile(game, "useglove_input.txt")
                    Virologist vir1 = new Virologist();
                    Virologist vir2 = new Virologist();
                    Glove g = new Glove();
                    Dance dance = new Dance();
                    Amnesia amn = new Amnesia();
                    Paralyzing stun = new Paralyzing();
                    vir2.addEquipment(g);
                    vir1.Attack(dance, vir2);
                    vir1.Attack(amn, vir2);
                    vir1.Attack(stun, vir2);
                    vir2.removeEquipment(g);
                    break;
                }
                default:{}
            }
            game.clear();
        }
    }
}
