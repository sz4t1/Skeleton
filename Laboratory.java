//Laboratory is a field on the map that contains genetic code
//It extends the Field class
public class Laboratory extends Field{
    //Id of a gen code the Laboratory have
    private Integer geneticCode;
    //Virologist scans the genetic code
    public void BeingScanned(Virologist v){
        System.out.println(geneticCode+" Scannelve");
    }
    //Get-set
    public Integer getGeneticCode() {
        return geneticCode;
    }

    public void setGeneticCode(Integer geneticCode) {
        this.geneticCode = geneticCode;
    }
}
