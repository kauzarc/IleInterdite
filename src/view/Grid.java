package view;

import ObserverObservable.Observer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.AbstractZone;
import modele.Board;
import modele.NormalZone;
import modele.WaterState;


public class Grid extends Canvas implements Observer {
    final static int SCALE = 50;
    final static Color NORMAL = Color.BROWN, FLOODED = Color.BLUE, SUBMERGED = Color.DARKBLUE;

    private final Board board;

    public Grid(Board board) {
        super(board.getSizeX() * SCALE, board.getSizeY() * SCALE);
        this.board = board;
        this.board.addObserver(this);

        setUp();
    }

    public void setUp(){
        GraphicsContext gc = getGraphicsContext2D();
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < board.getSizeY(); y++) {
                AbstractZone actualZone = this.board.getAt(x,y);
                if (actualZone instanceof NormalZone){
                    actualZone.addObserver(new NormalTile((NormalZone) actualZone, SCALE, getGraphicsContext2D()));
                }
            }
        }
    }

    @Override
    public void update() {
        
    }
}
