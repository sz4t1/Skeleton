//An ability to don't reflect the incoming attacks
//This class extends RelfectionAbility abstract class
public class NoReflection extends ReflectionAbility {
    //Override invokeEffect and the virologist can't reflect
    @Override
    public void invokeEffect(Virologist vir1, Virologist vir2, Virus v) {
        System.out.println("RIP");
    }
}
