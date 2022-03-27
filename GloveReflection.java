//An ability to reflect the viruses to the attackers
//This class extends RelfectionAbility abstract class
public class GloveReflection extends ReflectionAbility {
    //Override invokeEffect so the virologist can get the ability to reflect virus
    @Override
    public void invokeEffect(Virologist vir1, Virologist vir2, Virus v) {
        System.out.println("invokeEffect(Virologist vir1, Virologist vir2, Virus v) - Attacks are reflected.");
    }
}
