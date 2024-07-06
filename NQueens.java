import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    private List<List<String>> res;
    private char[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for (var temp: board)   {
            Arrays.fill(temp, '.');
        }

        Set<Integer> set = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        backtrack(0, n, set, posDiag, negDiag);
        return res;
    }

    private void backtrack(int row, int n, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag)  {
        if (row == n)   {
            List<String> result = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (var temp: board)   {
                for (var ch: temp)  {
                    stringBuilder.append(ch);
                }
                result.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            this.res.add(result);
            return;
        }

        for (int c=0; c<n; c++) {
            if (col.contains(c) || posDiag.contains(row+c) || negDiag.contains(row-c))
                continue;

            col.add(c);
            posDiag.add(row+c);
            negDiag.add(row-c);

            this.board[row][c]= 'Q';
            backtrack(row+1, n, col, posDiag, negDiag);

            col.remove(c);
            posDiag.remove(row+c);
            negDiag.remove(row-c);
            this.board[row][c] = '.';
        }
    }
}


/* ### 1ms solution :

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        return new AbstractList<List<String>>(){
            private List<List<String>> result;
            @Override
            public int size() {
                if(result==null){
                    init();
                }
                return result.size();
            }

            @Override
            public List<String> get(int index) {
                if(result == null){
                    init();
                }
                return result.get(index);
            }

            public void init(){
                result = new ArrayList<>();
                char[][] chess = new char[n][n];
                solveUtil(chess, n);
            }

            public void solveUtil(char[][] chess, int qCount){
                if(qCount == 0){
                    List<String> temp = new ArrayList<>();
                    for(int i = 0; i < n; i++){
                        StringBuffer sb = new StringBuffer();
                        for(char c: chess[i]){
                            if(c != 'Q')c = '.';
                            sb.append(c);
                        }
                        temp.add(sb.toString());
                    }
                    result.add(temp);
                    return;
                }


                int j = qCount - 1;
                for(int i=0; i<n; i++){
                    if(chess[i][j] != 'Q' && isRowSafe(chess, i, j) && isColumnSafe(chess, i, j) && isDiagonalSafe(chess, i, j)){
                        chess[i][j] = 'Q';
                        solveUtil(chess, qCount - 1);
                        chess[i][j] = '.';
                    }
                }
            }

            private boolean isDiagonalSafe(char[][] chess, int i, int j) {
                int row, col;
                // top left diagonal
                row = i-1; col = j-1;
                while(row >= 0 && col >= 0){
                    if(chess[row--][col--] == 'Q')return false;
                }

                // top right diagonal
                row = i-1; col = j+1;
                while(row >= 0 && col < n){
                    if(chess[row--][col++] == 'Q')return false;
                }
                // bottom left diagonal
                row = i+1; col = j-1;
                while(row < n && col >= 0){
                    if(chess[row++][col--] == 'Q')return false;
                }

                // bottom right diagonal
                row = i+1; col = j+1;
                while(row < n && col < n){
                    if(chess[row++][col++] == 'Q')return false;
                }

                return true;
            }

            private boolean isColumnSafe(char[][] chess, int i, int j) {
                for(int row=0; row < n; row++){
                    if(chess[row][j] == 'Q')return false;
                }
                return true;
            }

            private boolean isRowSafe(char[][] chess, int i, int j) {
                for(int col=0; col < n; col++){
                    if(chess[i][col] == 'Q')return false;
                }
                return true;
            }

        };
    }
}
*/