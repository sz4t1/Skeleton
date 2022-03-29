import java.util.Random;

public class Menu {
    public static void menuElements(){
        System.out.println("---------------------------------------");

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

        System.out.println("0. Exit Skeleton");
        System.out.println("---------------------------------------");
    }
    public static void CheckEnviroment(){
        System.out.println("---------------------------------------");
        System.out.println("[Check Environment]");
        
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Field field= new Field();
        System.out.println("field Field "+field);
        Laboratory laboratory= new Laboratory();
        System.out.println("laboratory Laboratory "+laboratory);
        Shelter shelter= new Shelter();
        System.out.println("shelter Shelter "+shelter);

        field.addNeighbour(laboratory);
        field.addNeighbour(shelter);
        vir.setField(field);
        field.getNeighbours();
    }

    public static void CraftVirus(){
        System.out.println("---------------------------------------");
        System.out.println("[Craft Virus]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        AmnesiaRecipe amnesiaRecipe= new AmnesiaRecipe();
        System.out.println("amnesiaRecipe AmnesiaRecipe "+amnesiaRecipe);
        Amnesia amnesia= new Amnesia();
        System.out.println("amnesia Amnesia "+amnesia);
        vir.CraftVirus(amnesiaRecipe);

    }

    public static void DropEquipment(){
        System.out.println("---------------------------------------");
        System.out.println("[Drop Equipment]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        vir.addEquipment(cape);
        vir.RemoveEquipment(cape);

    }

    public static void DropMaterial(){
        System.out.println("---------------------------------------");
        System.out.println("[Drop Material]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        AminoAcid aminoAcid= new AminoAcid();
        System.out.println("aminoAcid AminoAcid "+aminoAcid);
        vir.RemoveMaterial(aminoAcid);

    }
    // TODO
    public static void EndGame(){
        System.out.println("---------------------------------------");
        System.out.println("[End Game]");

        Game game= new Game();
        Virologist vir= new Virologist();
        game.StartGame();
        if(game.CheckGeneticCodes(vir)){
            game.EndGame();
        }
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
        vir.Move(direction);
        freeMovememnt.invokeEffect(vir, direction);
        if(field.IsNeighbour(direction)) {
            field.RemoveVirologist(vir);
            direction.AddVirologist(vir);
            vir.setField(direction);
        }
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

        vir.AddEquipment(cape);
        if(shelter.getName().equals("Shelter")){
            shelter.RemoveEquipment(cape);
            cape.Equip(vir);
        }
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
        vir.AddMaterial(aminoAcid);
        if(warehouse.getName().equals("Warehouse")){
            warehouse.RemoveMaterial(aminoAcid);
        }
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
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        SackCapacity sackCapacity= new SackCapacity();
        System.out.println("sackCapacity SackCapacity "+ sackCapacity);
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
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        AminoAcid aminoAcid= new AminoAcid();
        System.out.println("aminoAcid AminoAcid "+aminoAcid);

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
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        NoReflection noReflection= new NoReflection();
        System.out.println("noReflection NoReflection "+noReflection);
        Amnesia amnesia= new Amnesia();
        System.out.println("amnesia Amnesia "+amnesia);

        vir.Attack(amnesia,vir2);
        vir2.AttackedBy(vir,amnesia);
        noReflection.invokeEffect(vir,vir2,amnesia);
        vir2.UseVirus(amnesia);
        vir.RemoveVirus(amnesia);
    }

    public static void UseDanceOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Dance On Self]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Dance dance= new Dance();
        System.out.println("dance Dance "+dance);
        Amnesia amnesia= new Amnesia();
        System.out.println("amnesia Amnesia "+amnesia);
        RandomMovement randomMovement= new RandomMovement();
        System.out.println("randomMovement RandomMovement "+randomMovement);


        vir.UseVirusOnSelf(dance);
        dance.Effect(vir);
        amnesia.EffectOff(vir);
        vir.setVirusOn(dance);
        vir.setMovementAbility(randomMovement);
    }


    public static void UseAmnesiaOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Amnesia On Self]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Amnesia amnesia= new Amnesia();
        System.out.println("amnesia Amnesia "+amnesia);
        Dance dance= new Dance();
        System.out.println("dance Dance "+dance);
        FreeMovememnt freeMovememnt = new FreeMovememnt();
        System.out.println("freeMovememnt FreeMovememnt"+freeMovememnt);

        vir.UseVirusOnSelf(amnesia);
        amnesia.Effect(vir);
        dance.EffectOff(vir);
        vir.setMovementAbility(freeMovememnt);
        vir.RemoveGeneticCodes();

    }

    public static void UseProtectionOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Protection On Self]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Protection protection= new Protection();
        System.out.println("protection Protection "+protection);
        Paralyzing paralyzing= new Paralyzing();
        System.out.println("paralyzing Paralyzing "+paralyzing);
        CompleteProtection completeProtection= new CompleteProtection();
        System.out.println("completeProtection CompleteProtection"+completeProtection);
        FreeMovememnt freeMovememnt = new FreeMovememnt();
        System.out.println("freeMovememnt FreeMovememnt"+freeMovememnt);

        vir.UseVirusOnSelf(protection);
        protection.Effect(vir);
        paralyzing.EffectOff(vir);
        vir.setProtectionAbility(completeProtection);
        vir.setMovementAbility(freeMovememnt);
    }

    public static void UseParalyzingOnSelf(){
        System.out.println("---------------------------------------");
        System.out.println("[Use Paralyzing On Self]");

        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Paralyzing paralyzing= new Paralyzing();
        System.out.println("paralyzing Paralyzing "+paralyzing);
        Dance dance= new Dance();
        System.out.println("dance Dance "+dance);
        CompleteProtection completeProtection= new CompleteProtection();
        System.out.println("completeProtection CompleteProtection"+completeProtection);
        NoMovement noMovement = new NoMovement();
        System.out.println("noMovement NoMovement"+noMovement);

        vir.UseVirusOnSelf(paralyzing);
        paralyzing.Effect(vir);
        dance.EffectOff(vir);
        vir.setMovementAbility(noMovement);
    }


}
