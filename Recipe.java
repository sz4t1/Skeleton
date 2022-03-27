public interface Recipe {
    Virus CreateVirus(Virologist v);

    void RemoveUsedMaterials(Virologist vir);

    boolean IsCraftable(Virologist vir);
}
