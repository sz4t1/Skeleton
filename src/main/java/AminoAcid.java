package src.main.java;

//This Class is used to represent a material that can be used to create viruses
//This Class extends src.main.java.Material abstract class
public class AminoAcid extends Material {
    //Constructor
    public AminoAcid(){
        System.out.println("src.main.java.AminoAcid constructed");
    }
    //We override the abstract method beingUsed so we can use src.main.java.AminoAcid en recipes
    @Override
    public void beingUsed(){
        System.out.println("beingUsed()");
    }
}
