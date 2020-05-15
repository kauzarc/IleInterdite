package modele;


public abstract class AbstractZone {
    protected WaterState waterState;
    protected final int x;
    protected final int y;

    protected AbstractZone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "#";
    }

    public Boolean canReceiveWater() {
        return !(this.waterState == WaterState.submerged);
    }

    public WaterState getWaterState() {
        return waterState;
    }

    public void fillWithWater (){
        switch(this.waterState){
            case normal:
                this.waterState = WaterState.flooded;
                break;
            case flooded:
                this.waterState = WaterState.submerged;
                break;
            default:
                System.out.println("Ne peut pas être plus remplie");
        }
    }
}
