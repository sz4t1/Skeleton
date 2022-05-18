package src;

import java.util.ArrayList;

//This class is makes the virologist to move randomly
//This extends MovementAbility abstract class
public class BearMovement extends MovementAbility {
    public BearMovement(){
        System.out.println("BearMovement() - BearMovement (ability) constructed.");
    }
    //Use the effect in certain situation
    @Override
    public void invokeEffect(Virologist v, Field f) {
        System.out.println("invokeEffect(Virologist v, Field f) - You are a bear");
        //moves to the next field
        //the destination field should be random, that's tha Game's responsibility
        if(v.getField().IsNeighbour(f)) {
            v.getField().RemoveVirologist(v);
            f.AddVirologist(v);
            v.setField(f);

            //Infecting other virologists
            for (Virologist vir : f.getVirologists()) {
                v.Attack(new BearDance(), vir);
            }

            //destroying the materials
            ArrayList<Material> ms = f.getMaterials();
            if(ms != null){
                for (Material material : ms) {
                    f.Remove(null, material, null);
                }
            }
            return;
        }
        System.out.println("The two fields aren't neighbors, the virologist couldn't step there.");
    }
}
