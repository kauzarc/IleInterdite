package modele;

import view.AbstractPlayerGraphics;
import view.BasicPlayerGraphics;

public class BasicPlayer extends AbstractPlayer {
    public BasicPlayer(int x, int y, Board map) {
        super(x, y, map);
    }

    @Override
    public AbstractPlayerGraphics createGraphics(int scale) {
        return new BasicPlayerGraphics(this, scale);
    }
}
