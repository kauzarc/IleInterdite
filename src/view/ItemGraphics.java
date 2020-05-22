package view;

import controller.ItemClickedHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import modele.AbstractItem;

import java.util.HashMap;
import java.util.Map;

public abstract class ItemGraphics extends Group {
    protected static final Map<AbstractItem.Element, Color> COLOR_MAP;

    static {
        COLOR_MAP = new HashMap<>();
        COLOR_MAP.put(AbstractItem.Element.fire, Color.RED);
        COLOR_MAP.put(AbstractItem.Element.water, Color.DARKBLUE);
        COLOR_MAP.put(AbstractItem.Element.earth, Color.MAROON);
        COLOR_MAP.put(AbstractItem.Element.wind, Color.WHITE);
    }

    private Group parent;
    protected int x, y;
    protected AbstractItem item;
    protected int scale;

    public ItemGraphics(Group parent, AbstractItem item, int scale, int x, int y) {
        this.parent = parent;
        this.item = item;
        this.parent.getChildren().add(this);
        this.scale = scale;
        this.x = x;
        this.y = y;
        setOnMouseClicked(new ItemClickedHandler(this));
    }

    public void remove() {
        this.parent.getChildren().remove(this);
    }

    public void move(Group newParent, int x, int y) {
        remove();
        this.parent = newParent;
        this.parent.getChildren().add(this);
        this.x = x;
        this.y = y;
    }

    public abstract void show();
}
