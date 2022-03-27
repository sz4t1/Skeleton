//This is the recipe of the Paralyzing virus
//It implements the Recipe interface
public class ParalyzingRecipe implements Recipe {
    //We Override the CreateVirus, so we can create the Virus and it is being placed in the Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        System.out.println("New Paralyzing virus is created");
        return new Dance();
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("The needed materials are being destroyed");
    }
    //We Override the IsCraftable method here, so we can check if the Virologist that was given as a parameter have the materials
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("The virus is always creatable in this part of the task");
        return true;
    }
}
