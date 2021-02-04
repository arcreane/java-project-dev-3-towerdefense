package com.company;

import java.util.*;
import javafx.scene.image.Image;

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

    public Units(String type) {

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
    }

    private void constructRogue(String type) {
        this.assets = new Image("com/company/tiles/towerDefense_tile248.png");
        this.name = type;
        this.hp = 100;
        this.dmg = 15;
        this.speed = 3;
        this.worth = 15;
    }

    private void constructWar(String type) {
        this.assets = new Image("com/company/tiles/towerDefense_tile247.png");
        this.name = type;
        this.hp = 250;
        this.dmg = 30;
        this.speed = 1;
        this.worth = 25;
    }

    private void constructMage(String type) {
        this.assets = new Image("com/company/tiles/towerDefense_tile246.png");
        this.name = type;
        this.hp = 200;
        this.dmg = 25;
        this.speed = 2;
        this.worth = 20;
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