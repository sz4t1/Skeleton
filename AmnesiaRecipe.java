//This is the recipe of Amnesia Virus
//This implements the Recipe interface
public class AmnesiaRecipe implements Recipe{
    //We Override the CreateVirus, sow we can create the Virus and it is being placed in the Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        System.out.println("New Amnesia virus is created");
        return new Amnesia();
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("The needed materials are destroyed");
    }
    //We Override the IsCraftable method here, so we can chack if the Virologist that was given as a parameter have the materials or no
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("The virus is always creatable in this part of the task");
        return true;
    }
}
