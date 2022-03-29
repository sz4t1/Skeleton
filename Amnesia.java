//This is the Amnesia virus, wich makes the targeter person forget some of her/his Genetic Codes
//This class extends the Virus abstract class
public class Amnesia extends Virus {
//This overrides the Effect so we can effect the targeted Virologist with Amneisa
    public Amnesia(){
        System.out.println("Amnesia() - Amnesia constructed");
    }
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Amnesia virus is affecting the virologist.");
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            v.getVirusOn().EffectOff(v);
        }
        //The virologist's genetis codes are removed
        v.RemoveGeneticCodes();
    }
    //This overrides the EffectOff so we can remove amnesia from the targeted Virologist
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Amnesia's effect is off");
    }
}
