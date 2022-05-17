//This class is makes the virologist to move randomly
//This extends MovementAbility abstract class
public class BearMovement extends MovementAbility {
    public BearMovement(){
        System.out.println("BearMovement() - BearMovement (ability) constructed.");
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - You are a bear");
    }
}
