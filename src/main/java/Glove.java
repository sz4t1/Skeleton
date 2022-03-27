package src.main.java;

//src.main.java.Glove class is an item, that helps to reflect viruses to the attackers
//Class extends src.main.java.Equipment abstract class
public class Glove extends Equipment {
    //Override the equip method so the virologist equips the src.main.java.Glove
    @Override
    public void Equip(Virologist vir) {
        System.out.println("I have a glove");
    }
    //Override the unequip method so the virologist unequips the src.main.java.Glove
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("I don't have my glove anymore :(");
    }
}
