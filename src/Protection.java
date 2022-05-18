package src;

//This is the protection virus which makes the virologist immune to any other virus for a given time
//This extends the Virus abstract class
public class Protection extends Virus {
    public Protection(){
        System.out.println("Protection() - Protection (virus) constructed: " + this);
        overwritable = true;
        name = "protection";
    }
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Protection virus is effecting the virologist.");
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            //if the virus already on is not overwritable, than nothing is gona change
            //this will occure, if beardance is On
            if(!getOverwritable()) return;

            v.getVirusOn().EffectOff(v);
        }
        //The protection virus gets on the virologist
        v.setVirusOn(this);
        //New CompleteProtection is created
        CompleteProtection cp = new CompleteProtection();
        //The virologist's protection ability is set to CompleteProtection
        v.setProtectionAbility(cp);
        setExpirationTime(3);
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Protection virus effect off");
        //The virus gets off the virologist
        v.setVirusOn(null);
        //New NoProtection is created
        NoProtection np = new NoProtection();
        //The virologist's protection ability is set to NoProtection
        v.setProtectionAbility(np);
    }
}
