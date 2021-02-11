package com.company;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

            Scanner scanner = new Scanner(System.in);
            FXMLLoader loader = new FXMLLoader();
            URL url = new File("src/com/company/view/MapView.fxml").toURI().toURL();
            loader.setLocation(url);
            System.out.println(loader.getLocation());
            this.root = new BorderPane();
            this.root.getChildren().add(loader.load());

            System.out.print("Enter your name: ");
            String username = scanner.next();
            System.out.print("Welcome " + username);

            User player = new User(this.root, 200, username);

            this.scene = new Scene(this.root, 1500, 800);
            primaryStage.setTitle("8bitTowerDefenseUltraEditionFightUltimateAlpha");
            primaryStage.setScene(this.scene);
            primaryStage.show();
            this.gameRunning = true;
            this.startGameLoop(player, this.root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startGameLoop(User player, BorderPane pane) {
        final long[] lastTimer = {System.currentTimeMillis()};
        final int[] countLoop = {0};

        AnimationTimer gameLoop = new AnimationTimer() {

            public boolean continueGameLoop = true;

            @Override
            public void handle(long now) {
                if (System.currentTimeMillis() - lastTimer[0] >= 1000) {
                    String[] type = {"rogue", "war", "mage"};
                    Units mage = countLoop[0] % 2 == 0 ? new Units(pane, 1445, 240, type[(int) (Math.random() * ((2) + 1))]) : new Units(pane, 1445, 290, type[(int) (Math.random() * ((2) + 1))]);
                    enemies.add(mage);
                    lastTimer[0] += 1000;
                    countLoop[0]++;

                    enemies.removeIf(enemy -> enemy.getHp() == 0);
                    enemies.forEach(enemy -> {
                            enemy.receiveDmg(25);
                    });
                }


                enemies.forEach(enemy -> {
                    int attack = enemy.move();
                    if (attack != 0) {
                       this.continueGameLoop = player.receiveDmg(attack);
                    }
                });

                if (!this.continueGameLoop) {
                    this.stop();
                }

            }

        };
        gameLoop.start();
    }
}