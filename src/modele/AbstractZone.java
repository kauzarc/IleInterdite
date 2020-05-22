package modele;


import observerObservable.Observable;
import view.AbstractTile;

public abstract class AbstractZone extends Observable {
    protected WaterState waterState;
    protected final int x;
    protected final int y;
    protected final Board board;

    protected AbstractZone(Board board, int x, int y) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.waterState = WaterState.normal;
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

    public boolean loot(Inventory inventory) {
        System.out.println("ca fouille wolla");
        return false;
    }

    public abstract AbstractTile createTile(int scale);
}
