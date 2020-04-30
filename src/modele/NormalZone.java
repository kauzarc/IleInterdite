package modele;

public class NormalZone extends AbstractZone{
    public NormalZone (int x, int y){
        this.x = x;
        this.y = y;
        this.waterState = WaterState.normal;
    }
}
