package modele;

import java.util.ArrayList;
import java.util.List;

public class PlayerInventory {
    private final List<AbstractItem> itemList;
    private final AbstractPlayer player;

    public PlayerInventory(AbstractPlayer player) {
        this.itemList = new ArrayList<>();
        this.player = player;
    }
}
