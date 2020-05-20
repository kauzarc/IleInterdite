package modele;


import observerObservable.Observable;

public abstract class AbstractZone extends Observable {
    protected WaterState waterState;
    protected final int x;
    protected final int y;

    protected AbstractZone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "#";
    }

    /**
     * @return Boolean means if the zone can be fill or not
     */
    public Boolean canReceiveWater() {
        return !(this.waterState == WaterState.submerged);
    }


    public WaterState getWaterState() {
        return waterState;
    }

    /**
     * upgrade the level of water of the zone
     */
    public void fillWithWater() {
        switch (this.waterState) {
            case normal:
                this.waterState = WaterState.flooded;
                break;
            case flooded:
                this.waterState = WaterState.submerged;
                break;
            case submerged:
                System.out.println("Ne peut pas être plus remplie");
        }
        notifyObservers();
    }

    public void dryWater() {
        switch (this.waterState) {
            case normal:
                System.out.println("Est deja sec");
                break;
            case flooded:
                this.waterState = WaterState.normal;
                break;
            case submerged:
                this.waterState = WaterState.flooded;
        }
        notifyObservers();
    }
}
