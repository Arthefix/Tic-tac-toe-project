package pl.waw.sgh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by harib on 07.06.2016.
 */
public class GameBoard {

    private static int[][] board;
    private static int size;

    public static void main(int boardSize) {
        size = boardSize;
        board = createBoard(size);
        int maxMoves = size * size;

        JFrame frame = new JFrame();
        frame.setTitle("Tic tac toe");

        frame.setMinimumSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayoutManager layoutManager = new GridLayout(3, 0);
        frame.setLayout(layoutManager);


        JPanel topPanel = new JPanel();
        JLabel movesPlayer = new JLabel("Moves player:");
        JTextField whichPlayer = new JTextField();
        whichPlayer.setEnabled(false);

        topPanel.add(movesPlayer);
        topPanel.add(whichPlayer);


        // -- ACTUAL GAMEBOARD --
        JPanel gameBoardPanel = new JPanel();
        LayoutManager gameLayoutManager = new GridLayout(3, 3);
        gameBoardPanel.setLayout(gameLayoutManager);
        GameButton[][] gameBoard = new GameButton[3][3];
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++){
                gameBoard[i][j] = new GameButton();                             //gameboard 3x3 full of "." marks
                gameBoard[i][j].setCounter('.');
                gameBoard[i][j].setText(".");
                gameBoardPanel.add(gameBoard[i][j]);

                gameBoard[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                                                                                // win conditions check

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
            }



        JPanel bottomPanel = new JPanel();
        JButton backButton = new JButton("Back");
        JButton exitButton = new JButton("Exit");

        bottomPanel.add(backButton);
        bottomPanel.add(exitButton);



        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GameOptionsUI.frame.setVisible(true);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        frame.getContentPane().add(topPanel);
        frame.getContentPane().add(gameBoardPanel);
        frame.getContentPane().add(bottomPanel);

        frame.setVisible(true);
    }

    private static int[][] createBoard(int size) {
        return new int[size][size];
    }

    private int winConditions(Player player, int moves, int x, int y) {
        if (result(x, y, player.getCounter()) == 1)
            return 1; //player wins
        else if (moves==0)
            return -1; //koniec gry, remis
        else
            return 0; //gramy dalej

    }

    int result(int x, int y, char counter) {  //4 bloki sprawdzające pion, poziom, dwa skosy
        int w = 0;
        {        //pion
            w = res(x, y - 2, counter) + res(x, y - 1, counter) + res(x, y + 1, counter) + res(x, y + 2, counter);
            if (w >= 2) return 1;
        }
        {        //poziom
            w = res(x - 2, y, counter) + res(x - 1, y, counter) + res(x + 1, y, counter) + res(x + 2, y, counter);
            if (w >= 2) return 1;
        }
        {        //skos w prawo
            w = res(x - 2, y - 2, counter) + res(x - 1, y - 1, counter) + res(x + 1, y + 1, counter) + res(x + 2, y + 2, counter);
            if (w >= 2) return 1;
        }
        {        //skos w lewo
            w = res(x + 2, y - 2, counter) + res(x + 1, y - 1, counter) + res(x - 1, y + 1, counter) + res(x - 2, y + 2, counter);
            if (w >= 2) return 1;
        }
        return 0;
    }


    int res(int dx, int dy, char counter) {
        if (dx >= size - 1 || dy >= size - 1 || dx < 0 || dy < 0) {
            return 0;
        } else if (board[dx][dy] == counter) {
            return 1;
        } else return 0;
    }


}
