package modele;

import exception.ZoneUnreachableException;

public class Player extends Character {
    public Player(int x, int y, Board map) {
        super(x, y, map);
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
        if (az instanceof NormalZone && this.isZoneAdjacent(az)) {
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

}