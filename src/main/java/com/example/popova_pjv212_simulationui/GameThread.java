package com.example.popova_pjv212_simulationui;

import javafx.application.Platform;
import popova.simulation.context.GameController;

public class GameThread extends Thread {
    private GameController gameController;
    private UIController controller;
    
    public GameThread (GameController gameController, UIController controller) {
        super();
        this.gameController = gameController;
        this.controller = controller;
    }
    @Override
    public void run() {
        while (true) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    controller.clearGridPane();
                    controller.fillGridPane(gameController.getForestMap());
                }
            });

            gameController.iterate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
