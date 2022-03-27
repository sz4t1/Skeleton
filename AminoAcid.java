//This Class is used to represent a material that can be used to create viruses
//This Class extends Material abstract class
public class AminoAcid extends Material {
    //We override the abstract method beingUsed so we can use AminoAcid en recipes
    @Override
    public void beingUsed(){
        System.out.println("This amino was used");
    }
}
