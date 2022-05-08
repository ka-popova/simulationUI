package popova.simulation.animals;

import popova.simulation.interfaces.Eatable;
import popova.simulation.items.Berry;
import popova.simulation.items.Item;

public class Mouse extends Animal implements Eatable {

//    public static Mouse create() {
//        Random r = new Random();
//        int randFoodLevel = r.nextInt(4) + 3;
//        int randHealthLevel = r.nextInt(4) + 3;
//        int randSpeed = r.nextInt(6);
//        Coordinates coordinates = new Coordinates(r.nextInt(MAX_X), r.nextInt(MAX_Y));
//
//        return new Mouse(randFoodLevel, randSpeed, randHealthLevel, coordinates);
//    }

    public Mouse(int foodLevel, int speed, int healthLevel/*, Coordinates coordinates*/) {
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
            return 3;
        }


}

