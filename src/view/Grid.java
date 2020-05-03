package view;

import ObserverObservable.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.Board;
import modele.WaterState;


public class Grid extends Canvas implements Observer {
    final static int SCALE = 50;
    final static Color NORMAL = Color.BROWN, FLOODED = Color.BLUE, SUBMERGED = Color.DARKBLUE;

    private Board board;

    public Grid(Board board) {
        super((double)(board.getSizeX() * SCALE), (double)(board.getSizeY() * SCALE));
        this.board = board;
        this.board.addObserver(this);

        update();
    }

    @Override
    public void update() {
        GraphicsContext gc = getGraphicsContext2D();
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < board.getSizeY(); y++) {
                if (this.board.getAt(x, y).getWaterState() == WaterState.normal)
                {
                    gc.setFill(NORMAL);
                }
                gc.fillRect(x * SCALE, y * SCALE, SCALE, SCALE);
            }
        }
    }
}
