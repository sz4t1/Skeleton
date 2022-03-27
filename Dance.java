//This is the Dance Virus if a Virologist got this she/he can't move by herself/himself the Character is being used by tha controller and steps on random fields for some turn
//This extends the Virus abstract class
public class Dance extends Virus {
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Dance virus effect on");
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("Dance virus effect off");
    }
}
