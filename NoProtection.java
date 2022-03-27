//This is the default protection ability of a virologist it mean's she/he can't block any incoming virus
//This class extends the ProtectionAbility abstract class
public class NoProtection extends ProtectionAbility {
    //We override the method here and it gives the Virologist can get hit by any viruses
    @Override
    public void invokeEffect(Virologist v) {
        System.out.println("invokeEffect(Virologist v)");
    }
}
