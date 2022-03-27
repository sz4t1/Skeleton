package src.main.java;

//This class represent the src.main.java.Sack item, if a virologist have it she/he have increased maximum capacity
//This class extends the equipment abstract class
public class Sack extends Equipment {
    //src.main.java.Virologist equips the sack
    @Override
    public void Equip(Virologist vir) {
        System.out.println("src.main.java.Sack equipped");
    }
    //src.main.java.Virologist unequip the sack
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("src.main.java.Sack unequipped");
    }
}
