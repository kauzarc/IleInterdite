package view;

import modele.HeliportZone;

public class HeliportTile extends AbstractTile{
    public HeliportTile(HeliportZone actualZone, int SCALE) {
        super(actualZone, SCALE);
        update();
    }
}
