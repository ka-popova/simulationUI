package popova.simulation.humans;

import popova.simulation.animals.Animal;
import popova.simulation.interfaces.Killer;
import popova.simulation.items.Alive;
import popova.simulation.items.Item;

public abstract class Human extends Alive implements Killer {
    private int killingRange;
    private int accuracy;
    private int killingItemsCount;
//    private Coordinates coordinates;

    protected Human(int speed, int killingRange, int accuracy, int killingItemsCount/*, Coordinates coordinates*/) {
        super(speed, 1);
        this.accuracy = accuracy;
        this.killingRange = killingRange;
        this.killingItemsCount = killingItemsCount;
//        this.coordinates = coordinates;
    }


    public int getAccuracy() {return accuracy; }

    public int getKillingItemsCount() {
        return killingItemsCount;
    }

    public int getKillingRange() {
        return killingRange;
    }

    @Override
    public boolean kill(Item item) {
        if (killingItemsCount == 0) {
            return false;
        }
        if (item instanceof Animal) {
            item.setHealthToZero();
            killingItemsCount--;
            return true;
        }
        return false;

    }

    public abstract int getRange();

    public boolean noMoreKillingItems (){
        return this.killingItemsCount <= 0;
    }

}
