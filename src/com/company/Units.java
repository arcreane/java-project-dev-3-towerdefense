package com.company;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 *
 */
public class Units {

    /**
     * Default constructor
     */

    public Image assets;
    private String name;
    private int hp;
    private int dmg;
    private int speed;
    private int worth;

    public Image getAssets() {
        return assets;
    }

    public void setAssets(Image assets) {
        this.assets = assets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }

    public Units(BorderPane pane, String type) {

        switch (type) {
            case "mage":
                this.constructMage(type);
                break;
            case "war":
                this.constructWar(type);
                break;
            case "rogue":
                this.constructRogue(type);
                break;
        }

        this.addToPane(pane);
    }

    private void addToPane(BorderPane pane) {
        ImageView imageView = new ImageView(this.getAssets());
        imageView.relocate(0, 0);
        imageView.setRotate(0);
        pane.getChildren().add(imageView);

    }

    private void constructRogue(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile248.png"));
        this.setName(type);
        this.setHp(100);
        this.setDmg(15);
        this.setSpeed(3);
        this.setWorth(15);
    }

    private void constructWar(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile247.png"));
        this.setName(type);
        this.setHp(250);
        this.setDmg(30);
        this.setSpeed(1);
        this.setWorth(25);
    }

    private void constructMage(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile246.png"));
        this.setName(type);
        this.setHp(200);
        this.setDmg(25);
        this.setSpeed(2);
        this.setWorth(20);
    }

    /**
     *
     */
    public int attack() {
        return this.dmg;
    }

    /**
     *
     */
    public void move() {

    }

}