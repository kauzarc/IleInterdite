package view;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import modele.Artifact;

public class ArtifactGraphics extends ItemGraphics {
    private final Rectangle rectangle;

    public ArtifactGraphics(Group parent, Artifact artifact, int scale, int x, int y) {
        super(parent, artifact, scale, x, y);
        this.rectangle = new Rectangle(this.scale * this.x + 10, this.scale * y + 10, scale - 20, scale - 20);
        getChildren().add(this.rectangle);
    }

    @Override
    public void show() {
        this.rectangle.setFill(COLOR_MAP.get(item.getElement()));
    }
}
