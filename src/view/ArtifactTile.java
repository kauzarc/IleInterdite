package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.Artifact;
import modele.ArtifactZone;

public class ArtifactTile extends AbstractTile {
    static final Color FIRE = Color.RED, WATER = Color.DARKBLUE, EARTH = Color.MAROON, WIND = Color.WHITE;

    private final Rectangle artifact;

    public ArtifactTile(ArtifactZone actualZone, int SCALE) {
        super(actualZone, SCALE);
        this.artifact = new Rectangle(SCALE * actualZone.getX() + 10, SCALE * actualZone.getY() + 10, SCALE - 20, SCALE - 20);
        this.getChildren().add(this.artifact);
        update();
    }

    @Override
    public void update() {
        super.update();
        ArtifactZone zone = (ArtifactZone) getZone();
        Artifact artifact = zone.getArtifact();

        if (artifact != null) {
            switch (artifact.getElement()) {
                case fire:
                    this.artifact.setFill(FIRE);
                    break;
                case water:
                    this.artifact.setFill(WATER);
                    break;
                case earth:
                    this.artifact.setFill(EARTH);
                    break;
                case wind:
                    this.artifact.setFill(WIND);
                    break;
            }
        } else {
            this.artifact.setFill(this.background.getFill());
        }
    }
}