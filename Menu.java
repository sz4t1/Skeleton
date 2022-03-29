public class Menu {
    public static void menuElements(){
        System.out.println("=======================================");

        System.out.println("1. Check Environment");
        System.out.println("2. Craft Virus");
        System.out.println("3. Drop Equipment");
        System.out.println("4. Drop Material");
        System.out.println("5. End Game");
        System.out.println("6. Move Virologist");
        System.out.println("7. Pick Up Equipment");
        System.out.println("8. Pick Up Material");
        System.out.println("9. Scan Genetic");
        System.out.println("10. Steal Cape");
        System.out.println("11. Steal Glove");
        System.out.println("12. Steal Sack");
        System.out.println("13. Steal Material");
        System.out.println("14. Use Virus On Other Virologist");
        System.out.println("15. Use Amnesia On Self");
        System.out.println("16. Use Dance On Self");
        System.out.println("17. Use Paralyzing On Self");
        System.out.println("18. Use Protection On Self");

        System.out.println("\n0. Exit Skeleton");
        System.out.println("=======================================");
    }
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
        vir.AddMaterial(aminoAcid);
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
        game.AddVirologist(vir1);
        game.AddVirologist(vir2);
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
        //Testcase
        System.out.println(".......................................");
        vir.ScanCode();

    }

    public static void StealCape(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Cape]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Cape cape= new Cape();
        vir2.addEquipment(cape);
        vir.StealEquipment(vir2,cape);

    }

    public static void StealGlove(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Glove]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Glove glove= new Glove();
        vir.addEquipment(glove);
        vir.StealEquipment(vir2,glove);

    }

    public static void StealSack(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Sack]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Sack sack= new Sack();
        vir.StealEquipment(vir2,sack);
        vir.addEquipment(sack);
        vir.StealEquipment(vir2,sack);
    }
    public static void StealMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Material]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        AminoAcid aminoAcid= new AminoAcid();
        vir.StealMaterial(vir2,aminoAcid);

    }

    public static void UseVirusOnOtherVirologist(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Virus On Other Virologist]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        NoReflection noReflection= new NoReflection();
        Amnesia amnesia= new Amnesia();

        vir.Attack(amnesia,vir2);
        vir2.AttackedBy(vir,amnesia);
        noReflection.invokeEffect(vir,vir2,amnesia);
        vir2.UseVirus(amnesia);
        vir.RemoveVirus(amnesia);
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
