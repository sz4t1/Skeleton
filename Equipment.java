//Abstract class that represents the items in the game
public abstract class Equipment {
    //ID of the material
    protected String name;
    //The Virologist that was given as a parameter equips the item
    public abstract void Equip(Virologist vir);
    //The Virologist that was given as a parameter unequips the item
    public abstract void UnEquip(Virologist vir);

    public String getName(){return name;}
}
