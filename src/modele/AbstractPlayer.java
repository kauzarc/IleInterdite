package modele;

import exception.ZoneUnreachableException;
import observerObservable.Observable;
import view.AbstractPlayerGraphics;

public abstract class AbstractPlayer extends Observable {
    protected int x;
    protected int y;
    protected Board map;
    protected PlayerInventory inventory;

    public AbstractPlayer(int x, int y, Board map) {
        System.out.println("[" + x + "," + y + "]");
        this.x = x;
        this.y = y;
        this.map = map;
        this.inventory = new PlayerInventory(this);
    }

    public void walk(Direction D) {
        switch (D) {
            case up:
                if (this.y > 0) {
                    this.y -= 1;
                }
                break;
            case down:
                if (this.y < this.map.getSizeY() - 1) {
                    this.y += 1;
                }
                break;
            case right:
                if (this.x < this.map.getSizeX() - 1) {
                    this.x += 1;
                }
                break;
            case left:
                if (this.x > 0) {
                    this.x -= 1;
                }
            default:
                break;
        }
        this.notifyObservers();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public AbstractZone getZone() {
        return this.map.getAt(this.x, this.y);
    }

    public Board getBoard() {
        return this.map;
    }

    private boolean isZoneAdjacent(AbstractZone zone) {
        return Math.abs(zone.x - this.x) + Math.abs(zone.y - this.y) == 1;
    }

    /**
     * @param az zone that needs to be at 1 absolute distance of the player
     * @return direction to go to to reach the tile.
     */
    public Direction playerToZoneDirection(AbstractZone az) throws ZoneUnreachableException {
        switch (az.x - this.x) {
            case 1:
                return Direction.right;
            case -1:
                return Direction.left;
            case 0:
                switch (az.y - this.y) {
                    case 1:
                        return Direction.down;
                    case -1:
                        return Direction.up;
                }
        }
        throw new ZoneUnreachableException("zone: [" + az.x + "," + az.y + "] too far for player: [" + this.x + "," + this.y + "]");
    }

    public boolean zoneReachable(AbstractZone az) {
        if (this.isZoneAdjacent(az)) {
            return az.getWaterState() != WaterState.submerged;
        }
        return false;
    }

    //fonction a modifié plus tard surment avec l'ajout de l'inventaire
    public Artifact lootTheZone() {
        AbstractZone actualPOS = this.map.getAt(this.x, this.y);
        return actualPOS.loot();
    }

    public void dry(AbstractZone zone) {
        zone.dryWater();
        notifyObservers();
    }

    public abstract AbstractPlayerGraphics createGraphics(int scale);
}