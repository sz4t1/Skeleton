package src;

//This is the paralyzing virus it makes the virologist unable to move
//This extends the Virus abstract class
public class Paralyzing extends Virus {
    public Paralyzing(){
        System.out.println("Paralyzing() - Paralyzing (virus) constructed: " + this);
        overwritable = true;
        name = "paralyzing";
    }
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Paralyzing virus is effecting the virologist.");
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            //if the virus already on is not overwritable, than nothing is gona change
            //this will occure, if beardance is On
            if(!getOverwritable()) return;

            v.getVirusOn().EffectOff(v);
        }
        //The paralyzing virus gets on the virologist
        v.setVirusOn(this);
        //New NoMovement is created
        NoMovement nm = new NoMovement();
        //The virologist's movement ability is set to NoMovement
        v.setMovementAbility(nm);
        setExpirationTime(2);
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Paralyzing virus is effecting the virologist no more.");
        //The virus gets off the virologist
        v.setVirusOn(null);
        //New FreeMovement is created
        FreeMovememnt np = new FreeMovememnt();
        //The virologist's movement ability is set to freeMovement
        v.setMovementAbility(np);
    }
}
