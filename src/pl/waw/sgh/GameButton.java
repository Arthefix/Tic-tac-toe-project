package pl.waw.sgh;

import javax.swing.*;

/**
 * Created by harib on 13.06.2016.
 */
public class GameButton extends JButton {

    private int dx;
    private int dy;
    private char counter;

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public char getCounter() {
        return counter;
    }

    public void setCounter(char counter) {
        this.counter = counter;
    }
}
