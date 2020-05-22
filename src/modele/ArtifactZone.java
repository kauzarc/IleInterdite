package modele;

import view.AbstractTile;
import view.ArtifactTile;

public class ArtifactZone extends AbstractZone {
    private Artifact artifact;

    protected ArtifactZone(Board board, int x, int y) {
        super(board, x, y);
        this.artifact = artifact;
    }

    public Artifact getArtifact() {
        return this.artifact;
    }


    public boolean isThereArtifact() {
        return this.artifact != null;
    }

    @Override
    public Artifact loot() {
        System.out.println("la vie y a un truc");
        Artifact treasure = this.artifact;
        this.artifact = null;
        return treasure;
    }

    @Override
    public AbstractTile createTile(int scale) {
        return new ArtifactTile(this, scale);
    }

    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }
}
