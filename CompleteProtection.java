//This is an ability which the player can have, this blocks the incoming attack
//This class extends the ProtectionAbility abstract class
public class CompleteProtection extends ProtectionAbility {
    
    public CompleteProtection(){
        System.out.println("CompleteProtection() - CompleteProtection (ability) constructed.");
    }
    //We override the method here and it gives the Virologist the ability to not get hit by the incoming ability
    @Override
    public void invokeEffect(Virologist v) {
        System.out.println("invokeEffect(Virologist v) - Complete protection against viruses.");
    }
}
