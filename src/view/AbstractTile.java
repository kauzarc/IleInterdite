package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.AbstractZone;
import observerObservable.Observer;

public abstract class AbstractTile extends Group implements Observer {

    private final AbstractZone zone;
    private final Rectangle background;

    final static Color NORMAL = Color.BROWN;
    final static Color FLOODED = Color.BLUE;
    final static Color SUBMERGED = Color.DARKBLUE;

    public AbstractTile(AbstractZone actualZone, int SCALE) {
        this.background = new Rectangle(SCALE * actualZone.getX() + 1, SCALE * actualZone.getY() + 1, SCALE - 2, SCALE - 2);
        getChildren().add(this.background);
        this.zone = actualZone;
        update();
    }

    public void update() {
        switch (this.zone.getWaterState()) {
            case normal:
                this.background.setFill(NORMAL);
                break;
            case flooded:
                this.background.setFill(FLOODED);
                break;
            case submerged:
                this.background.setFill(SUBMERGED);
                break;
        }
    }

    public AbstractZone getZone() {
        return this.zone;
    }
}