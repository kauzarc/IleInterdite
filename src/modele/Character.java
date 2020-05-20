package modele;

import observerObservable.Observable;

public abstract class Character extends Observable {
    protected int x;
    protected int y;
    protected Board map;

    public Character(int x, int y, Board map) {
        super();
        System.out.println("[" + x + "," + y + "]");
        this.x = x;
        this.y = y;
        this.map = map;
    }

    public void walk(Direction D) {
        switch (D) {
            case up:
                if (this.y > 0) {
                    this.y -= 1;
                }
                break;
            case down:
                if (this.y < this.map.getSizeY() - 1) {
                    this.y += 1;
                }
                break;
            case right:
                if (this.x < this.map.getSizeX() - 1) {
                    this.x += 1;
                }
                break;
            case left:
                if (this.x > 0) {
                    this.x -= 1;
                }
            default:
                break;
        }
        this.notifyObservers();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public AbstractZone getZone() {
        return this.map.getAt(this.x, this.y);
    }

    public Board getBoard(){
        return this.map;
    }
}
