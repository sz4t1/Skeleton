package src.main.java;

//This is an ability which the player can have, this blocks the incoming attack
//This class extends the src.main.java.ProtectionAbility abstract class
public class CompleteProtection extends ProtectionAbility {
    //We override the method here and it gives the src.main.java.Virologist the ability to not get hit by the incoming ability
    @Override
    public void invokeEffect(Virologist v) {
        System.out.println("src.main.java.Protection virus effect");
    }
}
