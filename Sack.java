//This class represent the Sack item, if a virologist have it she/he have increased maximum capacity
//This class extends the equipment abstract class
public class Sack extends Equipment {
    public Sack(){
        System.out.println("Sack() - Sack constructed: " + this);
        name = "sack";
    }
    //Virologist equips the sack
    @Override
    public void Equip(Virologist vir) {
        System.out.println("Equip(Virologist vir) - Sack equipped");
        //Creating the SackCapacity
        SackCapacity sc = new SackCapacity();
        //Set the virologist's CapacityAbility to SackCapacity
        vir.setCapacityAbility(sc);
    }
    //Virologist unequip the sack
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("UnEquip(Virologist vir) - Sack unequipped");
        //Creating the DefaultCapacity
        DefaultCapacity dc = new DefaultCapacity();
        //Set the virologist's CapacityAbility to SackCapacity
        vir.setCapacityAbility(dc);
    }
}
