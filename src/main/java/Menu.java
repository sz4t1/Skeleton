package src.main.java;

public class Menu {
    public static void menuElements(){
        System.out.println("1. Check Environment");
        System.out.println("2. Craft src.main.java.Virus");
        System.out.println("3. Drop src.main.java.Equipment");
        System.out.println("4. Drop src.main.java.Material");
        System.out.println("5. End src.main.java.Game");
        System.out.println("6. Move src.main.java.Virologist");
        System.out.println("7. Pick Up src.main.java.Equipment");
        System.out.println("8. Pick Up src.main.java.Material");
        System.out.println("9. Scan Genetic");
        System.out.println("10. Steal src.main.java.Equipment");
        System.out.println("11. Steal src.main.java.Material");
        System.out.println("12. Use src.main.java.Virus On Other src.main.java.Virologist");
        System.out.println("13. Use src.main.java.Virus On Self");
        System.out.println("14.");
        System.out.println("15.");
        System.out.println("16.");
    }
    public static void CheckEnviroment(){
        Virologist vir= new Virologist();
        System.out.println("vir src.main.java.Virologist "+vir);
        Field field= new Field();
        System.out.println("field src.main.java.Field "+field);
        field.getNeighbours();
    }

    public static void CraftVirus(){
        Virologist vir= new Virologist();
        System.out.println("vir src.main.java.Virologist "+vir);
        AmnesiaRecipe amnesiaRecipe= new AmnesiaRecipe();
        System.out.println("amnesiaRecipe src.main.java.AmnesiaRecipe "+amnesiaRecipe);
        Amnesia type= new Amnesia();
        System.out.println("type src.main.java.Amnesia "+type);
        vir.CraftVirus(type);
        if(amnesiaRecipe.IsCraftable(vir)) {
            amnesiaRecipe.RemoveUsedMaterials(vir);
            vir.AddVirus(amnesiaRecipe.CreateVirus(vir));
        }
    }

    public static void DropEquipment(){
        Virologist vir= new Virologist();
        System.out.println("vir src.main.java.Virologist "+vir);
        Cape cape= new Cape();
        System.out.println("cape src.main.java.Cape "+cape);
        vir.RemoveEquipment(cape);
        cape.UnEquip(vir);
    }

    public static void DropMaterial(){
        Virologist vir= new Virologist();
        System.out.println("vir src.main.java.Virologist "+vir);
        AminoAcid aminoAcid= new AminoAcid();
        System.out.println("aminoAcid src.main.java.AminoAcid "+aminoAcid);
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
        System.out.println("vir src.main.java.Virologist "+vir);
        FreeMovememnt freeMovememnt = new FreeMovememnt();
        System.out.println("freeMovememnt src.main.java.FreeMovememnt "+freeMovememnt);
        Field field= new Field();
        System.out.println("field src.main.java.Field "+field);
        Field direction = new Field();
        System.out.println("field src.main.java.Field "+direction);
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
        System.out.println("vir src.main.java.Virologist "+vir);
        Shelter shelter= new Shelter();
        System.out.println("shelter src.main.java.Shelter "+shelter);
        Cape cape= new Cape();
        System.out.println("cape src.main.java.Cape "+cape);

        vir.AddEquipment(cape);
        shelter.getName();

    }
}
