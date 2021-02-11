package com.company;

import javafx.css.FontFace;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.awt.*;

/**
 *
 */
public class User {

    public int hp;
    public String pseudo;
    private int money;
    /**
     *
     */
    private Text moneyText;
    private Text hpText;
    /**
     *
     */
    private BorderPane pane;
    private Text pseudoText;

    /**
     * Default constructor
     */
    public User(BorderPane pane, int hp, String pseudo) {
        this.setPane(pane);
        this.setHp(hp);
        this.setPseudo(pseudo);
        this.setMoney(100);
        this.createUserInterface(pane, hp, pseudo);
    }
    public void setMoneyText(Text moneyText) { this.moneyText = moneyText; }

    public Text getMoneyText() { return moneyText; }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    private void createUserInterface(BorderPane pane, int hp, String pseudo) {
        Group root = new Group();

        Text hpTextText = this.createText("Hp: "+String.valueOf(hp), 50, 70);
        Text pseudoTextText = this.createText(upperCaseFirst(pseudo), 50, 50);

        Text userMoney = this.createText(String.valueOf("Money: " +this.getMoney()),50,90);

        hpTextText.setFill(Color.RED);
        userMoney.setFill(Color.GOLD);

        this.setMoneyText(userMoney);
        this.setHpText(hpTextText);
        this.setPseudoText(pseudoTextText);

        root.getChildren().add(pseudoTextText);
        root.getChildren().add(hpTextText);
        root.getChildren().add(userMoney);
        pane.getChildren().add(root);

        this.setPane(pane);
    }

    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    public void buyTower(int price)
    {
        int currentMoney = this.getMoney();
        if (currentMoney > 0){
            int newMoney = this.getMoney() - price;
            this.setMoney(newMoney);
            this.getMoneyText().setText("Money: "+String.valueOf(newMoney));
            System.out.println(this.getMoney());
        }
        if (currentMoney <= 0) {
            this.setMoney(0);
            this.getMoneyText().setText("Money: "+String.valueOf(0));
            Text errorMoney = this.createText("Not enough money", 1000, 700);
            this.getPane().getChildren().add(errorMoney);
        }
    }

    private Text createText(String sentence, int X, int Y) {
        Text text = new Text();
        text.setText(sentence);
        text.setFont(Font.font("Verdana", 20));
        text.setX(X);
        text.setY(Y);

        return text;
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Text getPseudoText() {
        return pseudoText;
    }

    public void setPseudoText(Text pseudoText) {
        this.pseudoText = pseudoText;
    }

    public Text getHpText() {
        return hpText;
    }

    public void setHpText(Text hpText) {
        this.hpText = hpText;
    }

    public boolean receiveDmg(int dmg) {
        int hp = this.getHp() - dmg;
        this.setHp(hp);
        this.getHpText().setText("Hp: "+String.valueOf(hp));

        if (hp <= 0) {
            Text GameOver = this.createText("GAME OVER", 1000, 600);
            this.getPane().getChildren().add(GameOver);
            return false;
        }
        return true;
    }
}