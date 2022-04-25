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
    }
    @Override
    public void Effect(Virologist v) {}

    @Override
    public void EffectOff(Virologist v) {}
}
