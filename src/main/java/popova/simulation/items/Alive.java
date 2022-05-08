package popova.simulation.items;

import popova.simulation.interfaces.Moveable;

public abstract class Alive extends Moveable {
    private int speed;


    public Alive(int speed, int healthLevel) {
        super(healthLevel);
        this.speed = speed;
    }


    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
