package view;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import modele.HeliportZone;

public class HeliportTile extends AbstractTile {
    private final Text text;

    public HeliportTile(HeliportZone actualZone, int SCALE) {
        super(actualZone, SCALE);
        this.text = new Text(SCALE * actualZone.getX() + 1, SCALE * actualZone.getY() + SCALE, "H");
        this.text.setFont(new Font(50));
        getChildren().add(this.text);
        update();
    }

    @Override
    public void update() {
        super.update();
    }
}
