//This is the recipe of Amnesia Virus
//This implements the Recipe interface
public class AmnesiaRecipe implements Recipe{
    //Constructor
    public AmnesiaRecipe(){
        System.out.println("AmnesiaRecipe() - AmnesiaRecipe constructed.");
    }
    //We Override the CreateVirus, sow we can create the Virus and it is being placed in the Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        System.out.println("CreateVirus(Virologist v) - New Amnesia virus is created.");
        return new Amnesia();
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("RemoveUsedMaterials(Virologist vir) - The required materials are removed from the virologist's inventory.");
    }
    //We Override the IsCraftable method here, so we can check if the Virologist that was given as a parameter have the materials or no
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("IsCraftable(Virologist vir) - Checking for required materials.");
        return true;
    }
}
