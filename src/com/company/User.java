package com.company;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 */
public class User {

    public int hp;
    public String pseudo;
    private int money;
    private BorderPane pane;
    private Text moneyText;
    private Text hpText;
    private Text pseudoText;

    /**
     * Default constructor
     * @param pane player's screen panel
     * @param hp player's int hp
     * @param pseudo player's string pseudo
     */
    public User(BorderPane pane, int hp, String pseudo) {
        this.setPane(pane);
        this.setHp(hp);
        this.setPseudo(pseudo);
        this.setMoney(100);
        this.createUserInterface(pane, hp, pseudo);
    }

    /**
     * @param val String value
     * @return String with uppercase
     */
    public static String upperCaseFirst(String val) {
        char[] arr = val.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
    }

    /**
     * @return Text of current money
     */
    public Text getMoneyText() {
        return moneyText;
    }

    /**
     * @param moneyText Text of current money
     */
    public void setMoneyText(Text moneyText) {
        this.moneyText = moneyText;
    }

    /**
     * @return int current player's hp
     */
    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp int set player's hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return String pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo String set pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @param pane player screen pane
     * @param hp player's hp
     * @param pseudo player's pseudo
     */
    private void createUserInterface(BorderPane pane, int hp, String pseudo) {
        Group root = new Group();

        Text hpTextText = this.createText("Hp: " + hp, 50, 70);
        Text pseudoTextText = this.createText(upperCaseFirst(pseudo), 50, 50);

        Text userMoney = this.createText("Money: " + this.getMoney(), 50, 90);

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

    /**
     * @param price int of tower's price
     */
    public void buyTower(int price) {
        int currentMoney = this.getMoney();
        if (currentMoney > 0) {
            int newMoney = this.getMoney() - price;
            this.setMoney(newMoney);
            this.getMoneyText().setText("Money: " + newMoney);
            System.out.println(this.getMoney());
        }
        if (currentMoney <= 0) {
            this.setMoney(0);
            this.getMoneyText().setText("Money: " + 0);
            Text errorMoney = this.createText("Not enough money", 1000, 700);
            this.getPane().getChildren().add(errorMoney);
        }
    }

    /**
     * @param sentence String containing the sentence that will be display
     * @param X        Int position X of the Text
     * @param Y        Int position Y of the Text
     * @return Text containing the sentence
     */
    private Text createText(String sentence, int X, int Y) {
        Text text = new Text();
        text.setText(sentence);
        text.setFont(Font.font("Verdana", 20));
        text.setX(X);
        text.setY(Y);

        return text;
    }

    /**
     * @return pane
     */
    public BorderPane getPane() {
        return pane;
    }

    /**
     * @param pane set the pane
     */
    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    /**
     * @return player's current money
     */
    public int getMoney() {
        return money;
    }

    /**
     * @param money set player's money
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * @return Text pseudo text
     */
    public Text getPseudoText() {
        return pseudoText;
    }

    /**
     * @param pseudoText set pseudo text
     */
    public void setPseudoText(Text pseudoText) {
        this.pseudoText = pseudoText;
    }

    /**
     * @return Text of player's hp
     */
    public Text getHpText() {
        return hpText;
    }

    /**
     * @param hpText set player's hp text
     */
    public void setHpText(Text hpText) {
        this.hpText = hpText;
    }

    /**
     * @param dmg number of dmg
     * @return boolean if user's hp fall to zero or lower
     */
    public boolean receiveDmg(int dmg) {
        int hp = this.getHp() - dmg;
        this.setHp(hp);
        this.getHpText().setText("Hp: " + hp);

        if (hp <= 0) {
            Text GameOver = this.createText("GAME OVER", 1000, 600);
            this.getPane().getChildren().add(GameOver);
            return false;
        }
        return true;
    }
}