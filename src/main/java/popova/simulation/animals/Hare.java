package popova.simulation.animals;

import popova.simulation.interfaces.Eatable;
import popova.simulation.items.Berry;
import popova.simulation.items.Item;

public class Hare extends Animal implements Eatable {


        public Hare(int foodLevel, int speed, int healthLevel/*, Coordinates coordinates*/) {
            super(foodLevel, speed, healthLevel/*, coordinates*/);
        }




        @Override
        public boolean kill(Item eatenItem ) {
            if (eatenItem instanceof Berry berry) {
                setFoodLevel(getFoodLevel() + berry.getFoodLevelIncreasing());
                berry.setHealthToZero();
                return true;
            }
            return false;

        }

    @Override
    public int getFoodLevelIncreasing() {
        return 5;
    }
}
