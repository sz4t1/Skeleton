import java.util.Random;

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
        Amnesia amnesia= new Amnesia();
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
        //Testcase
        System.out.println(".......................................");
        vir.RemoveMaterial(aminoAcid);

    }
    // TODO
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

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        FreeMovememnt freeMovememnt = new FreeMovememnt();
        System.out.println("freeMovememnt FreeMovememnt "+freeMovememnt);
        Field field= new Field();
        System.out.println("field Field "+field);
        Field direction = new Field();
        System.out.println("field Field "+direction);
        field.addNeighbour(direction);
        vir.setField(field);
        vir.Move(direction);
    }

    public static void PickUpEquipment(){
        System.out.println("---------------------------------------");
        System.out.println("[Pick Up Equipment]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Shelter shelter= new Shelter();
        System.out.println("shelter Shelter "+shelter);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        vir.setField(shelter);
        shelter.setEquipment(cape);
        vir.AddEquipment(shelter.getEquipment());

    }

    public static void PickUpMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Pick Up Material]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Warehouse warehouse= new Warehouse();
        System.out.println("warehouse Warehouse: "+warehouse);
        AminoAcid aminoAcid= new AminoAcid();
        System.out.println("aminoAcid AminoAcid: "+aminoAcid);
        vir.setField(warehouse);
        warehouse.addMaterial(aminoAcid);
        vir.AddMaterial(aminoAcid);


    }

    public static void VirologistScans(){
        System.out.println("---------------------------------------");
        System.out.println("[Virologist Scans]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Laboratory laboratory= new Laboratory();
        System.out.println("laboratory Laboratory: "+laboratory);
        vir.ScanCode();
        if(!vir.HaveGeneticCode(laboratory.getGeneticCode()))
            vir.AddGeneticCode(laboratory.getGeneticCode());
    }

    public static void StealCape(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Cape]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        CapeProtection capeProtection= new CapeProtection();
        System.out.println("capeProtection CapeProtection "+capeProtection);
        NoProtection noProtection= new NoProtection();
        System.out.println("noProtection NoProtection "+noProtection);

        vir.StealEquipment(vir2,cape);
        if(vir.getEquipmentSize()<2){
            vir2.RemoveEquipment(cape);
            cape.UnEquip(vir2);
            vir2.setProtectionAbility(noProtection);
            vir.AddEquipment(cape);
            cape.Equip(vir);
            vir.setProtectionAbility(capeProtection);
        }
    }

    public static void StealGlove(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Glove]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        GloveReflection gloveReflection= new GloveReflection();
        System.out.println("gloveReflection GloveReflection "+gloveReflection);
        NoReflection noReflection= new NoReflection();
        System.out.println("noReflection NoReflection "+noReflection);

        vir.StealEquipment(vir2,cape);
        if(vir.getEquipmentSize()<2){
            vir2.RemoveEquipment(cape);
            cape.UnEquip(vir2);
            vir2.setReflectionAbility(noReflection);
            vir.AddEquipment(cape);
            cape.Equip(vir);
            vir.setReflectionAbility(gloveReflection);
        }
    }

    public static void StealSack(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Sack]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        Cape cape= new Cape();
        SackCapacity sackCapacity= new SackCapacity();
        DefaultCapacity defaultCapacity= new DefaultCapacity();
        vir.StealEquipment(vir2,cape);

        if(vir.getEquipmentSize()<2){
            vir2.RemoveEquipment(cape);
            cape.UnEquip(vir2);
            vir2.setCapacityAbility(defaultCapacity);
            vir.AddEquipment(cape);
            cape.Equip(vir);
            vir.setCapacityAbility(sackCapacity);
        }
    }
    public static void StealMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Steal Material]");

        Virologist vir= new Virologist();
        Virologist vir2= new Virologist();
        AminoAcid aminoAcid= new AminoAcid();

        vir.StealMaterial(vir2,aminoAcid);
        if(vir.getCapacityAbility().getMaxMaterialSize()<=vir.getMaterialSize()+1){
            vir2.RemoveMaterial(aminoAcid);
            vir.AddMaterial(aminoAcid);
        }
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
