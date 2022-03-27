package src.main.java;

//This is the recipe of the src.main.java.Protection virus
//It implements the src.main.java.Recipe interface
public class ProtectionRecipe implements Recipe {
    //We Override the CreateVirus, so we can create the src.main.java.Virus and it is being placed in the src.main.java.Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        System.out.println("New src.main.java.Protection virus is created");
        return new Dance();
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the src.main.java.Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("The needed materials are being destroyed");
    }
    //We Override the IsCraftable method here, so we can check if the src.main.java.Virologist that was given as a parameter have the materials
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("The virus is always creatable in this part of the task");
        return true;
    }
}
