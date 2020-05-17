package modele;

public class Player extends Character{
    public Player(int x, int y, Board map) {
        super(x, y, map);
    }
    private boolean isZoneAdjacent(AbstractZone zone){
        return Math.abs(zone.x-this.x) + Math.abs(zone.y-this.y) == 1;
    }

    /**
     *
     * @param az zone that needs to be at 1 absolute distance of the player
     * @return direction to go to to reach the tile.
     */
    public Direction playerToZoneDirection(AbstractZone az){
        switch (az.x - this.x){
            case 1:
                return Direction.right;
            case -1:
                return Direction.left;
            case 0:
                switch (az.y-this.y) {
                    case 1:
                        return Direction.down;
                    case -1:
                        return Direction.up;
                }
        }
        return Direction.up;
    }


    public boolean zoneReachable(AbstractZone az){
        if (az instanceof NormalZone && this.isZoneAdjacent(az)){
            if (((NormalZone) az).getWaterState() == WaterState.normal){
                return true;
            }
        }
        return false;
    }
}
