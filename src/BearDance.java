package src;

//This is the BearDance Virus.
//If a Virologist gets this she/he can't move by herself/himself.
//The Character is being moved by the controller and steps on random fields for some turn.
//If the effected virologist steps on a Warehouse, he destroys all the materials found there.
//He can also infect other virologists if he gets in contact with them.
//This extends the Dance class
public class BearDance extends Dance{
    //Constructor
    public BearDance(){
        System.out.println("BearDance() - BearDance (virus) constructed: " + this);
        overwritable = false;
        name = "beardance";
    }
    @Override
    public void Effect(Virologist v) {
        System.out.println("Effect(Virologist v) - BearDance virus is affecting the virologist.");
        //If the virologist has a virus on already, it is overwritten by the new one
        if(v.getVirusOn() != null){
            //if the virus already on is not overwritable, than nothing is gona change
            //this will occure, if beardance is On
            if(!getOverwritable()) return;

            v.getVirusOn().EffectOff(v);
        }
        //The virologist's genetis codes are removed
        v.setVirusOn(this);
        //New BearDance virus created
        BearMovement bd = new BearMovement();
        //The virologist's movement ability is set to RandomMovement
        v.setMovementAbility(bd);
        setExpirationTime(-1);
    }

    @Override
    public void EffectOff(Virologist v) {
        System.out.println("EffectOff(Virologist v) - BearDance's effect is off");
        v.setVirusOn(null);
    }
}
