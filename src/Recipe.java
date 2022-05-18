package src;

//Recipe interface for viruses
public interface Recipe {
    //Create the virus and add to the given virologist
    Virus CreateVirus(Virologist v);
    //Remove the needed material from the given virologist
    void RemoveUsedMaterials(Virologist vir);
    //Check if it's creatable by the given virologist
    boolean IsCraftable(Virologist vir);
}
