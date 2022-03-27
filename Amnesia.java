//This is the Amnesia virus, wich makes the targeter person forget some of her/his Genetic Codes
//This class extends the Virus abstract class
public class Amnesia extends Virus {
//This overrides the Effect so we can effect the targeted Virologist with Amneisa
    @Override
    public void Effect(Virologist v) {
        System.out.println("Amnesia is on");
    }
    //This overrides the EffectOff so we can remove amnesia from the targeted Virologist
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("Amnesia is off");
    }
}
