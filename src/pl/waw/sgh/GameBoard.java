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
    private static int i, j; //iterators
    private static Player player = null;
    static GameButton[][] gameBoard;
    private static int maxMoves;

    public static void main(int boardSize) {
        size = boardSize;
        board = createBoard(size);
        maxMoves = size * size;

        JFrame frame = new JFrame();
        frame.setTitle("Tic tac toe");

        frame.setMinimumSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LayoutManager layoutManager = new GridLayout(3, 0);
        frame.setLayout(layoutManager);


        JPanel topPanel = new JPanel();
        JLabel movesPlayer = new JLabel("Moves player:");
        JLabel whichPlayer = new JLabel();
        whichPlayer.setEnabled(false);

        topPanel.add(movesPlayer);
        topPanel.add(whichPlayer);


        if (GameOptionsUI.getPlayer1().getCounter() == 'O') {
            whichPlayer.setText(GameOptionsUI.getPlayer1().getName());
            player = GameOptionsUI.getPlayer1();
        } else {
            whichPlayer.setText(GameOptionsUI.getPlayer2().getName());
            player = GameOptionsUI.getPlayer2();
        }

        // -- ACTUAL GAMEBOARD --
        JPanel gameBoardPanel = new JPanel();
        LayoutManager gameLayoutManager = new GridLayout(boardSize, boardSize);
        gameBoardPanel.setLayout(gameLayoutManager);
        gameBoard = new GameButton[boardSize][boardSize];
        for (i=0; i<boardSize; i++)
            for (j=0; j<boardSize; j++){
                gameBoard[i][j] = new GameButton();                             //gameboard full of "." marks
                gameBoard[i][j].setCounter('.');
                gameBoard[i][j].setText(".");
                gameBoardPanel.add(gameBoard[i][j]);

                //WRÓCIĆ DO TEGO
                /*gameBoard[i][j].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                                                                                // win conditions check

                        gameBoard[k][l].setText(String.valueOf(player.getCounter()));
                        gameBoard[k][l].setEnabled(false);

                        if (GameBoard.winConditions(player, maxMoves, i, j) == -1)
                            JOptionPane.showMessageDialog(frame, "Draw", "Draw", JOptionPane.INFORMATION_MESSAGE);
                        else if (GameBoard.winConditions(player, maxMoves, i, j) == 1)
                            JOptionPane.showMessageDialog(frame, player.getName() + " wins!", "End", JOptionPane.INFORMATION_MESSAGE);

                        if (player == GameOptionsUI.getPlayer1())
                            player = GameOptionsUI.getPlayer2();
                        else
                            player = GameOptionsUI.getPlayer1();
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
                });*/
            }

        gameBoard[0][0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[0][0].setText(String.valueOf(player.getCounter()));
                gameBoard[0][0].setCounter(player.getCounter());
                gameBoard[0][0].setEnabled(false);

                checkState(frame, player, maxMoves, 0, 0);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[0][1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[0][1].setText(String.valueOf(player.getCounter()));
                gameBoard[0][1].setCounter(player.getCounter());
                gameBoard[0][1].setEnabled(false);

                checkState(frame, player, maxMoves, 0, 1);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[0][2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[0][2].setText(String.valueOf(player.getCounter()));
                gameBoard[0][2].setCounter(player.getCounter());
                gameBoard[0][2].setEnabled(false);

                checkState(frame, player, maxMoves, 0, 2);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[1][0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[1][0].setText(String.valueOf(player.getCounter()));
                gameBoard[1][0].setCounter(player.getCounter());
                gameBoard[1][0].setEnabled(false);

                checkState(frame, player, maxMoves, 1, 0);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[1][1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[1][1].setText(String.valueOf(player.getCounter()));
                gameBoard[1][1].setCounter(player.getCounter());
                gameBoard[1][1].setEnabled(false);

                checkState(frame, player, maxMoves, 1, 1);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[1][2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[1][2].setText(String.valueOf(player.getCounter()));
                gameBoard[1][2].setCounter(player.getCounter());
                gameBoard[1][2].setEnabled(false);

                checkState(frame, player, maxMoves, 1, 2);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[2][0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[2][0].setText(String.valueOf(player.getCounter()));
                gameBoard[2][0].setCounter(player.getCounter());
                gameBoard[2][0].setEnabled(false);

                checkState(frame, player, maxMoves, 2, 0);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[2][1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[2][1].setText(String.valueOf(player.getCounter()));
                gameBoard[2][1].setCounter(player.getCounter());
                gameBoard[2][1].setEnabled(false);

                checkState(frame, player, maxMoves, 2, 1);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });
        gameBoard[2][2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {                    //mouse click results in change of the button text +
                // win conditions check

                gameBoard[2][2].setText(String.valueOf(player.getCounter()));
                gameBoard[2][2].setCounter(player.getCounter());
                gameBoard[2][2].setEnabled(false);

                checkState(frame, player, maxMoves, 2, 2);
                maxMoves--;

                if (player == GameOptionsUI.getPlayer1())
                    player = GameOptionsUI.getPlayer2();
                else
                    player = GameOptionsUI.getPlayer1();
                whichPlayer.setText(player.getName());

                if (player.isAi()){
                    player.artInt(player, gameBoard, frame, maxMoves);
                    maxMoves--;
                    if (player == GameOptionsUI.getPlayer1())
                        player = GameOptionsUI.getPlayer2();
                    else
                        player = GameOptionsUI.getPlayer1();
                }
                whichPlayer.setText(player.getName());
            }
            @Override
            public void mousePressed(MouseEvent e) {            }
            @Override
            public void mouseReleased(MouseEvent e) {            }
            @Override
            public void mouseEntered(MouseEvent e) {            }
            @Override
            public void mouseExited(MouseEvent e) {            }
        });


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




        //Computer's move in case it begins

        if (player.isAi()) {
            player.artInt(player, gameBoard, frame, maxMoves);
            maxMoves--;
            if (player == GameOptionsUI.getPlayer1())
                player = GameOptionsUI.getPlayer2();
            else
                player = GameOptionsUI.getPlayer1();
            whichPlayer.setText(player.getName());
        }

    }

    private static int[][] createBoard(int size) {
        return new int[size][size];
    }

    static void checkState(JFrame frame, Player player, int maxMoves, int i, int j){
        if (GameBoard.winConditions(player, maxMoves, i, j) == -1) {
            JOptionPane.showMessageDialog(frame, "Draw", "Draw", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            BoardSizeUI.frame.setVisible(true);
        }
        else if (GameBoard.winConditions(player, maxMoves, i, j) == 1) {
            JOptionPane.showMessageDialog(frame, player.getName() + " wins!", "End", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            BoardSizeUI.frame.setVisible(true);
        }
    }

    private static int winConditions(Player player, int moves, int x, int y) {
        if (size==3) {
            if (result3(x, y, player.getCounter()) == 1)
                return 1; //player wins
            else if (moves==0)
                return -1; //game over, draw
            else
                return 0; //keeps playing
        } else{
            if (result5(x, y, player.getCounter()) == 1)
                return 1; //player wins
            else if (moves==0)
                return -1; //game over, draw
            else
                return 0; //keeps playing
        }

    }

    private static int result3(int x, int y, char counter) {  //4 bloki sprawdzające pion, poziom, dwa skosy
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
    /// DO OPRACOWANIA!!!
    private static int result5(int x, int y, char counter) {  //4 bloki sprawdzające pion, poziom, dwa skosy
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


    private static int res(int dx, int dy, char counter) {
        if (dx >= size  || dy >= size  || dx < 0 || dy < 0) {
            return 0;
        } else if (gameBoard[dx][dy].getCounter() == counter) {
            return 1;
        } else return 0;
    }


}
