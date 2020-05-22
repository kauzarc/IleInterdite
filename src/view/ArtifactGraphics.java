package view;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import modele.Artifact;

public class ArtifactGraphics extends ItemGraphics {
    private Rectangle rectangle;

    public ArtifactGraphics(Group parent, Artifact artifact) {
        super(parent, artifact);

    }
}
