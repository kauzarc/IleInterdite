package view;

import javafx.scene.paint.Color;
import modele.ArtifactZone;

public class ArtifactTile extends AbstractTile {
    static final Color FIRE = Color.RED, WATER = Color.DARKBLUE, EARTH = Color.MAROON, WIND = Color.WHITE;

    private ArtifactGraphics artifactGraphics;

    public ArtifactTile(ArtifactZone actualZone, int SCALE) {
        super(actualZone, SCALE);
        if (actualZone.getArtifact() != null) {
            this.artifactGraphics = new ArtifactGraphics(this, actualZone.getArtifact(), SCALE, actualZone.getX(), actualZone.getY());
        } else {
            this.artifactGraphics = null;
        }
        update();
    }

    @Override
    public void update() {
        super.update();
        ArtifactZone zone = (ArtifactZone) getZone();
        if (zone.isThereArtifact()) {
            this.artifactGraphics.show();
        } else {
            if (this.artifactGraphics != null) {
                this.artifactGraphics.remove();
                this.artifactGraphics = null;
            }
        }
    }
}