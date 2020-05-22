package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.ArtifactTile;

public class ArtifactClickedHandler implements EventHandler<MouseEvent> {
    ArtifactTile artifactTile;

    public ArtifactClickedHandler(ArtifactTile artifactTile) {
        this.artifactTile = artifactTile;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("Artifact clicked");
        mouseEvent.consume();
    }
}
