//This is the protection virus which makes the virologist immune to any other virus for a given time
//This extends the Virus abstract class
public class Protection extends Virus {
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Protection virus effect on");
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Protection virus effect off");
    }
}
