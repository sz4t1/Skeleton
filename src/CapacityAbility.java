package src;

//This is an abstract class that is responsible for the carrying capacity of the virologist
public abstract class CapacityAbility {
    //The maxVirusSize is meant to store an Integer number that is the maximum amount of Virus a Virologist can hold at one time
    private Integer maxVirusSize;
    //The maxMaterialSize is meant to store an Integer number that is the maximum amount of Material a Virologist can hold at one time
    private Integer maxMaterialSize;
    //The public getters and setters for the private attributes of the class
    public Integer getMaxVirusSize() {
        return maxVirusSize;
    }

    public void setMaxVirusSize(Integer maxVirusSize) {
        this.maxVirusSize = maxVirusSize;
    }

    public Integer getMaxMaterialSize() {
        System.out.println("getMaxMaterialSize()");
        return maxMaterialSize;
    }

    public void setMaxMaterialSize(Integer maxMaterialSize) {
        this.maxMaterialSize = maxMaterialSize;
    }
}
