package src.main.java;

//This is the paralyzing virus it makes the virologist unable to move
//This extends the src.main.java.Virus abstract class
public class Paralyzing extends Virus {
    //This applies the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("src.main.java.Paralyzing virus effect on");
    }
    //This removes the effect of the virus on the src.main.java.Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("src.main.java.Paralyzing virus effect off");
    }
}
