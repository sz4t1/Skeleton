//Laboratory is a field on the map that contains genetic code
//It extends the Field class
public class Laboratory extends Field{
    //Constructor
    public Laboratory(){
        this.setName("Laboratory");
        System.out.println("Laboratory() - Laboratory created");
    }
    //Id of a gen code the Laboratory have
    private Integer geneticCode;
    //Virologist scans the genetic code
    public void BeingScanned(Virologist v){
        System.out.println(geneticCode+" BeingScanned(Virologist v)");
    }
    //Get-set
    public Integer getGeneticCode() {
        System.out.println("getGeneticCode()");
        return geneticCode;
    }

    public void setGeneticCode(Integer geneticCode) {
        this.geneticCode = geneticCode;
    }
}
