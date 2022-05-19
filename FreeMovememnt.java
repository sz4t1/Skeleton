//This class is the default ability to the MovementAbility of the Virologist
//This extends MovementAbility abstract class
public class FreeMovememnt extends MovementAbility {
    //Constructor
    public FreeMovememnt(){
        System.out.println("FreeMovememnt() - FreeMovement (ability) constructed: " + this);
    }
    //If a virologist attempts to move, this function will be invoked, if the virologist can freely move
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - The virologist can freely move.");
        v.getField().RemoveVirologist(v);
        v.setField(f);
        return;
    }

    @Override
    public boolean cheatMove() {
        return true;
    }
}
