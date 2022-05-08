package popova.simulation.gui;

import popova.simulation.context.Size;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

import java.util.ArrayList;
import java.util.List;

import static popova.simulation.context.Utils.MAX_X;
import static popova.simulation.context.Utils.MAX_Y;

public class ForestMap {
    private Item[][] map;

    public ForestMap() {
        this.map = new Item[MAX_Y][MAX_X];
    }

    public Item getItem(Coordinates coordinates) {
        return map[coordinates.getY()][coordinates.getX()];
    }

    public void removeItem(Item item, Coordinates coordinates) {
        map[coordinates.getY()][coordinates.getX()] = null;
    }

    public void setItem(Item item, Coordinates coordinates) {
        map[coordinates.getY()][coordinates.getX()] = item;
    }

    public Size getSize() {
        return new Size(MAX_Y, MAX_X);
    }

//    public void moveItem(Item item, Coordinates oldCoordinates, Coordinates newCoordinates) {
//        removeItem(oldCoordinates);
//        setItem(item, newCoordinates);
//    }

    public boolean noObjectNear(Coordinates coordinates) {
        return ((map[coordinates.getY()][coordinates.getX()+1] == null)
                && (map[coordinates.getY()][coordinates.getX()-1] == null)
                && (map[coordinates.getY()+1][coordinates.getX()] == null)
                && (map[coordinates.getY()-1][coordinates.getX()] == null));
    }

    public List<Coordinates> getFreeSpaces() {
        List<Coordinates> listFreeSpaces = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x=0; x < map[y].length; x++) {
                if (map[y][x] == null) {
                    listFreeSpaces.add(new Coordinates(x, y));
                }
            }
        }
        return listFreeSpaces;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x=0; x < map[y].length; x++) {
                if (map[y][x] == null) {
                    stringBuilder.append("    ");
                }
                else {
                    stringBuilder.append(map[y][x]).append(" ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
