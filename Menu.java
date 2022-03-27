public class Menu {
    public static void menuElements(){
        System.out.println("1. Check Environment");
        System.out.println("2. Craft Virus");
        System.out.println("3. Drop Equipment");
        System.out.println("4. Drop Material");
        System.out.println("5. End Game");
        System.out.println("6. Move Virologist");
        System.out.println("7. Pick Up Equipment");
        System.out.println("8. Pick Up Material");
        System.out.println("9. Scan Genetic");
        System.out.println("10. Steal Equipment");
        System.out.println("11. Steal Material");
        System.out.println("12. Use Virus On Other Virologist");
        System.out.println("13. Use Virus On Self");
        System.out.println("14.");
        System.out.println("15.");
        System.out.println("16.");
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

    public static void StealEquipment(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Virologist vir2= new Virologist();
        System.out.println("vir2 Virologist "+vir2);
        Cape cape= new Cape();
        System.out.println("cape Cape "+cape);

        vir.StealEquipment(vir2,cape);
        if(vir.getEquipmentSize()<2){
            vir2.RemoveEquipment(cape);
            cape.UnEquip(vir2);
            vir.AddEquipment(cape);
            cape.Equip(vir);
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

    public static void UseVirusOnSelf(){
        Virologist vir= new Virologist();
        System.out.println("vir Virologist "+vir);
        Dance dance= new Dance();
        System.out.println("dance Dance "+dance);

        vir.UseVirusOnSelf(dance);
        dance.Effect(vir);
    }


}
