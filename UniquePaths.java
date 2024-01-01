public class UniquePaths {
    public int uniquePaths(int rows, int columns) {
        int[] prevRow = new int[columns];
        for (int i=rows-1; i>=0; i--)   {
            int[] currentRow = new int[columns];
            currentRow[columns-1] = 1;
            for (int j=columns-2; j>=0; j--)
                currentRow[j] = currentRow[j+1] + prevRow[j];

            prevRow = currentRow;
        }
        return prevRow[0];
    }
}

// Best Memory :
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] p = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0) {
                    p[i][j] = 1;
                }
                else {
                    p[i][j] = p[i][j-1] + p[i-1][j];
                }
            }
        }
        return p[m-1][n-1];
    }
}
*/


// Brute Force Solution :
/*
class Solution {
    public int uniquePaths(int m, int n) {
        return numOfUniquePaths(0, 0, m, n);
    }
    private int numOfUniquePaths(int row, int column, int rows, int columns)   {
        if (row == rows || columns == column)
            return 0;
        if (row == rows-1 && column == columns-1)
            return 1;

        return numOfUniquePaths(row+1, column, rows, columns) + numOfUniquePaths(row, column+1, rows, columns);
    }
}
 */
