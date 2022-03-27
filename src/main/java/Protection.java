package src.main.java;

//This is the protection virus which makes the virologist immune to any other virus for a given time
//This extends the src.main.java.Virus abstract class
public class Protection extends Virus {
    //This applies the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("src.main.java.Protection virus effect on");
    }
    //This removes the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("src.main.java.Protection virus effect off");
    }
}
