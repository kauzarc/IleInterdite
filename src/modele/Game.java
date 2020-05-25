package modele;

import javafx.stage.Stage;
import view.ViewDirector;

import java.util.ArrayList;
import java.util.List;

public class Game implements Container {
    public enum PlayerActionMode {
        moving, drying, looting
    }

    private final Board board;
    private final List<AbstractPlayer> players;
    private ViewDirector viewDirector;

    private int currentPlayerIndex;
    private int actionCount;
    private PlayerActionMode actionMode;

    private final Inventory inventory;

    private Game(int sizeX, int sizeY, int nbPlayer) {
        this.board = new Board(this, sizeX, sizeY);
        this.players = new ArrayList<>();

        for (int i = 0; i < nbPlayer; i++) {
            addPlayer();
        }

        this.currentPlayerIndex = 0;
        this.actionCount = 0;
        this.actionMode = PlayerActionMode.moving;

        this.inventory = new Inventory(this, AbstractItem.Element.values().length);
        for (AbstractItem.Element e : AbstractItem.Element.values()) {
            this.inventory.addItem(new Key(e));
        }
    }

    public Game(Stage stage, int sizeX, int sizeY, int nbPlayer) {
        this(sizeX, sizeY, nbPlayer);
        this.viewDirector = new ViewDirector(this, stage);
    }

    static Game gameForTest(int sizeX, int sizeY, int nbPlayer) {
        return new Game(sizeX, sizeY, nbPlayer);
    }

    private void addPlayer() {
        int i = this.players.size() + 1;
        this.players.add(new BasicPlayer(i, i, this.board));
    }

    public Board getBoard() {
        return this.board;
    }

    public List<AbstractPlayer> getPlayers() {
        return this.players;
    }

    public AbstractPlayer getCurrentPlayer() {
        return this.players.get(currentPlayerIndex);
    }

    public void upActionCount() {
        this.actionCount++;
    }

    public void nextPlayer() {
        this.actionCount = 0;
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        for (AbstractPlayer player : this.players) {
            player.notifyObservers();
        }
    }

    public int getActionCount() {
        return actionCount;
    }

    public void setActionMode(PlayerActionMode newActionMode) {
        this.actionMode = newActionMode;
    }

    public PlayerActionMode getActionMode() {
        return this.actionMode;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
