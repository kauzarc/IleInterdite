package view;

import modele.AbstractZone;

import java.awt.*;

public class ArtifactTile extends AbstractTile{
    private Rectangle artifact;
    public ArtifactTile(AbstractZone actualZone, int SCALE) {
        super(actualZone, SCALE);
    }
}
