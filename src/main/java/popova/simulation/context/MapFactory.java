package popova.simulation.context;

import popova.simulation.animals.Bear;
import popova.simulation.animals.Fox;
import popova.simulation.animals.Hare;
import popova.simulation.animals.Mouse;
import popova.simulation.gui.ForestMap;
import popova.simulation.humans.Hunter;
import popova.simulation.items.Berry;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

import java.util.List;
import java.util.Random;

public class MapFactory {

  


    public static void createMap(ForestMap forestMap) {
        //random generation numbers of items

        Random r = new Random();
        int initNumberFox = Utils.rand(3,20);
        int initNumberBear = Utils.rand(3,20);
        int initNumberHare = Utils.rand(3,20);
        int initNumberMouse = Utils.rand(3,20);
        int initNumberBerry = Utils.rand(30,100);
        int initNumberHunter = Utils.rand(3,10);



//        //constructor AnimalContext
//        AnimalContext animalContext = new AnimalContext (initNumberFox, initNumberBear, initNumberHare, initNumberMouse, initNumberBerry, initNumberHunter);

        //create animals, adding to lists




        for (int i=0; i<initNumberFox; i++) {
            Fox fox = createFox();
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            forestMap.setItem(fox, coordinates);
        }

        for (int i=0; i<initNumberBear; i++) {
            Bear bear = createBear();
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            forestMap.setItem(bear, coordinates);
        }

        for (int i=0; i<initNumberHare; i++) {
            Hare hare = createHare();
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            forestMap.setItem(hare, coordinates);
    }

        for (int i=0; i<initNumberMouse; i++) {
            Mouse mouse = createMouse();
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            forestMap.setItem(mouse, coordinates);
        }

        for (int i=0; i<initNumberBerry; i++) {
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            Berry berry = new Berry();

            forestMap.setItem(berry, coordinates);
        }

        for (int i=0; i<initNumberHunter; i++) {
            int randSpeed = Utils.rand(3, 8);
            int randAccuracy = Utils.rand(3, 9);
            int randKillingRange = Utils.rand(3,10);
            int randKillingItems = Utils.rand(5, 20);
            List<Coordinates> free = forestMap.getFreeSpaces();
            int n = Utils.rand(0, free.size()-1);
            Coordinates coordinates = free.get(n);

            Hunter hunter = new Hunter(randSpeed, randAccuracy, randKillingRange, randKillingItems);

            forestMap.setItem(hunter, coordinates);
        }
    }

    public static Bear createBear(){
        int randFoodLevel = Utils.rand(6, 20);
        int randHealthLevel = Utils.rand(3, 10);
        int randSpeed = Utils.rand(0, 4);

        Bear bear = new Bear(randFoodLevel, randSpeed, randHealthLevel);
        return bear;
    }

    public static Fox createFox() {
        int randFoodLevel = Utils.rand(3, 10);
        int randHealthLevel = Utils.rand(3, 10);
        int randSpeed = Utils.rand(0, 5);
        Fox fox = new Fox(randFoodLevel, randSpeed, randHealthLevel);
        return fox;
    }

    public static Hare createHare() {
        int randFoodLevel = Utils.rand(2, 5);
        int randHealthLevel = Utils.rand(3, 10);
        int randSpeed = Utils.rand(0, 5);
        Hare hare = new Hare(randFoodLevel, randSpeed, randHealthLevel);
        return hare;
    }

    public static Mouse createMouse() {
        int randFoodLevel = Utils.rand(1, 3);
        int randHealthLevel = Utils.rand(3, 10);
        int randSpeed = Utils.rand(0, 3);
        Mouse mouse = new Mouse(randFoodLevel, randSpeed, randHealthLevel);
        return mouse;
    }

    public static void randomLocate(ForestMap forestMap, Item item) {
        List<Coordinates> free = forestMap.getFreeSpaces();
        int n = Utils.rand(0, free.size()-1);
        Coordinates coordinates = free.get(n);

        forestMap.setItem(item, coordinates);

    }


}
