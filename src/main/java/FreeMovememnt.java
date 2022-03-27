package src.main.java;

//This class is the default ability to the src.main.java.MovementAbility of the src.main.java.Virologist
//This extends src.main.java.MovementAbility abstract class
public class FreeMovememnt extends MovementAbility {
    //Constructor
    public FreeMovememnt(){
        System.out.println("FreeMovement constructed");
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(src.main.java.Virologist v, src.main.java.Field f)");
    }
}
