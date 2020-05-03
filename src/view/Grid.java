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

    private final Board board;

    public Grid(Board board) {
        super(board.getSizeX() * SCALE, board.getSizeY() * SCALE);
        this.board = board;
        this.board.addObserver(this);

        update();
    }

    @Override
    public void update() {
        GraphicsContext gc = getGraphicsContext2D();
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < board.getSizeY(); y++) {
                WaterState waterState = this.board.getAt(x, y).getWaterState();
                switch (waterState) {
                    case normal:
                        gc.setFill(NORMAL);
                        break;
                    case submerged:
                        gc.setFill(SUBMERGED);
                        break;
                    case flooded:
                        gc.setFill(FLOODED);
                }
                gc.fillRect(x * SCALE + 1, y * SCALE + 1, SCALE - 2, SCALE - 2);
            }
        }
    }
}
