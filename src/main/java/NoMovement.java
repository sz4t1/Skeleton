package src.main.java;

//This class is a movement ability, the virologist can't move when she/he have it
//This extends src.main.java.MovementAbility abstract class
public class NoMovement extends MovementAbility {
    //Use the effect on the virologist
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("Life is hard :) so you can't move :'(");
    }
}
