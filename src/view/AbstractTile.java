package view;

import ObserverObservable.Observer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.AbstractZone;

public abstract class AbstractTile extends Rectangle implements Observer {

    private final AbstractZone zone;

    final static Color NORMAL = Color.BROWN;
    final static Color FLOODED = Color.BLUE;
    final static Color SUBMERGED = Color.DARKBLUE;

    public AbstractTile(AbstractZone actualZone, int SCALE) {
        super(SCALE * actualZone.getX()+1,SCALE * actualZone.getY()+1,SCALE -2, SCALE -2);
        this.zone = actualZone;
        update();
    }

    public void update() {
        switch (this.zone.getWaterState()) {
            case normal:
                this.setFill(NORMAL);
                break;
            case flooded:
                this.setFill(FLOODED);
                break;
            case submerged:
                this.setFill(SUBMERGED);
                break;
        }
    }
}