package src;

/**
 * Axe is an equipment, that can kell virologists infected with BearDance virus
 */
public class Axe extends Equipment{

    public Axe() {
        System.out.println("Axe() - Axe constructed: " + this);
    }

    @Override
    public void Equip(Virologist vir) {
        System.out.println("Equip(Virologist vir) - Axe is equipped.");
        //Creating the capeProtection
        CanExecute cp = new CanExecute();
        //Set the virologist's ProtectionAbility to CapeProtection
        vir.setExecuteAbility(cp);
    }

    @Override
    public void UnEquip(Virologist vir) {
        System.out.println("UnEquip(Virologist vir) - Axe is unequipped.");
        CanNotExecute np = new CanNotExecute();
        vir.setExecuteAbility(np);
    }
    
}
