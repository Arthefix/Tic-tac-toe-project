package pl.waw.sgh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by harib on 06.06.2016.
 */
public class GameOptionsUI {
    private JPanel panel1;
    private JTextField boardSizeTextField;
    private JCheckBox aiCheckBox;
    private JButton backButton;
    private JButton playButton;
    private JButton exitButton;
    private JTextField player1Name;
    private JTextField player2Name;
    public static JFrame frame = new JFrame("Game options");

    public static void main(boolean diff) {
        GameOptionsUI gameOptionsUI = new GameOptionsUI();
        frame.setContentPane(gameOptionsUI.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        // --begin--
        //Players
        Random rand = new Random();
        char counter1, counter2;
        if (rand.nextInt(1) == 0) {
            counter1 = 'O';
            counter2 = 'X';
        } else {
            counter1 = 'X';
            counter2 = 'O';
        }
        Player player1 = new Player(gameOptionsUI.getPlayer1Name().toString(), false, counter1);
        Player player2 = null;
        if (gameOptionsUI.getAiCheckBox().isSelected())
            player2 = new Player("Computer", true, counter2);
        else
            player2 = new Player(gameOptionsUI.getPlayer2Name().toString(), false, counter2);
        //Players
        // --end--



        gameOptionsUI.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                BoardSizeUI.frame.setVisible(true);
            }
        });
        gameOptionsUI.getPlayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });
        gameOptionsUI.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        if (diff) gameOptionsUI.getBoardSizeTextField().setText("3x3");
        else gameOptionsUI.getBoardSizeTextField().setText("5x5");




    }

    public JCheckBox getAiCheckBox() {
        return aiCheckBox;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getPlayButton() {
        return playButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JTextField getPlayer1Name() {
        return player1Name;
    }

    public JTextField getPlayer2Name() {
        return player2Name;
    }

    public JTextField getBoardSizeTextField() {
        return boardSizeTextField;
    }

}
