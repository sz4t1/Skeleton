package src.main.java;

//This is an ability which the player can have, this gives her/him the chance of block an incoming attack
//This class extends the src.main.java.ProtectionAbility abstract class
public class CapeProtection extends ProtectionAbility {
    //We override the method here and it gives the src.main.java.Virologist chance to not get hit by the incoming ability
    @Override
    public void invokeEffect(Virologist v) {
        System.out.println("src.main.java.Cape src.main.java.Protection effect");
    }
}
