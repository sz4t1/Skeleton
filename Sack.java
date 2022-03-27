//This class represent the Sack item, if a virologist have it she/he have increased maximum capacity
//This class extends the equipment abstract class
public class Sack extends Equipment {
    //Virologist equips the sack
    @Override
    public void Equip(Virologist vir) {
        System.out.println("Equip(Virologist vir) - Sack equipped");
    }
    //Virologist unequip the sack
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("UnEquip(Virologist vir) - Sack unequipped");
    }
}
