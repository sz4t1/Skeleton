//Laboratory is a field on the map that contains genetic code
//It extends the Field class
public class Laboratory extends Field{
    static private int codeIndex = 1;
    //Id of a gen code the Laboratory have
    private Integer geneticCode;

    //Constructor
    public Laboratory(){
        System.out.println("Laboratory() - Laboratory constructed: " + this);
        geneticCode = codeIndex++;
    }
    
    //Virologist scans the genetic code
    public void Remove(Equipment e, Material m, Virologist v){
        System.out.println(geneticCode+" BeingScanned(Virologist v)");
        v.AddGeneticCode(this.geneticCode);
    }

    //With this function, the Game will count all the Laboratories
    //This returns with 1, unlike the other Field like classes
    @Override
    public int LabCount(){
        return 1;
    }
}
