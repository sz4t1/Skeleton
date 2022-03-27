//The ability which is granted when the virologist equips a sack it increases the maximum carrying capacity
//This class extends the CapacityAbility abstract class
public class SackCapacity extends CapacityAbility {
    //Constructor that sets the MaxMaterialSize and MaxVirusSize to the default 20 and 4
    public SackCapacity(){
        setMaxMaterialSize(20);
        setMaxVirusSize(4);
        System.out.println("MaxMaterialSize is 20 and MaxVirusSize is 4 now");
    }
}
