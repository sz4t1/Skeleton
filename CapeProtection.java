//This is an ability which the player can have, this gives her/him the chance of block an incoming attack
//This class extends the ProtectionAbility abstract class
public class CapeProtection extends ProtectionAbility {
    public CapeProtection(){
        System.out.println("CapeProtection() - CapeProtection (ability) constructed.");
    }
    //We override the method here and it gives the Virologist chance to not get hit by the incoming ability
    @Override
    public void invokeEffect(Virologist v) {
        System.out.println("invokeEffect(Virologist v) - Cape Protection effect is invoked.");
    }
}
