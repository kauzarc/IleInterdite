package modele;

public class ArtifactZone extends AbstractZone {
    private Artifact artifact;
    protected ArtifactZone(int x, int y, Artifact artifact) {
        super(x, y);
        this.artifact = artifact;
    }

    public Artifact getArtifact(){
        return this.artifact;
    }

    public Artifact recoverArtifact(){
        Artifact treasure = this.artifact;
        this.artifact = Artifact.nothing;
        return treasure;
    }

    public boolean isThereArtifact(){
        return !(this.artifact == Artifact.nothing);
    }

    @Override
    public Artifact loot(){
        System.out.println("la vie y a un truc");
        return this.artifact;
    }
}
