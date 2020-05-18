package modele;

public class NormalZone extends AbstractZone {
    public NormalZone(int x, int y) {
        super(x, y);
        this.waterState = WaterState.normal;
    }
}
