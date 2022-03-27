public abstract class Virus {
    private Integer expirationTime;

    public void CountTimeDown(){}

    public abstract void Effect(Virologist v);

    public abstract void EffectOff(Virologist v);

    public Integer getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Integer expirationTime) {
        this.expirationTime = expirationTime;
    }
}
