package modele;

public abstract class Character {
    protected int x;
    protected int y;
    protected Board map;

    public Character(int x,int y, Board map){
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public void deplacement(Direction D){
        switch (D){
            case up:
                if(this.y < this.map.getSizeY() - 1){
                    this.y += 1;
                }
                break;
            case down:
                if(this.y > 0) {
                    this.y -= 1;
                }
                break;
            case right:
                if(this.x < this.map.getSizeX() - 1){
                    this.x += 1;
                }
                break;
            case left:
                if(this.x > 0){
                    this.x -= 1;
                }
            default:
                break;
        }
    }


}
