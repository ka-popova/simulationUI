package popova.simulation.interfaces;

import popova.simulation.gui.ForestMap;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public interface Killer {
    boolean kill(Item item);

    int getRange();

    private boolean getItemAndKill(ForestMap forestMap, int x, int y){

        Item item = forestMap.getItem(new Coordinates(x, y));
        if (item != null) {
            return (kill(item));
        }
        return false;
    }

    default boolean tryToKill(ForestMap forestMap, Coordinates coordinates) {
        // go right
        for (int x = coordinates.getX()+1; x <= coordinates.getX() + getRange(); x++) {
            boolean killSuccess;
            try {
                killSuccess = getItemAndKill(forestMap, x, coordinates.getY());
            }
            catch(ArrayIndexOutOfBoundsException e) {
                break;

            }
            if (killSuccess) {
                return true;
            }
        }

        // go left
        for (int x = coordinates.getX()-1; x >= coordinates.getX() - getRange(); x--) {
            boolean killSuccess;
            try {
                killSuccess = getItemAndKill(forestMap, x, coordinates.getY());
            }
            catch(ArrayIndexOutOfBoundsException e) {
                break;

            }
            if (killSuccess) {
                return true;
            }
        }
        // go down
        for (int y = coordinates.getY()+1; y <= coordinates.getY() + getRange(); y++) {
            boolean killSuccess;
            try {
                killSuccess = getItemAndKill(forestMap, coordinates.getX(), y);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                break;

            }
            if (killSuccess) {
                return true;
            }

        }
        // go up
        for (int y = coordinates.getY()-1; y >= coordinates.getY() - getRange(); y--) {
            boolean killSuccess;
            try {
                killSuccess = getItemAndKill(forestMap, coordinates.getX(), y);
            }
            catch(ArrayIndexOutOfBoundsException e) {
                break;

            }
            if (killSuccess) {
                return true;
            }


        }
        return false;


    }

}
