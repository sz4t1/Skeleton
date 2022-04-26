public class Menu {
    public static void menuElements(){
        System.out.println("=======================================");

        System.out.println("1. Tests");
        System.out.println("2. Manual Testing");
        System.out.println("3. Load Custom Test-File");
        System.out.println("4. Play");

        System.out.println("\n0. Exit Prototype");
        System.out.println("=======================================");
    }

    public static void testMenuElements(){
        System.out.println("=======================================");

        System.out.println("1. Move virologist and check neighbours");
        System.out.println("2. Scan genetic");
        System.out.println("3. End Game");
        System.out.println("4. Use Virus On Self");
        System.out.println("5. Use Dance On Other Virologist");
        System.out.println("6. Use Stun On Other Virologist");
        System.out.println("7. Use Amnesia On Other Virologist");
        System.out.println("8. Craft Dance");
        System.out.println("9. Craft Amnesia");
        System.out.println("10. Craft Stun");
        System.out.println("11. Craft Protection");
        System.out.println("12. Pick Up Equipment Drop Equipment Steal Equipment");
        System.out.println("13. Attack Other Virologist With Axe");
        System.out.println("14. Pick Up Material Steal Material Drop Material");
        System.out.println("15. Use Up Glove");

        System.out.println("\n0. Return to Main Menu");
        System.out.println("=======================================");
    }

    //ezek még a szkeletonból maradtak, ezek alapján lehet teszteket ítni, végül törölve lesznek

    public static void CheckEnviroment(){
        System.out.println("---------------------------------------");
        System.out.println("[Check Environment]");
        //Init
        Virologist vir= new Virologist();
        Field field= new Field();
        Laboratory laboratory= new Laboratory();
        Shelter shelter= new Shelter();
        field.addNeighbour(laboratory);
        field.addNeighbour(shelter);
        vir.setField(field);
        //testcase
        System.out.println(".......................................");
        field.getNeighbours();
    }

    public static void CraftVirus(){
        System.out.println("---------------------------------------");
        System.out.println("[Craft Virus]");
        //Init
        Virologist vir= new Virologist();
        AmnesiaRecipe amnesiaRecipe= new AmnesiaRecipe();
        //Testcase
        System.out.println(".......................................");
        vir.CraftVirus(amnesiaRecipe);

    }

    public static void DropEquipment(){
        System.out.println("---------------------------------------");
        System.out.println("[Drop Equipment]");
        //Init
        Virologist vir= new Virologist();
        Cape cape= new Cape();
        vir.addEquipment(cape);
        //Testcase
        System.out.println(".......................................");
        vir.RemoveEquipment(cape);
    }

    public static void DropMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Drop Material]");
        //Init
        Virologist vir= new Virologist();
        AminoAcid aminoAcid= new AminoAcid();
        vir.addMaterial(aminoAcid);
        //Testcase
        System.out.println(".......................................");
        vir.RemoveMaterial(aminoAcid);
    }

    public static void EndGame(){
        System.out.println("---------------------------------------");
        System.out.println("[End Game]");
        //Init
        Game game= new Game();
        Virologist vir1= new Virologist();
        Virologist vir2= new Virologist();
        game.AddVirologist("A", vir1);
        game.AddVirologist("B", vir2);
        vir2.AddGeneticCode(1);
        //Testcase
        System.out.println(".......................................");
        game.StartGame();
        
    }

    public static void MoveVirologist(){
        System.out.println("---------------------------------------");
        System.out.println("[Move Virologist]");
        //Init
        Virologist vir= new Virologist();
        Field field= new Field();
        Field direction = new Field();
        field.addNeighbour(direction);
        vir.setField(field);
        //TestCase
        System.out.println(".......................................");
        vir.Move(direction);
    }

    public static void PickUpEquipment(){
        System.out.println("---------------------------------------");
        System.out.println("[Pick Up Equipment]");
        //Init
        Virologist vir= new Virologist();
        Shelter shelter= new Shelter();
        Cape cape= new Cape();
        vir.setField(shelter);
        shelter.setEquipment(cape);
        //Testcase
        System.out.println(".......................................");
        vir.AddEquipment(shelter.getEquipment());
    }

    public static void PickUpMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Pick Up Material]");
        //Init
        Virologist vir= new Virologist();
        Warehouse warehouse= new Warehouse();
        AminoAcid aminoAcid= new AminoAcid();
        vir.setField(warehouse);
        warehouse.addMaterial(aminoAcid);
        //Testcase
        System.out.println(".......................................");
        vir.AddMaterial(aminoAcid);
    }

    public static void VirologistScans(){
        System.out.println("---------------------------------------");
        System.out.println("[Virologist Scans]");
        //Init
        Virologist vir= new Virologist();
        Laboratory lab = new Laboratory();
        vir.setField(lab);
        //Testcase
        System.out.println(".......................................");
        vir.ScanCode();

    }

    public static void StealCape(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Cape]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Cape cape= new Cape();
        vir2.addEquipment(cape);
        //Testcase
        System.out.println(".......................................");
        vir.StealEquipment(vir2,cape);
    }

    public static void StealGlove(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Glove]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Glove glove= new Glove();
        vir2.addEquipment(glove);
        //Testcase
        System.out.println(".......................................");
        vir.StealEquipment(vir2,glove);
    }

    public static void StealSack(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Sack]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Sack sack= new Sack();
        vir2.addEquipment(sack);
        //Testcase
        System.out.println(".......................................");
        vir.StealEquipment(vir2,sack);
    }

    public static void StealMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Material]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        AminoAcid aminoAcid= new AminoAcid();
        vir2.addMaterial(aminoAcid);
        //Testcase
        System.out.println(".......................................");
        vir.StealMaterial(vir2,aminoAcid);
    }

    public static void UseVirusOnOtherVirologistWithACape(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Virus On Other Virologist With A Cape]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Amnesia amnesia= new Amnesia();
        vir.AddVirus(amnesia);
        Cape cape = new Cape();
        vir2.addEquipment(cape);
        //Testcase
        System.out.println(".......................................");
        vir.Attack(amnesia,vir2);
    }

    public static void UseVirusOnOtherVirologistWithGloves(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Virus On Other Virologist With Gloves]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Amnesia amnesia= new Amnesia();
        vir.AddVirus(amnesia);
        Glove glove = new Glove();
        vir2.addEquipment(glove);
        //Testcase
        System.out.println(".......................................");
        vir.Attack(amnesia,vir2);
    }

    public static void UseVirusOnOtherVirologistWithNoProtection(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Virus On Other Virologist With No Protection]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Amnesia amnesia= new Amnesia();
        vir.AddVirus(amnesia);
        //Testcase
        System.out.println(".......................................");
        vir.Attack(amnesia,vir2);
    }

    public static void UseVirusOnOtherVirologistWithProtectionVirusOn(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Virus On Other Virologist With Protection Virus On]");
        //Init
        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Amnesia amnesia= new Amnesia();
        vir.AddVirus(amnesia);
        Protection pv = new Protection();
        vir2.UseVirusOnSelf(pv);
        //Testcase
        System.out.println(".......................................");
        vir.Attack(amnesia,vir2);
    }

    public static void UseDanceOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Dance On Self]");
        //Init
        Virologist vir= new Virologist();
        Dance dance= new Dance();
        vir.AddVirus(dance);
        //Testcase
        System.out.println(".......................................");
        vir.UseVirusOnSelf(dance);
    }


    public static void UseAmnesiaOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Amnesia On Self]");
        //Init
        Virologist vir= new Virologist();
        Amnesia amnesia= new Amnesia();
        vir.AddVirus(amnesia);
        //Testcase
        System.out.println(".......................................");
        vir.UseVirusOnSelf(amnesia);
    }

    public static void UseProtectionOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Protection On Self]");
        //Init
        Virologist vir= new Virologist();
        Protection protection= new Protection();
        vir.AddVirus(protection);
        //Testcase
        System.out.println(".......................................");
        vir.UseVirusOnSelf(protection);
    }

    public static void UseParalyzingOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Paralyzing On Self]");
        //Init
        Virologist vir= new Virologist();
        Paralyzing paralyzing= new Paralyzing();
        vir.AddVirus(paralyzing);
        //Testcase
        System.out.println(".......................................");
        vir.UseVirusOnSelf(paralyzing);
    }


}
