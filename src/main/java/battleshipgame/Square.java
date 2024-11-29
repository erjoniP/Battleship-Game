package battleshipgame;

import java.io.Serializable;

public class Square implements Serializable {
    Ship ship;
    public boolean isHit;

    public boolean isHit() {
        return isHit;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Square(){

    }
}
