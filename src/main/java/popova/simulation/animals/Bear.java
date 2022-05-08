package popova.simulation.animals;

import popova.simulation.items.Item;

public class Bear extends Animal {

//    public static Bear create (){
//        Random r = new Random();
//        int randFoodLevel = r.nextInt(4)+3;
//        int randHealthLevel = r.nextInt(4)+3;
//        int randSpeed = r.nextInt(6);
//        Coordinates coordinates = new Coordinates (r.nextInt(MAX_X), r.nextInt(MAX_Y));
//
//        return new Bear (randFoodLevel, randSpeed, randHealthLevel, coordinates);
//    }


    public Bear(int foodLevel, int speed, int healthLevel/*, Coordinates coordinates*/) {
        super(foodLevel, speed, healthLevel/*, coordinates*/);
    }




    @Override
    public boolean kill(Item eatenItem) {
        if (eatenItem instanceof Fox fox) {
            setFoodLevel(getFoodLevel() + fox.getFoodLevelIncreasing());
            fox.setHealthToZero();
            return true;
        }
        return false;

    }
}
