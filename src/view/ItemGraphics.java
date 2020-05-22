package view;

import javafx.scene.Group;
import modele.AbstractItem;

public abstract class ItemGraphics extends Group {
    private Group parent;
    protected AbstractItem item;

    public ItemGraphics(Group parent, AbstractItem item) {
        this.parent = parent;
        this.item = item;
        this.parent.getChildren().add(this);
    }

    public void remove() {
        this.parent.getChildren().remove(this);
    }

    public void move(Group newParent) {
        remove();
        this.parent = newParent;
        this.parent.getChildren().add(this);
    }
}
