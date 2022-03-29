//This class is makes the virologist to move randomly
//This extends MovementAbility abstract class
public class RandomMovement extends MovementAbility {
    public RandomMovement(){
        System.out.println("RandomMovement() - RandomMovement (ability) constructed: " + this);
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - You move randomly hehe");
    }
}
