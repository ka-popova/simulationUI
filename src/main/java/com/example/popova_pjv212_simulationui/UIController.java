package com.example.popova_pjv212_simulationui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import popova.simulation.gui.ForestMap;
import popova.simulation.items.Coordinates;
import popova.simulation.items.Item;

public class UIController {
    @FXML
    private GridPane gridPane;

    public void fillGridPane(ForestMap forestMap) {
        for (int y = 0; y < forestMap.getSize().getHeight(); y++) {
            for (int x = 0; x < forestMap.getSize().getWidth(); x++) {
                Item item = forestMap.getItem(new Coordinates(x, y));
                if (item == null) {
                    continue;
                }
                Image image = ImageLoader.getImage(item);
                ImageView imageView = new ImageView(image);
                gridPane.add(imageView, x, y);
            }
        }


    }

    public void clearGridPane() {
        gridPane.getChildren().clear();

    }

}