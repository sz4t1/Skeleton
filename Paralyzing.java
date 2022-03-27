//This is the paralyzing virus it makes the virologist unable to move
//This extends the Virus abstract class
public class Paralyzing extends Virus {
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Paralyzing virus effect on");
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("Paralyzing virus effect off");
    }
}
