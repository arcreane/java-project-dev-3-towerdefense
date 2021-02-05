package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {
    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader();
            URL url = new File("src/com/company/view/MapView.fxml").toURI().toURL();
            loader.setLocation(url);
            System.out.println(loader.getLocation());
            this.root = new BorderPane();
            this.root.getChildren().add(loader.load());

            this.scene = new Scene(this.root, 1500, 800);
            primaryStage.setTitle("8bitTowerDefenseUltraEditionFightUltimateAlpha");
            primaryStage.setScene(this.scene);
            primaryStage.show();
            this.startGameLoop(this.root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    private void startGameLoop(BorderPane pane) {
        Units mage = new Units(pane, "mage");
    }

    private static void update() {

    }

    private static void draw() {
    }
}
