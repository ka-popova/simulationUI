package com.example.popova_pjv212_simulationui;

import com.example.popova_pjv212_simulationui.HelloController;
import javafx.application.Platform;
import popova.simulation.context.GameController;

public class GameThread extends Thread {
    private GameController gameController;
    private HelloController controller;
    
    public GameThread (GameController gameController, HelloController controller) {
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
