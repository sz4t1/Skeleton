//This is the Dance Virus if a Virologist got this she/he can't move by herself/himself the Character is being used by tha controller and steps on random fields for some turn
//This extends the Virus abstract class
public class Dance extends Virus {
    //Constructor
    public Dance(){
        System.out.println("Dance() - Dance (virus) constructed: " + this);
        overwritable = true;
        name = "dance";
    }
    //This applies the effect of the virus on the Virologist that was given as parameter
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - Dance virus affects the virologist.");
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            //if the virus already on is not overwritable, than nothing is gona change
            //this will occure, if beardance is On
            if(!getOverwritable()) return;

            v.getVirusOn().EffectOff(v);
        }
        //The paralyzing virus gets on the virologist
        v.setVirusOn(this);
        //New RandomMovement is created
        RandomMovement rm = new RandomMovement();
        //The virologist's movement ability is set to RandomMovement
        v.setMovementAbility(rm);
        setExpirationTime(2);
    }
    //This removes the effect of the virus on the Virologist that was given as parameter
    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - Dance virus is affecting no more the virologist.");
        //The virus gets off the virologist
        v.setVirusOn(null);
        //New FreeMovement is created
        FreeMovememnt np = new FreeMovememnt();
        //The virologist's movement ability is set to FreeMovement
        v.setMovementAbility(np);
    }
}
