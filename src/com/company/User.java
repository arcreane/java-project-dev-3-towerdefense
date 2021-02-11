package com.company;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 */
public class User {

    private int hp;
    private String pseudo;
    private int money;
    private Text moneyText;
    private Text hpText;
    private BorderPane pane;
    private Text pseudoText;

    /**
     * Default constructor
     */
    public User(BorderPane pane, int hp, String pseudo) {
        this.setPane(pane);
        this.setHp(hp);
        this.setPseudo(pseudo);
        this.createUserInterface(pane, hp, pseudo);
    }

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

        Text hpTextText = this.createText(String.valueOf(hp), 50, 70);
        Text pseudoTextText = this.createText(pseudo, 50, 50);

        this.setHpText(hpTextText);
        this.setPseudoText(pseudoTextText);

        root.getChildren().add(pseudoTextText);
        root.getChildren().add(hpTextText);

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
        int newMoney = this.getMoney() - price;
        this.setMoney(newMoney);
        this.getMoneyText().setText("Money: "+String.valueOf(newMoney));

        System.out.println(this.getMoney());
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
        this.getHpText().setText(String.valueOf(hp));

        if (hp <= 0) {
            Text GameOver = this.createText("GAME OVER", 1000, 600);
            this.getPane().getChildren().add(GameOver);
            return false;
        }
        return true;
    }
}