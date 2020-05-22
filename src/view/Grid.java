package view;

import controller.TileClickedHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import modele.AbstractPlayer;
import modele.AbstractZone;
import modele.Board;
import observerObservable.Observer;


public class Grid extends Pane implements Observer {
    final static int SCALE = 50;
    final static Color NORMAL = Color.BROWN, FLOODED = Color.BLUE, SUBMERGED = Color.DARKBLUE;

    private final Board board;

    public Grid(Board board) {
        super();
        this.board = board;
        this.board.addObserver(this);

        setUp();
        setUpPlayer();
    }

    public void setUp() {
        for (int x = 0; x < board.getSizeX(); x++) {
            for (int y = 0; y < this.board.getSizeY(); y++) {
                AbstractZone actualZone = this.board.getAt(x, y);
                AbstractTile tile = actualZone.createTile(SCALE);
                this.getChildren().add(tile);
                actualZone.addObserver(tile);
                tile.setOnMouseClicked(new TileClickedHandler(this.board.getGame(), tile));
            }
        }
    }

    public void setUpPlayer() {
        for (AbstractPlayer p : this.board.getGame().getPlayers()) {
            AbstractPlayerGraphics cg = p.createGraphics(SCALE);
            this.getChildren().add(cg);
        }
    }

    @Override
    public void update() {

    }
}
