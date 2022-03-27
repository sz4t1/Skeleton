//Abstract class that represents the materials that can be used to create viruses
public abstract class Material {
    //Id of the material
    private String Name;
    //Method that deletes the material after it was used
    public abstract void beingUsed();
    //Get-set
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
