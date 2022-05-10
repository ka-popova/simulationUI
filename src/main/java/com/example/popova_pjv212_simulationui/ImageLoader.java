package com.example.popova_pjv212_simulationui;

import javafx.scene.image.Image;
import popova.simulation.animals.Bear;
import popova.simulation.animals.Fox;
import popova.simulation.animals.Hare;
import popova.simulation.animals.Mouse;
import popova.simulation.humans.Hunter;
import popova.simulation.items.Berry;
import popova.simulation.items.Item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageLoader {
    private static Image hareImage;
    private static Image foxImage;
    private static Image bearImage;
    private static Image mouseImage;
    private static Image berryImage;
    private static Image hunterImage;

    static {
        try {
            InputStream hareInputStream = new FileInputStream("src/images/hare.png");
            InputStream foxInputStream = new FileInputStream ("C:\\Users\\kasia\\IdeaProjects\\Popova_PJV212_simulationUI\\src\\images\\fox.png");
            InputStream bearInputStream = new FileInputStream ("src/images/bear.png");
            InputStream mouseInputStream = new FileInputStream ("C:\\Users\\kasia\\IdeaProjects\\Popova_PJV212_simulationUI\\src\\images\\mouse.png");
            InputStream berryInputStream = new FileInputStream ("C:\\Users\\kasia\\IdeaProjects\\Popova_PJV212_simulationUI\\src\\images\\berry.png");
            InputStream hunterInputStream = new FileInputStream ("C:\\Users\\kasia\\IdeaProjects\\Popova_PJV212_simulationUI\\src\\images\\hunter.png");

            hareImage = new Image(hareInputStream, 50, 50, false, true);
            foxImage = new Image(foxInputStream, 50, 50, false, true);
            bearImage = new Image(bearInputStream, 50, 50, false, true);
            mouseImage = new Image(mouseInputStream, 50, 50, false, true);
            berryImage = new Image(berryInputStream, 50, 50, false, true);
            hunterImage = new Image(hunterInputStream, 50, 50, false, true);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static Image getImage(Item item) {
        if (item instanceof Fox) {
            return foxImage;
        }
        if (item instanceof Hare) {
            return hareImage;
        }
        if (item instanceof Bear) {
            return bearImage;
        }
        if (item instanceof Mouse) {
            return mouseImage;
        }
        if (item instanceof Berry) {
            return berryImage;
        }
        if (item instanceof Hunter) {
            return hunterImage;
        }
        return null;
    }



}
