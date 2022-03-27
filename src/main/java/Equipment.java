package src.main.java;

//Abstract class that represents the items in the game
public abstract class Equipment {
    //The src.main.java.Virologist that was given as a parameter equips the item
    public abstract void Equip(Virologist vir);
    //The src.main.java.Virologist that was given as a parameter unequips the item
    public abstract void UnEquip(Virologist vir);
}
