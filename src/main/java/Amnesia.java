package src.main.java;

//This is the src.main.java.Amnesia virus, wich makes the targeter person forget some of her/his Genetic Codes
//This class extends the src.main.java.Virus abstract class
public class Amnesia extends Virus {
//This overrides the Effect so we can effect the targeted src.main.java.Virologist with Amneisa
    public Amnesia(){
        System.out.println("src.main.java.Amnesia constructed");
    }
    @Override
    public void Effect(Virologist v) {
        System.out.println("src.main.java.Amnesia is on");
    }
    //This overrides the EffectOff so we can remove amnesia from the targeted src.main.java.Virologist
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("src.main.java.Amnesia is off");
    }
}
