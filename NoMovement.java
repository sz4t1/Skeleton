//This class is a movement ability, the virologist can't move when she/he have it
//This extends MovementAbility abstract class
public class NoMovement extends MovementAbility {
    public NoMovement(){
        System.out.println("NoMovement() - NoMovement (ability) constructed: " + this);
    }
    //Use the effect on the virologist
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - The virologist is paralyzed.");
    }
}
