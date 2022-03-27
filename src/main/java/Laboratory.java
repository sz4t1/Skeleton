package src.main.java;

//src.main.java.Laboratory is a field on the map that contains genetic code
//It extends the src.main.java.Field class
public class Laboratory extends Field{
    //Id of a gen code the src.main.java.Laboratory have
    private Integer geneticCode;
    //src.main.java.Virologist scans the genetic code
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
