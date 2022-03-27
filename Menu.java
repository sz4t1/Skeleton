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
        System.out.println("18.Use Protection On Self");

        System.out.println("0. Exit Skeleton");
        System.out.println("---------------------------------------");
    }
    public static void CheckEnviroment(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Field field= new Field();
        System.out.println("field Field "+field);
        field.getNeighbours();
    }

    public static void CraftVirus(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        AmnesiaRecipe amnesiaRecipe= new AmnesiaRecipe();
        System.out.println("amnesiaRecipe AmnesiaRecipe "+amnesiaRecipe);
        Amnesia type= new Amnesia();
        System.out.println("type Amnesia "+type);
        vir.CraftVirus(type);
        if(amnesiaRecipe.IsCraftable(vir)) {
            amnesiaRecipe.RemoveUsedMaterials(vir);
            vir.AddVirus(amnesiaRecipe.CreateVirus(vir));
        }
    }

    public static void DropEquipment(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);
        vir.RemoveEquipment(cape);
        cape.UnEquip(vir);
    }

    public static void DropMaterial(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        AminoAcid aminoAcid= new AminoAcid();
        System.out.println("aminoAcid AminoAcid "+aminoAcid);
        vir.RemoveMaterial(aminoAcid);
        aminoAcid.beingUsed();
    }
    //todo
    public static void EndGame(){
        Game game= new Game();
        Virologist vir= new Virologist();
    }

    public static void MoveVirologist(){
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
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Laboratory laboratory= new Laboratory();
        System.out.println("laboratory Laboratory: "+laboratory);
        vir.ScanCode();
        if(!vir.HaveGeneticCode(laboratory.getGeneticCode()))
            vir.AddGeneticCode(laboratory.getGeneticCode());
    }

    public static void StealCape(){
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
