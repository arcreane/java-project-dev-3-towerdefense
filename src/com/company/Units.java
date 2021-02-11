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
    private int positionX;
    private int positionY;
    private ImageView imageView;
    private BorderPane pane;

    public Units(BorderPane pane, int locationX, int locationY, String type) {

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

        this.addToPane(pane, locationX, locationY);
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

    private void addToPane(BorderPane pane, int locationX, int locationY) {
        this.setImageView(new ImageView(this.getAssets()));
        this.getImageView().relocate(locationX, locationY);
        this.getImageView().setRotate(0);
        pane.getChildren().add(imageView);

        //Store info
        this.setPositionX(locationX);
        this.setPositionY(locationY);
        this.setPane(pane);

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
     * @return move the unit in the map
     */
    public int move() {
        int X = this.getPositionX();
        int Y = this.getPositionY();
        int dmg = 0;

        if (X > 900) {                                  //←
            this.setPositionX(X - this.getSpeed());
        } else if (Y < 650 && (X <= 900 && X > 650)) {  //↓
            this.getImageView().setRotate(-90);
            this.setPositionY(Y + this.getSpeed());
        } else if (Y >= 650 && X > 650) {               //←
            this.getImageView().setRotate(0);
            this.setPositionX(X - this.getSpeed());
        } else if (X <= 650 && Y > 450) {               //↑
            this.getImageView().setRotate(90);
            this.setPositionY(Y - this.getSpeed());
        } else if (Y <= 450 && X > 375) {               //←
            this.getImageView().setRotate(0);
            this.setPositionX(X - this.getSpeed());
        } else if (X <= 375 && Y > 220) {               //↑
            this.getImageView().setRotate(90);
            this.setPositionY(Y - this.getSpeed());
        } else {                                        //←
            this.getImageView().setRotate(0);
            this.setPositionX(X - this.getSpeed());
        }

        if (X > 0 && X < 5) {
            dmg = this.getDmg();
        }

        this.getImageView().relocate(this.getPositionX(), this.getPositionY());
        return dmg;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int receiveDmg(int dmg) {
        int hp = this.getHp() - dmg;
        this.setHp(hp);
        if (hp <= 0) {
            this.getPane().getChildren().remove(imageView);
            return this.getWorth();
        }
        return 0;
    }
}