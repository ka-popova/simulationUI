package popova.simulation.animals;

import popova.simulation.interfaces.Eatable;
import popova.simulation.items.Item;

public class Fox extends Animal implements Eatable /*implements Moveable*/ {




    public Fox(int foodLevel, int speed, int healthLevel /*, Coordinates coordinates*/) {
        super(foodLevel, speed, healthLevel /*, coordinates*/);
    }

  @Override
    public int getFoodLevelIncreasing() {
        return 10;
    }


    @Override
    public boolean kill(Item eatenItem) {
        if (eatenItem instanceof Hare hare) {
            setFoodLevel(getFoodLevel() + hare.getFoodLevelIncreasing());
            hare.setHealthToZero();
            return true;
        }
        return false;



    }

//    @Override
//    public void move(ForestMap map) {
//
//        if (map.noObjectNear(this.getCoordinates()) {
//            Random r = new Random();
//            int direction = r.nextInt (3);
//            int go = r.nextInt(this.getSpeed());

//        }

//
//        }
        // if (еще одна лиса isNear && у this-лисы уровень сытости максимальный && у второй лисы уровень сытости максимальный) {
        //     create
        // }

//        }
//        // if (Заяц isNear || Мышь isNear || && у this-лисы уровень сытости < максимального) {
//        //     eat
//        // }
//
}


