package popova.simulation.animals;

import popova.simulation.context.MapFactory;
import popova.simulation.gui.ForestMap;
import popova.simulation.interfaces.Killer;
import popova.simulation.items.Alive;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public abstract class Animal extends Alive implements Killer {
    private int foodLevel;
    private int healthLevel;
//    private Coordinates coordinates;

    protected Animal(int foodLevel, int speed, int healthLevel /*,Coordinates coordinates*/) {
        super(speed, healthLevel);
        this.foodLevel = foodLevel;
//        this.coordinates = coordinates;
    }

    public int getFoodLevel() {
        return foodLevel;
    }


    public void setFoodLevel (int foodLevel){
        this.foodLevel = foodLevel;
    }

//    public Coordinates getCoordinates() { return coordinates;}

    public abstract boolean kill(Item eatenItem);

    @Override
    public int getRange() {
        return 1;
    }

    private boolean sameClass(Object o1, Object o2) {
        if (o1 == null || o2 == null) {
            return false;
        }
        String o1Class = o1.getClass().getName();
        String o2Class = o2.getClass().getName();
        return o1Class.equals(o2Class);

    }


    private Item makeAnimal() {
        if (this instanceof Bear) {
            return MapFactory.createBear();
        }
        if (this instanceof Fox) {
            return MapFactory.createFox();
        }
        if (this instanceof Hare) {
            return MapFactory.createHare();
        }
        if (this instanceof Mouse) {
            return MapFactory.createMouse();
        }
        else {
            return null;
        }

    }

    public boolean makeNewAnimal (ForestMap forestMap, int x, int y) {
        Item item = null;

        //go right
        try {
            item = forestMap.getItem(new Coordinates(x + 1, y));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {

        }

        if (sameClass(item, this)) {
            MapFactory.randomLocate(forestMap, makeAnimal());
            return true;

        }


        //go left
        try {
            item = forestMap.getItem(new Coordinates(x-1, y));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {

        }

        if (sameClass(item, this))  {
            MapFactory.randomLocate(forestMap, makeAnimal());
            return true;

        }
        //go down

        try {
            item = forestMap.getItem(new Coordinates(x, y+1));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {

        }


        if (sameClass(item, this)) {
            MapFactory.randomLocate(forestMap, makeAnimal());
            return true;

        }
        //go up
        try {
            item = forestMap.getItem(new Coordinates(x, y-1));
        }
        catch (ArrayIndexOutOfBoundsException ignored) {

        }


        if (sameClass(item, this))  {
            MapFactory.randomLocate(forestMap, makeAnimal());
            return true;

        }

        return false;
    }

    public void move(ForestMap forestMap, int x, int y) {
        defaultMove(forestMap, x, y);
    }







    //    public void wound(Coordinates hunterCoordinates){
//        if (hunterCoordinates.isNear(this.coordinates)){
//            this.healthLevel = 0;
//        }
//        return;
//    }


    
}
