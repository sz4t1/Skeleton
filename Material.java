//Abstract class that represents the materials that can be used to create viruses
public abstract class Material {
    //Id of the material
    protected String name;
    //Method that deletes the material after it was used
    public abstract void beingUsed();
    //Get-set
    public String getName() {
        return name;
    }
}
