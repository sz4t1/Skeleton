//This class is the default ability to the MovementAbility of the Virologist
//This extends MovementAbility abstract class
public class FreeMovememnt extends MovementAbility {
    //Use the effect on the virologist
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("You can move wherever you want");
    }
}
