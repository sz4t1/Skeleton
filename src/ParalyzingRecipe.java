package src;

//This is the recipe of the Paralyzing virus
//It implements the Recipe interface
public class ParalyzingRecipe implements Recipe {
    private int amNeed = 8, nukNeed = 8;
    //We Override the CreateVirus, so we can create the Virus and it is being placed in the Virologist's inventory that is given as a parameter to this method
    @Override
    public Virus CreateVirus(Virologist v) {
        
        if(IsCraftable(v)){
            RemoveUsedMaterials(v);
            System.out.println("CreateVirus(Virologist v) - New Paralyzing virus is created");
            return new Paralyzing();
        }
        return null;
    }
    // We Override the RemoveUsedMaterials, this removes the materials needed to create the virus from the Virologist that was given as parameter
    @Override
    public void RemoveUsedMaterials(Virologist vir) {
        System.out.println("RemoveUsedMaterials(Virologist vir) - The needed materials are being destroyed");
        int am = 0, nuk = 0;
        for (Material m : vir.getMaterials()) {
            if(m.getName().equals("aminoacid") && am < amNeed){
                am++;
                vir.RemoveMaterial(m);
            }
                        
            if(m.getName().equals("nukleotide") && nuk < nukNeed){
                nuk++;
                vir.RemoveMaterial(m);
            }

            if(am == amNeed && nuk == nukNeed) break;
        }
    }
    //We Override the IsCraftable method here, so we can check if the Virologist that was given as a parameter have the materials
    @Override
    public boolean IsCraftable(Virologist vir) {
        System.out.println("IsCraftable(Virologist vir) - The virus is always creatable in this part of the task");
        int am = 0, nuk = 0;
        for(Material m : vir.getMaterials()){
            if(m.getName().equals("aminoacid")){
                am++;
            }
                        
            if(m.getName().equals("nukleotide")){
                nuk++;
            }
        }
        return (am >= amNeed && nuk >= nukNeed);
    }
}
