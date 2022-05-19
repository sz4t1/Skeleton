//Abstract class that represents the movement abilities of a virologist
public abstract class MovementAbility {
    //Invoke the effect of the ability
    public abstract  void invokeEffect(Virologist v, Field f);
    public abstract boolean cheatMove();
}
