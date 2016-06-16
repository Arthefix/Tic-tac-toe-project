package pl.waw.sgh;

import javax.swing.*;
import java.util.Random;

/**
 * Created by harib on 06.06.2016.
 */
public class Player {
    private String name;
    private boolean ai;
    private char counter;

    public Player(String name, boolean ai, char counter) {
        this.name = name;
        this.ai = ai;
        this.counter = counter;
    }

    public void artInt(Player player, GameButton[][] board, JFrame frame, int maxMoves){
        Random rand_x = new Random();
        Random rand_y = new Random();
        int x = rand_x.nextInt(3);
        int y = rand_y.nextInt(3);

        while (board[x][y].getCounter() != '.'){
            x = rand_x.nextInt(3);
            y = rand_y.nextInt(3);
        }
        board[x][y].setCounter(player.getCounter());
        board[x][y].setText(String.valueOf(player.getCounter()));
        GameBoard.checkState(frame, player, maxMoves, x, y);

    }

    public String getName() {
        return name;
    }

    public boolean isAi() {
        return ai;
    }

    public char getCounter() {
        return counter;
    }
}
