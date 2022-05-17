//Abstract class which represents the viruses of the game
public abstract class Virus {
    /**
     * The time until it disappears from the virologist
     * If it's 0, it's expired
     * If it's -1, it lasts for ever
     */
    private Integer expirationTime = 8;
    //The ability to override a virus
    //Its always true except bearDance
    protected  boolean overwritable;
    //név
    protected String name;
    //Count down
    public void CountTimeDown(){expirationTime--;}
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

    protected boolean getOverwritable(){return overwritable;}

    public String getName(){return name;}
}
