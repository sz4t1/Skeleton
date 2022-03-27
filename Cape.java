//This class represent the Cape item, which gives the player the ability to block the incoming attack if the RNG is on her/his side
//This class extends the equipment abstract class
public class Cape extends Equipment {
    //Constructor
    public Cape(){
        System.out.println("Cape constructed");
    }
    //The method Equip is being override here, so we can give the player the CapeProtection Ability
    @Override
    public void Equip(Virologist vir) {
        System.out.println("Equip(Virologist vir)");
    }
    //The method UnEquip is being override here, so we can remove the CapeProtection Ability from the player
    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("UnEquip(Virologist vir)");
    }
}
