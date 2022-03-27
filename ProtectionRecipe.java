public class ProtectionRecipe implements Recipe {
    @Override
    public Virus CreateVirus(Virologist v) {
        return null;
    }

    @Override
    public void RemoveUsedMaterials(Virologist vir) {

    }

    @Override
    public boolean IsCraftable(Virologist vir) {
        return false;
    }
}
