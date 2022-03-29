//This class is the default ability to the MovementAbility of the Virologist
//This extends MovementAbility abstract class
public class FreeMovememnt extends MovementAbility {
    //Constructor
    public FreeMovememnt(){
        System.out.println("FreeMovememnt() - FreeMovement (ability) constructed: " + this);
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - The virologist can freely move.");
        if(f.IsNeighbour(f)) {
            v.getField().RemoveVirologist(v);
            f.AddVirologist(v);
            v.setField(f);
        }
    }
}
