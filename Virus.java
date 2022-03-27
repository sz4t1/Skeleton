//Abstract class which represents the viruses of the game
public abstract class Virus {
    //The time until it disappears from the virologist
    private Integer expirationTime;
    //Count down
    public void CountTimeDown(){}
    //Use effect on virologist
    public abstract void Effect(Virologist v);
    //Remove effect on virologist
    public abstract void EffectOff(Virologist v);
    //Get-set
    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }
}
