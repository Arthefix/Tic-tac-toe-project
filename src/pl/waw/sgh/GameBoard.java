package pl.waw.sgh;

/**
 * Created by harib on 07.06.2016.
 */
public class GameBoard {

    private int[][] board;
    private int size;

    public void main(int boardSize) {
        size = boardSize;
        board = createBoard(size);
        int maxMoves = size * size;

    }

    private int[][] createBoard(int size) {
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
