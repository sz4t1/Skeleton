package src.main.java;

//This is the src.main.java.Dance src.main.java.Virus if a src.main.java.Virologist got this she/he can't move by herself/himself the Character is being used by tha controller and steps on random fields for some turn
//This extends the src.main.java.Virus abstract class
public class Dance extends Virus {
    //This applies the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("src.main.java.Dance virus effect on");
    }
    //This removes the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("src.main.java.Dance virus effect off");
    }
}
