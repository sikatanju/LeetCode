import java.util.Arrays;

public class GameOfLife {
    private int boardRow;
    private int boardColumn;

    public void gameOfLife(int[][] board)   {
        this.boardRow = board.length;
        this.boardColumn = board[0].length;

        int[][] returnAra = new int[boardRow][boardColumn];

        for (int i=0; i<boardRow; i++)   {
            for (int j=0; j<boardColumn; j++)    {
                updateCell(board, returnAra, i, j);
            }
        }
        for (int i=0; i<boardRow; i++)   {
            for (int j=0; j<boardColumn; j++)    {
                board[i][j] = returnAra[i][j];
            }
        }
    }

    private void updateCell(int[][] givenAra, int[][] returnAra, int row, int column) {
        int count = countLiveNeighbour(givenAra, row, column);

        if (givenAra[row][column] == 0) {
            if (count == 3)
                returnAra[row][column] = 1;
        }
        else {
            if (count > 1 && count < 4)
                returnAra[row][column] = 1;

            if (count > 3)
                returnAra[row][column] = 0;
        }
    }

    private int countLiveNeighbour(int[][] givenAra, int row, int column) {
        int count = 0;
        if (givenAra[row][column] == 1)
            count = -1;

        for (int i=row-1; i<=row+1; i++)    {
            if (i == -1)
                i = 0;
            if (i == boardRow)
                break;

            for (int j=column-1; j<=column+1; j++)   {
                if (j == -1)
                    j = 0;
                if (j == boardColumn)
                    continue;

                if (givenAra[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
}


/*

    private int boardRow;
    private int boardColumn;

    public void gameOfLife(int[][] board)   {
        this.boardRow = board.length;
        this.boardColumn = board[0].length;

        int[][] returnAra = new int[boardRow][boardColumn];

        for (int i=0; i<boardRow; i++)   {
            for (int j=0; j<boardColumn; j++)    {
                updateCell(board, returnAra, i, j);
            }
        }

    }

    private void updateCell(int[][] givenAra, int[][] returnAra, int row, int column) {
        int count = countLiveNeighbour(givenAra, row, column);

        if (givenAra[row][column] == 0) {
            if (count == 3)
                returnAra[row][column] = 1;
        }
        else {
            if (count > 1 && count < 4)
                returnAra[row][column] = 1;

            if (count > 3)
                returnAra[row][column] = 0;
        }
    }

    private int countLiveNeighbour(int[][] givenAra, int row, int column) {
        int count = 0;
        if (givenAra[row][column] == 1)
             count = -1;

        for (int i=row-1; i<=row+1; i++)    {
            if (i == -1)
                i = 0;
            if (i == boardRow)
                break;

            for (int j=column-1; j<=column+1; j++)   {
                if (j == -1)
                    j = 0;
                if (j == boardColumn)
                    continue;

                if (givenAra[i][j] == 1)
                    count++;
            }
        }
        return count;
    }
 */