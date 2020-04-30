package modele;

public class Normal_zone extends AbstractZone{
    public Normal_zone (int x, int y){
        this.x = x;
        this.y = y;
        this.waterState = WaterState.normal;
    }
}
