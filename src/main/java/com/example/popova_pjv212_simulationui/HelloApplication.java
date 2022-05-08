package com.example.popova_pjv212_simulationui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import popova.simulation.context.GameController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    GameController gameController;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        gameController = new GameController();




        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        HelloController controller = fxmlLoader.getController();


        GameThread gameThread = new GameThread(gameController, controller);
        gameThread.start();
    }

    public static void main(String[] args) {
        launch();
    }
}