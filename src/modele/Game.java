package modele;

import javafx.stage.Stage;
import view.ViewDirector;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public enum PlayerActionMode {
        moving, drying
    }

    private final Board board;
    private final List<Player> players;
    private final ViewDirector viewDirector;

    private final int currentPlayerIndex;
    private int actionCount;
    private PlayerActionMode actionMode;

    public Game(Stage stage, int sizeX, int sizeY, int nbPlayer) {
        this.board = new Board(this, sizeX, sizeY);
        this.players = new ArrayList<>();
        for (int i = 0; i < nbPlayer; i++) {
            addPlayer();
        }
        this.currentPlayerIndex = 0;
        this.actionCount = 0;
        this.actionMode = PlayerActionMode.moving;
        this.viewDirector = new ViewDirector(this, stage);

    }

    private void addPlayer() {
        int i = this.players.size()+1;
        this.players.add(new Player(i, i, this.board));
    }

    public Board getBoard() {
        return this.board;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Player getCurrentPlayer() {
        return this.players.get(currentPlayerIndex);
    }

    public void upActionCount() {
        this.actionCount++;
    }

    public void resetActionCount(){
        this.actionCount = 0;
    }

    public int getActionCount() {
        return actionCount;
    }

    public void switchActionMode() {
        switch (this.actionMode) {
            case moving:
                this.actionMode = PlayerActionMode.drying;
                break;
            case drying:
                this.actionMode = PlayerActionMode.moving;
                break;
        }
    }

    public PlayerActionMode getActionMode() {
        return actionMode;
    }
}
