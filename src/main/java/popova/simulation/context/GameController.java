package popova.simulation.context;

import popova.simulation.animals.Animal;
import popova.simulation.animals.Fox;
import popova.simulation.animals.Hare;
import popova.simulation.gui.ForestMap;
import popova.simulation.humans.Hunter;
import popova.simulation.interfaces.Killer;
import popova.simulation.interfaces.Moveable;
import popova.simulation.items.Berry;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public class GameController {

    private ForestMap forestMap = new ForestMap();
    public GameController() {

//        Hare hare1 = new Hare(4,3,4);
//        Hare hare = new Hare(3,4,3);
//        Hunter hunter = new Hunter(5, 10,6,10);
//        Fox fox = new Fox(4, 5, 5);
//        Fox fox1 = new Fox(4, 3, 4);
//        Berry berry = new Berry();
//
//        forestMap.setItem(hare1, new Coordinates(0, 5));
//        forestMap.setItem(hare, new Coordinates(10, 7));
//        forestMap.setItem(hunter, new Coordinates(12, 5));
//        forestMap.setItem(fox, new Coordinates(4, 7));
//        forestMap.setItem(fox1, new Coordinates(4, 6));
//        forestMap.setItem(berry, new Coordinates(11, 7));
        MapFactory.createMap(forestMap);

    }



    public ForestMap getForestMap() {
        return forestMap;
    }

    public void iterate() {
        System.out.println(forestMap);
        System.out.println("---------------------");
        Size mapSize = forestMap.getSize();
        for (int y = 0; y < mapSize.getHeight(); y++) {
            for (int x = 0; x < mapSize.getWidth(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                Item item = forestMap.getItem(coordinates);
                if (item == null) {
                    continue;
                }
                if (item instanceof Killer killer) {
                    if (killer.tryToKill(forestMap, coordinates)) {
                        clear();
                        continue;
                    }
                }
                if (item instanceof Animal animal) {
                    if (animal.makeNewAnimal(forestMap, x, y)) {
                        continue;
                    }
                }
                if (item instanceof Moveable moveable) {
                    moveable.move(forestMap, x, y);
                }
            }
        }

        System.out.println(forestMap);
    }

    private void clear() {
        Size mapSize = forestMap.getSize();
        for (int y = 0; y < mapSize.getHeight(); y++) {
            for (int x = 0; x < mapSize.getWidth(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                Item item = forestMap.getItem(coordinates);
                if (item != null && item.isKilled()) {
                    forestMap.removeItem(item, coordinates);
                }
            }
        }
    }
}
