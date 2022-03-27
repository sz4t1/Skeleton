//Glove class is an item, that helps to reflect viruses to the attackers
//Class extends Equipment abstract class
public class Glove extends Equipment {
    //Override the equip method so the virologist equips the Glove
    @Override
    public void Equip(Virologist vir) {
        System.out.println("Equip(Virologist vir) - Glove is equipped now.");
    }
    //Override the unequip method so the virologist unequips the Glove
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("UnEquip(Virologist vir) - Glove is uneqipped now.");
    }
}
