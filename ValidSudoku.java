import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] columnSet = new HashSet[9];
        Set<Character> boxSet = new HashSet<>();

        for (int i=0; i<9; i++)  {
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
        }

        int i=0, j=0, rowLimit = 3, columnLimit = 3;
        while (true)    {
            int rowIndex = i;
            int columnIndex=j;
            boxSet = new HashSet<>();

            for (; rowIndex < rowLimit; rowIndex++) {
                columnIndex = j;
                for (; columnIndex < columnLimit; columnIndex++)  {
                    char ch = board[rowIndex][columnIndex];
                    if (ch == '.')
                        continue;

                    if (boxSet.contains(ch))
                        return false;
                    else
                        boxSet.add(ch);

                    if (rowSet[rowIndex].contains(ch))
                        return false;
                    else
                        rowSet[rowIndex].add(board[rowIndex][columnIndex]);

                    if (columnSet[columnIndex].contains(ch))
                        return false;
                    else
                        columnSet[columnIndex].add(ch);
                }
            }
            if (rowIndex == 3 || rowIndex == 6 || rowIndex == 9)    {
                if (rowIndex == 9 && columnIndex == 9)
                    break;

                if (columnIndex == 3 || columnIndex == 6) {
                    j += 3;
                    columnLimit += 3;
                }
                else if (columnIndex == 9)   {
                    i += 3;
                    rowLimit += 3;
                    j = 0;
                    columnLimit = 3;
                }
            }
        }
        return true;
    }
}

/* 1ms runtime :
class Solution {
    public boolean isValidSudoku(char[][] board) {

        int N=9;
        int[] rows=new int[9];
        int[] cols=new int[9];
        int[] boxes=new int[9];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){

                if(board[i][j]=='.'){
                    continue;
                }

                int temp=board[i][j]-'0';
                if( (rows[i] & (1<<temp))!=0 ){
                    return false;
                }
                rows[i]=rows[i] | (1<<temp);

                if( (cols[j] & (1<<temp)) != 0 ){
                    return false;
                }
                cols[j]=cols[j] | (1<<temp);

                int idx=(i/3)*3+j/3;
                if( (boxes[idx] & (1<<temp)) != 0 ){
                    return false;
                }
                boxes[idx]=boxes[idx] | (1<<temp);
            }
        }

        return true;
    }
}


######### 2ms runtime :

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rows = new HashSet<>();
        HashSet<Character> cols = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // row
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j]))
                        return false;
                    else
                        rows.add(board[i][j]);
                }

                // col
                if (board[j][i] != '.') {
                    if (cols.contains(board[j][i]))
                        return false;
                    else
                        cols.add(board[j][i]);
                }
            }
            rows = new HashSet<>();
            cols = new HashSet<>();
        }

        // block
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkBlock(i, j, board))
                    return false;
            }
        }

        return true;
    }

    private boolean checkBlock(int idxI, int idxJ, char[][] board) {
        HashSet<Character> box = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;

        for (int i = idxI; i < rows; i++) {
            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.')
                    continue;
                if (box.contains(board[i][j]))
                    return false;
                box.add(board[i][j]);
            }
        }
        return true;
    }
}

 */
