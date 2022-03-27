package src.main.java;

//This class is makes the virologist to move randomly
//This extends src.main.java.MovementAbility abstract class
public class RandomMovement extends MovementAbility {
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("You move randomly hehe");
    }
}
