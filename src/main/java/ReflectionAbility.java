package src.main.java;

//Abstract class that represents the reflect ability of a virologist it mean's if a virologist can reflect then she/he will return the virus to the original attacker if can't she/he does'nt return it
public abstract class ReflectionAbility {
    //Use effect in certain situation
    public abstract void invokeEffect(Virologist vir1, Virologist vir2, Virus v);
}
