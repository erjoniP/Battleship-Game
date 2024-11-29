package battleshipgame;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ship extends Locationsrv implements Serializable {
    ShipType shipType;
    int x;
    int y;
    String direction;
    boolean isDestroyed;
    private List<Locationsrv> locationsrvs = new ArrayList<>();


    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Ship(ShipType shipType, int x, int y) {
        this.shipType = shipType;
        this.x = x;
        this.y = y;

    }

    public List<Locationsrv> getLocations() {
        return locationsrvs;
    }

    public Ship(){
        super();

    }
}
