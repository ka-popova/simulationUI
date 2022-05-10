package popova.simulation.humans;

import popova.simulation.animals.Animal;
import popova.simulation.gui.ForestMap;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public class Hunter extends Human {


    public Hunter(int speed, int accuracy, int killingRange, int killingItemsCount/*, Coordinates coordinates*/) {
        super(speed, accuracy, killingRange, killingItemsCount/*, coordinates*/);

    }

    @Override
    public int getRange() {
        return 10;
    }

    private int getDistanceRight(ForestMap forestMap, int x, int y){
        for (int itemPos = x+1; itemPos < forestMap.getSize().getWidth(); itemPos++) {
            Item item = forestMap.getItem(new Coordinates(itemPos, y));
            if (item != null) {
                if (item instanceof Animal){
                    return itemPos-x;
                }
                return -1;
            }
        }
        return -1;
    }

    private int getDistanceLeft(ForestMap forestMap, int x, int y){
        for (int itemPos = x-1; itemPos >= 0; itemPos--) {
            Item item = forestMap.getItem(new Coordinates(itemPos, y));
            if (item != null) {
                if (item instanceof Animal){
                    return x-itemPos;
                }
                return -1;
            }
        }
        return -1;
    }

    private int getDistanceDown(ForestMap forestMap, int x, int y){
        for (int itemPos = y+1; itemPos < forestMap.getSize().getHeight(); itemPos++) {
            Item item = forestMap.getItem(new Coordinates(x, itemPos));
            if (item != null) {
                if (item instanceof Animal){
                    return itemPos-y;
                }
                return -1;
            }
        }
        return -1;
    }

    private int getDistanceUp(ForestMap forestMap, int x, int y){
        for (int itemPos = y-1; itemPos >= 0; itemPos--) {
            Item item = forestMap.getItem(new Coordinates(itemPos, y));
            if (item != null) {
                if (item instanceof Animal){
                    return y-itemPos;
                }
                return -1;
            }
        }
        return -1;
    }





    @Override
    public void move(ForestMap forestMap, int x, int y) {
        int distRight = getDistanceRight(forestMap, x, y);
        int distLeft = getDistanceLeft(forestMap, x, y);
        int distDown = getDistanceDown(forestMap, x, y);
        int distUp = getDistanceUp(forestMap, x, y);

        int min = distRight;
        if (distLeft < min && distLeft != -1){
            min = distLeft;
        }
        if (distDown < min && distDown != -1) {
            min = distDown;
        }
        if (distUp < min && distUp != -1) {
            min = distUp;
        }

        if (min == -1) {
            defaultMove(forestMap, x, y);
            return;
        }

        if (min == distRight) {
            moveRight(forestMap, x, y);
            return;
        }
        if (min == distLeft) {
            moveLeft(forestMap, x, y);
            return;
        }
        if (min == distDown) {
            moveDown(forestMap, x, y);
            return;
        }
        if (min == distUp) {
            moveUp(forestMap, x, y);
            return;
        }
    }
}
