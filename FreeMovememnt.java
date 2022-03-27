//This class is the default ability to the MovementAbility of the Virologist
//This extends MovementAbility abstract class
public class FreeMovememnt extends MovementAbility {
    //Constructor
    public FreeMovememnt(){
        System.out.println("FreeMovement constructed");
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f)");
    }
}
