import java.util.ArrayList;

public class Virologist {
    private Virus virusOn;
    private Integer equipmentSize;
    private Integer materialSize;
    private Integer virusSize;
    private ArrayList<Integer> genCodes;
    private ArrayList<Virus> viruses;
    private ArrayList<Equipment> equipment;
    private ArrayList<Material> materials;
    private CapacityAbility capacityAbility;
    private MovementAbility movementAbility;
    private ProtectionAbility protectionAbility;
    private ReflectionAbility reflectionAbility;

    public void AddMaterial(Material m){}

    public void AddEquipment(Equipment e){}

    public void RemoveMaterial(Material m){}

    public void RemoveVirus(Virus v){}

    public void RemoveEquipment(Equipment e){}

    public void Move(Field f){}

    public void AddGeneticCode(Integer gen){}

    public void RemoveGeneticCodes(){}

    public void CraftVirus(Virus v){}

    public void Attack(Virus v, Virologist vir){}

    public void UseVirus(Virus v){}

    public void UseVirusOnSelf(Virus v){}

    public void ScanCode(){}

    public boolean HaveGeneticCode(Integer gen){}

    public void StealEquipment(Virologist v, Equipment e){}

    public void StealMaterial(Virologist v, Material m){}

    public void AttackedBy(Virologist vir, Virus v){}

    public Virus getVirusOn() {
        return virusOn;
    }

    public void setVirusOn(Virus virusOn) {
        this.virusOn = virusOn;
    }

    public Integer getEquipmentSize() {
        return equipmentSize;
    }

    public void setEquipmentSize(Integer equipmentSize) {
        this.equipmentSize = equipmentSize;
    }

    public Integer getMaterialSize() {
        return materialSize;
    }

    public void setMaterialSize(Integer materialSize) {
        this.materialSize = materialSize;
    }

    public Integer getVirusSize() {
        return virusSize;
    }

    public void setVirusSize(Integer virusSize) {
        this.virusSize = virusSize;
    }

    public CapacityAbility getCapacityAbility() {
        return capacityAbility;
    }

    public void setCapacityAbility(CapacityAbility capacityAbility) {
        this.capacityAbility = capacityAbility;
    }

    public MovementAbility getMovementAbility() {
        return movementAbility;
    }

    public void setMovementAbility(MovementAbility movementAbility) {
        this.movementAbility = movementAbility;
    }

    public ReflectionAbility getReflectionAbility() {
        return reflectionAbility;
    }

    public void setReflectionAbility(ReflectionAbility reflectionAbility) {
        this.reflectionAbility = reflectionAbility;
    }

    public ProtectionAbility getProtectionAbility() {
        return protectionAbility;
    }

    public void setProtectionAbility(ProtectionAbility protectionAbility) {
        this.protectionAbility = protectionAbility;
    }
}
