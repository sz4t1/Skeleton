//This is the Amnesia virus, wich makes the targeter person forget some of her/his Genetic Codes
//This class extends the Virus abstract class
public class Amnesia extends Virus {
//This overrides the Effect so we can effect the targeted Virologist with Amneisa
    public Amnesia(){
        System.out.println("Amnesia() - Amnesia (virus) constructed: " + this);
        overwritable = true;
        name = "amnesia";
    }
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Amnesia virus is affecting the virologist.");       
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            //if the virus already on is not overwritable, than nothing is gona change
            //this will occure, if beardance is On
            if(!getOverwritable()) return;
            
            v.getVirusOn().EffectOff(v);
        }
        //The virologist's genetis codes are removed
        //The amnesia virus doesn't need to get into the VirusOn, because it's effect is instant, and not lasting
        v.RemoveGeneticCodes();
        setExpirationTime(0);
    }
    //This overrides the EffectOff so we can remove amnesia from the targeted Virologist
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Amnesia's effect is off");
        v.setVirusOn(null);
    }
}
