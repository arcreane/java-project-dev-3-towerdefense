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

    /**
     *
     * @param pane map of the game
     * @param locationX position x of image view
     * @param locationY position y of image view
     * @param type type of unit
     */
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

    /**
     *
     * @return get imageView of unit
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     *
     * @param imageView set imageView of unit
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     *
     * @return get pane of map
     */
    public BorderPane getPane() {
        return pane;
    }

    /**
     *
     * @param pane set pane of map
     */
    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    /**
     *
     * @return get assets of unit
     */
    public Image getAssets() {
        return assets;
    }

    /**
     *
     * @param assets set assets of sprite
     */
    public void setAssets(Image assets) {
        this.assets = assets;
    }

    /**
     *
     * @return get name of unit
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name set name of unit
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return get hp of unit
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp set hp of unit
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     *
     * @return get dmg of unit
     */
    public int getDmg() {
        return dmg;
    }

    /**
     *
     * @param dmg set dmg of unit
     */
    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    /**
     *
     * @return get speed of unit
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed set speed of unit
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     *
     * @return get worth of unit
     */
    public int getWorth() {
        return worth;
    }

    /**
     *
     * @param worth set worth of unit
     */
    public void setWorth(int worth) {
        this.worth = worth;
    }

    /**
     *
     * @param pane  map of the game
     * @param locationX position x of image view
     * @param locationY position y of image view
     */
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

    /**
     *
     * @param type of unit
     */
    private void constructRogue(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile248.png"));
        this.setName(type);
        this.setHp(100);
        this.setDmg(15);
        this.setSpeed(3);
        this.setWorth(15);
    }
    /**
     *
     * @param type of unit
     */
    private void constructWar(String type) {
        this.setAssets(new Image("com/company/tiles/towerDefense_tile247.png"));
        this.setName(type);
        this.setHp(250);
        this.setDmg(30);
        this.setSpeed(1);
        this.setWorth(25);
    }
    /**
     *
     * @param type of unit
     */
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
     * @return dmg of unit
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

    /**
     *
     * @return get positionY of unit
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     *
     * @param positionY set positionY of unit
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     *
     * @return get positionX of unit
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     *
     * @param positionX set positionX of unit
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
}