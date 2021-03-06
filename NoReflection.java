//An ability to don't reflect the incoming attacks
//This class extends RelfectionAbility abstract class
public class NoReflection extends ReflectionAbility {
    //Constructor
    public NoReflection(){
        System.out.println("NoReflection() - NoReflection (ability) constructed: " + this);
    }
    //Override invokeEffect and the virologist can't reflect
    @Override
    public void invokeEffect(Virologist vir1, Virologist vir2, Virus v) {
        System.out.println("invokeEffect(Virologist vir1, Virologist vir2, Virus v) - The virologist can't reflec the attacks.");
        vir2.UseVirus(v);
        vir1.RemoveVirus(v);
    }
}
