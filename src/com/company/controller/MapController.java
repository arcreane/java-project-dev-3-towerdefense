package com.company.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import com.company.model.MapModel;


public class MapController implements Initializable {

    private MapModel model = new MapModel();

    @FXML
    private TilePane paneDeLaCarte;

    public TilePane getTilePane() {
        return this.paneDeLaCarte;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chargerMap();
    }

    private void chargerMap() {
        model.initMap();
        int size = 20;
        for (int i = 0; i < model.getMap().length; i++) {
            for (int j = 0; j < model.getMap()[i].length; j++) {
                switch (model.getMap()[i][j]) {
                    case 343:
                        generate("com/company/tiles/towerDefense_tile003.png");
                        break;

                    case 389:
                        generate("com/company/tiles/towerDefense_tile025.png");
                        break;
                    case 436:
                        generate("com/company/tiles/towerDefense_tile001.png");
                        break;
                    case 34:
                        generate("com/company/tiles/towerDefense_tile050.png");
                        break;
                    case 435:
                        generate("com/company/tiles/towerDefense_tile026.png");
                        break;
                    case 438:
                        generate("com/company/tiles/towerDefense_tile027.png");
                        break;
                    case 392:
                        generate("com/company/tiles/towerDefense_tile023.png");
                        break;
                    case 346:
                        generate("com/company/tiles/towerDefense_tile004.png");
                        break;
                    case 38:
                        generate("com/company/tiles/towerDefense_tile038.png");
                        break;
                    case 716:
                        generate("com/company/tiles/towerDefense_tile049.png");
                        break;
                    case 437:
                        generate("com/company/tiles/towerDefense_tile047.png");
                        break;
                    case 44:
                        generate("com/company/tiles/TowerDefense_tile044.png");
                        break;


                }

            }
        }
    }

    public void generate(String url) {
        Image obstacle = new Image(url);
        ImageView caseObstacle = new ImageView();
        caseObstacle.setFitHeight(50);
        caseObstacle.setFitWidth(50);
        caseObstacle.setImage(obstacle);
        paneDeLaCarte.getChildren().add(caseObstacle);
    }

    public MapModel getMap() {
        return this.model;
    }

}

