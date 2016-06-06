package pl.waw.sgh;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by harib on 06.06.2016.
 */
public class BoardSizeUI {
    private JButton normalButton;
    private JPanel panel1;
    private JButton advancedButton;
    private JButton exitButton;
    public static JFrame frame = new JFrame("Difficulty");
    private boolean difficultyNormal;

    public static void main() {
        BoardSizeUI boardSizeUI = new BoardSizeUI();
        frame.setContentPane(boardSizeUI.panel1);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        boardSizeUI.getNormalButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GameOptionsUI.main(true);
            }
        });
        boardSizeUI.getAdvancedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GameOptionsUI.main(false);
            }
        });
        boardSizeUI.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JButton getNormalButton() {
        return normalButton;
    }

    public JButton getAdvancedButton() {
        return advancedButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public boolean isDifficultyNormal() {
        return difficultyNormal;
    }

    public void setDifficultyNormal(boolean difficultyNormal) {
        this.difficultyNormal = difficultyNormal;
    }
}
