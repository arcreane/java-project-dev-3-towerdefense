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
    private int money;
    private String pseudo;
    private BorderPane pane;
    private Text hpText;
    private Text pseudoText;

    /**
     * Default constructor
     *
     * @param pane   PlayerScreen
     * @param hp     player hp
     * @param pseudo player username
     */
    public User(BorderPane pane, int hp, String pseudo) {
        this.setPane(pane);
        this.setHp(hp);
        this.setPseudo(pseudo);
        this.createUserInterface(pane, hp, pseudo);
    }

    /**
     * @return player current hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp set player hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return player current pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo set player pseudo
     */
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
     * @return BorderPane
     */
    public BorderPane getPane() {
        return pane;
    }

    /**
     * @param pane set the screen play
     */
    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    /**
     * @return int current player's money
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
     * @return Text current player's name
     */
    public Text getPseudoText() {
        return pseudoText;
    }

    /**
     * @param pseudoText Text set player's pseudo Text
     */
    public void setPseudoText(Text pseudoText) {
        this.pseudoText = pseudoText;
    }

    /**
     * @return Text current player's hp text
     */
    public Text getHpText() {
        return hpText;
    }

    /**
     * @param hpText Text of hp player
     */
    public void setHpText(Text hpText) {
        this.hpText = hpText;
    }

    /**
     * @param dmg Amount of dmg that the player receives
     * @return boolean if the player's hp fall to 0 or lower
     */
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