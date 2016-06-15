package pl.waw.sgh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
    private static Player player1, player2;
    private static GameOptionsUI gameOptionsUI = null;

    public static void main(boolean diff) {
        gameOptionsUI = new GameOptionsUI();
        frame.setContentPane(gameOptionsUI.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


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

                // --begin-- //Players
                Random rand = new Random();
                char counter1, counter2;
                if (rand.nextInt(2) == 1) {
                    counter1 = 'O';
                    counter2 = 'X';
                } else {
                    counter1 = 'X';
                    counter2 = 'O';
                }
                player1 = new Player(gameOptionsUI.getPlayer1Name().getText(), false, counter1);
                player2 = null;
                if (gameOptionsUI.getAiCheckBox().isSelected())
                    player2 = new Player("Computer", true, counter2);
                else
                    player2 = new Player(gameOptionsUI.getPlayer2Name().getText(), false, counter2);
                // --end--

                frame.setVisible(false);

                if (diff)
                    GameBoard.main(3);
                else
                    GameBoard.main(5);
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

        // --begin-- // no player2 name if AI selected
        ItemListener itemListener = new ItemListener()
        {
            public void itemStateChanged(ItemEvent ie)
            {
                gameOptionsUI.getPlayer2Name().setEnabled(ie.getStateChange() == ItemEvent.DESELECTED);
            }
        };
        gameOptionsUI.getAiCheckBox().addItemListener(itemListener);
        // --end--




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

    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static GameOptionsUI getGameOptionsUI() {
        return gameOptionsUI;
    }

    public static void setGameOptionsUI(GameOptionsUI gameOptionsUI) {
        GameOptionsUI.gameOptionsUI = gameOptionsUI;
    }
}
