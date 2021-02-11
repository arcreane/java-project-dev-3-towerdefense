package com.company.controller;

import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

    public Pane paneEntite;

    public Pane getPane() {
        return this.paneEntite;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chargerShop();
    }

    private void chargerShop() {
        generate("com/company/tiles/towerDefense_tile203.png");
        generate("com/company/tiles/towerDefense_tile205.png");
        generate("com/company/tiles/towerDefense_tile249.png");

    }

    private void generate(String url) {
        Image obstacle = new Image(url);
        ImageView caseObstacle = new ImageView();
        caseObstacle.setFitHeight(50);
        caseObstacle.setFitWidth(50);
        caseObstacle.setImage(obstacle);
        paneEntite.getChildren().add(caseObstacle);
    }
}
