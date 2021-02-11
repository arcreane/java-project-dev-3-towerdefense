package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.*;

/**
 *
 */
public class Tower {

    private String name;
    private int AD;
    private int worth;
    private int range;
    private double AS;
    private int positionX;
    private int positionY;
    public Image assets;
    private ImageView imageView;
    private BorderPane pane;

    public Tower(BorderPane pane, int locationX, int locationY, String type) {
        switch (type) {
            case "rocket":
                this.constructRocket(type);
                break;
            case "drone":
                this.constructDrone(type);
                break;
            case "rifle":
                this.constructRifle(type);
                break;
        }

        this.addToPane(pane, locationX, locationY);
    }

    public int getAD() {
        return AD;
    }

    public void setAD(int AD) {
        this.AD = AD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getAS() {
        return AS;
    }

    public void setAS(double AS) {
        this.AS = AS;
    }

    public Image getAssets() {
        return assets;
    }

    public void setAssets(Image assets) {
        this.assets = assets;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    private void constructRocket(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile205.png"));
        this.setName(type);
        this.setAD(20);
        this.setWorth(100);
        this.setAS(1);
        this.setRange(100);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    private void constructDrone(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile249.png"));
        this.setName(type);
        this.setAD(50);
        this.setWorth(150);
        this.setAS(0.5);
        this.setRange(200);
    }

    private void constructRifle(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile204.png"));
        this.setName(type);
        this.setAD(10);
        this.setWorth(50);
        this.setAS(1.3);
        this.setRange(50);
    }

    private void addToPane(BorderPane pane, int locationX, int locationY) {
        this.setImageView(new ImageView(this.getAssets()));
        this.getImageView().relocate(locationX, locationY);
        this.getImageView().setRotate(0);
        pane.getChildren().add(imageView);
        this.setPositionX(locationX);
        this.setPositionY(locationY);
        this.setPane(pane);
    }
/**
 public void attack(Units unit) {
 unit.setHp(unit.getHp() - this.getAD());
 }

 public void sell(User user) {
 user.setMoney(user.getMoney() + this.getWorth());
 }

 public void buy(User user) {
 user.setMoney(user.getMoney() - this.getWorth());
 }
 */
}