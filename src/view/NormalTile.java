package view;

import ObserverObservable.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.NormalZone;
import modele.WaterState;

import java.awt.*;

public class NormalTile extends javafx.scene.shape.Rectangle implements Observer{

    private final NormalZone normalZone;

    final static Color NORMAL = Color.BROWN;
    final static Color FLOODED = Color.BLUE;
    final static Color SUBMERGED = Color.DARKBLUE;


    public NormalTile(NormalZone actualZone, int SCALE) {
        super(SCALE * actualZone.getX()+1,SCALE * actualZone.getY()+1,SCALE -2, SCALE -2);
        this.normalZone = actualZone;
        update();
    }

    public void update() {
        switch (this.normalZone.getWaterState()) {
            case normal:
                
                break;
            case submerged:

                break;
            case flooded:

        }
    }
}
