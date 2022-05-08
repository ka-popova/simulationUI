package popova.simulation.interfaces;

import popova.simulation.context.Utils;
import popova.simulation.gui.ForestMap;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public abstract class Moveable extends Item {
    public abstract int getSpeed();

    public Moveable(int healthLevel) {
        super(healthLevel);
    };

    public void moveRight(ForestMap forestMap, int x, int y) {
        int currentX = x;
        for (int pos = x+1; pos <= x+getSpeed(); pos++) {
            Item item;
            try {
                item = forestMap.getItem(new Coordinates(pos, y));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (item != null) {
                break;
            }
            currentX++;
        }
        forestMap.setItem(this, new Coordinates(currentX, y) );
        forestMap.removeItem(this, new Coordinates(x,y));
    }

    public void moveLeft(ForestMap forestMap, int x, int y) {
        int currentX = x;
        for (int pos = x - 1; pos >= x - getSpeed(); pos--) {
            Item item;
            try {
                item = forestMap.getItem(new Coordinates(pos, y));
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (item != null) {
                break;
            }
            currentX--;
        }
        forestMap.setItem(this, new Coordinates(currentX, y));
        forestMap.removeItem(this, new Coordinates(x, y));
    }
    public void moveDown(ForestMap forestMap, int x, int y) {
        int currentY = y;
        for (int pos = y + 1; pos <= y + getSpeed(); pos++) {
            Item item;
            try {
                item = forestMap.getItem(new Coordinates(x, pos));
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (item != null) {
                break;
            }
            currentY++;
        }
        forestMap.setItem(this, new Coordinates(x, currentY));
        forestMap.removeItem(this, new Coordinates(x, y));
    }

    public void moveUp(ForestMap forestMap, int x, int y) {
        int currentY = y;
        for (int pos = y-1; pos >= y-getSpeed(); pos--) {
            Item item;
            try {
                item = forestMap.getItem(new Coordinates(x, pos));
            }
            catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
            if (item != null) {
                break;
            }
            currentY--;
        }
        forestMap.setItem(this, new Coordinates(x, currentY) );
        forestMap.removeItem(this, new Coordinates(x,y));

    }

    public void defaultMove(ForestMap forestMap, int x, int y) {
        int direction = Utils.rand(1,4);
        if (direction == 1) {
            moveRight(forestMap, x, y);
        }
        if (direction == 2) {
            moveLeft(forestMap, x, y);
        }
        if (direction == 3) {
            moveDown(forestMap, x, y);
        }
        if (direction == 4) {
            moveUp(forestMap, x, y);
        }

    }

    public abstract void move(ForestMap forestMap, int x, int y);
}
