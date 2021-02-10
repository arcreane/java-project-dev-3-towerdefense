package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    List<Units> enemies = new ArrayList<>();
    private Scene scene;
    private BorderPane root;
    private boolean gameRunning;

    public static void main(String[] args) {
        launch(args);
    }

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
            this.gameRunning = true;
            this.startGameLoop(this.root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startGameLoop(BorderPane pane) {
        final long[] lastTimer = {System.currentTimeMillis()};
        final int[] countLoop = {0};
        User user = new User(200);

        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (System.currentTimeMillis() - lastTimer[0] >= 1000) {
                    String[] type = {"rogue", "war", "mage"};
                    Units mage = countLoop[0] % 2 == 0 ? new Units(pane, 1445, 240, type[(int) (Math.random() * ((2) + 1))]) : new Units(pane, 1445, 290, type[(int) (Math.random() * ((2) + 1))]);
                    enemies.add(mage);
                    lastTimer[0] += 1000;
                    countLoop[0]++;
                }


                enemies.forEach(enemy ->{
                    enemy.move();
                });

            }

        };
        gameLoop.start();
    }
}