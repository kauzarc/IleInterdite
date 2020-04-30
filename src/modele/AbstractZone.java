package modele;


public abstract class AbstractZone {
    protected WaterState waterState;
    protected int x;
    protected int y;

    public String toString(){
        return "#";
    }

    public Boolean canReceiveWater() {
        return !(this.waterState == WaterState.submerged);
    }

}
