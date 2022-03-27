package src.main.java;

//The default capacity ability the src.main.java.Virologist have it without any modifier item
//This class extends the src.main.java.CapacityAbility abstract class
public class DefaultCapacity extends CapacityAbility {
    //Constructor that sets the MaxMaterialSize and MaxVirusSize to the default 10 and 2
    public DefaultCapacity(){
        setMaxMaterialSize(10);
        setMaxVirusSize(2);
        System.out.println("MaxMaterialSize is 10 and MaxVirusSize is 2 now");
    }
}
