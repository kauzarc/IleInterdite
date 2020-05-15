package view;

import ObserverObservable.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.NormalZone;
import modele.WaterState;

public class NormalTile implements Observer{

    private final NormalZone normalZone;
    private final int SCALE;
    private final int x;
    private final int y;
    private final GraphicsContext gridGraphicalContext;

    final static Color NORMAL = Color.BROWN;
    final static Color FLOODED = Color.BLUE;
    final static Color SUBMERGED = Color.DARKBLUE;


    public NormalTile(NormalZone normalZone,int SCALE, GraphicsContext gridGraphicalContext) {
        this.SCALE = SCALE;
        this.normalZone = normalZone;
        this.x = normalZone.getX();
        this.y = normalZone.getY();
        this.gridGraphicalContext = gridGraphicalContext;
        update();
    }

    public void update() {
        switch (this.normalZone.getWaterState()) {
            case normal:
                gridGraphicalContext.setFill(NORMAL);
                break;
            case submerged:
                gridGraphicalContext.setFill(SUBMERGED);
                break;
            case flooded:
                gridGraphicalContext.setFill(FLOODED);
        }
        gridGraphicalContext.fillRect(x * SCALE + 1, y * SCALE + 1, SCALE - 2, SCALE - 2);
    }
}
