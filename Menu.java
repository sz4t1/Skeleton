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
        Virologist v= new Virologist();
        Field field= new Field();
        field.getNeighbours();
    }

    public static void CraftVirus(){
        Virologist vir= new Virologist();
        AmnesiaRecipe amnesiaRecipe= new AmnesiaRecipe();
        Amnesia type= new Amnesia();
        vir.CraftVirus(type);
        if(amnesiaRecipe.IsCraftable(vir)) {
            amnesiaRecipe.RemoveUsedMaterials(vir);
            vir.AddVirus(amnesiaRecipe.CreateVirus(vir));
        }
    }

    public static void DropEquipment(){
        Virologist vir= new Virologist();
        Cape cape= new Cape();
        vir.RemoveEquipment(cape);
        cape.UnEquip(vir);
    }
}
