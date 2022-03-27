package src.main.java;

//This Class is used to represent a material that can be used to create viruses
//This Class extends src.main.java.Material abstract class
public class Nukleotide extends Material {
    //We override the abstract method beingUsed so we can use src.main.java.Nukleotide en recipes
    @Override
    public void beingUsed() {
        System.out.println("src.main.java.Nukleotide used");
    }
}
