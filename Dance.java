//This is the Dance Virus if a Virologist got this she/he can't move by herself/himself the Character is being used by tha controller and steps on random fields for some turn
//This extends the Virus abstract class
public class Dance extends Virus {
    //Constructor
    public Dance(){
        System.out.println("Dance() - Dance virus is constructed.");
    }
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Dance virus affects the virologist.");
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Dance virus is affecting no more the virologist.");
    }
}
