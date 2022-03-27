package src.main.java;

//This is the recipe of src.main.java.Amnesia src.main.java.Virus
//This implements the src.main.java.Recipe interface
public class AmnesiaRecipe implements Recipe{
    //Constructor
    public AmnesiaRecipe(){
        System.out.println("src.main.java.AmnesiaRecipe constructed");
    }
    //We Override the CreateVirus, sow we can create the src.main.java.Virus and it is being placed in the src.main.java.Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        System.out.println("New src.main.java.Amnesia virus is created");
        return new Amnesia();
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the src.main.java.Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("RemoveUsedMaterials(src.main.java.Virologist vir)");
    }
    //We Override the IsCraftable method here, so we can check if the src.main.java.Virologist that was given as a parameter have the materials or no
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("IsCraftable(src.main.java.Virologist vir");
        return true;
    }
}
