package modele;

import view.AbstractTile;

public class ArtifactZone extends AbstractZone {
    private Artifact artifact;
    protected ArtifactZone(Board board, int x, int y, Artifact artifact) {
        super(board, x, y);
        this.artifact = artifact;
    }

    public Artifact getArtifact(){
        return this.artifact;
    }


    public boolean isThereArtifact(){
        return !(this.artifact == Artifact.nothing);
    }

    @Override
    public Artifact loot(){
        System.out.println("la vie y a un truc");
        Artifact treasure = this.artifact;
        this.artifact = Artifact.nothing;
        return treasure;
    }

    @Override
    public AbstractTile createTile(int scale) {
        return null;
    }
}
