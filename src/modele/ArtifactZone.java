package modele;

import view.AbstractTile;
import view.ArtifactTile;

public class ArtifactZone extends AbstractZone implements Container {
    private final Inventory inventory;

    protected ArtifactZone(Board board, int x, int y) {
        super(board, x, y);
        this.inventory = new Inventory(this, 1);
    }

    public Artifact getArtifact() {
        return (Artifact) this.inventory.get(0);
    }


    public boolean isThereArtifact() {
        return this.inventory.getCount() != 0;
    }

    @Override
    public boolean loot(Inventory inventory) {
        if (this.inventory.moveItemTo(0, inventory)) {
            notifyObservers();
            return true;
        }
        return false;
    }

    @Override
    public AbstractTile createTile(int scale) {
        return new ArtifactTile(this, scale);
    }

    public boolean setArtifact(Artifact artifact) {
        return this.inventory.addItem(artifact);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
}
