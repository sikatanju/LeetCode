public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int rowLen = matrix.length, columnLen = matrix[0].length;
        int maxSquare = Integer.MIN_VALUE;
        if (rowLen == 1 && columnLen == 1)
            return matrix[0][0] == '1' ? 1: 0;

        int rowIndex = rowLen-1, columnIndex = columnLen-1;
        int[][] cache = new int[rowLen][columnLen];

        for (int i=rowLen-1; i>=0; i--) {
            if (matrix[i][columnLen-1] == '1')  {
                cache[i][columnLen-1] = 1;
                maxSquare = 1;
            }
        }
        for (int i=columnLen-1; i>=0; i--)  {
            if (matrix[rowLen-1][i] == '1') {
                cache[rowLen-1][i] = 1;
                maxSquare = 1;
            }
        }

        for (int i=rowLen-2; i>=0; i--) {
            int tempColumnIndex = --columnIndex;
            int tempRowIndex = --rowIndex;

            while (tempColumnIndex >= 0 && tempRowIndex >= 0)    {
                if (matrix[tempRowIndex][tempColumnIndex] == '0')
                    cache[tempRowIndex][tempColumnIndex] = 0;
                else if (matrix[tempRowIndex][tempColumnIndex] == '1')    {
                    cache[tempRowIndex][tempColumnIndex] = 1;
                    maxSquare = Math.max(maxSquare, 1);
                }

                if (matrix[tempRowIndex][tempColumnIndex] != '0' && (tempColumnIndex+1) < columnLen && (tempRowIndex+1) < rowLen
                        && matrix[tempRowIndex+1][tempColumnIndex] == '1'
                        && matrix[tempRowIndex][tempColumnIndex+1] == '1'
                        && matrix[tempRowIndex+1][tempColumnIndex+1] == '1')  {

                    int right = cache[tempRowIndex][tempColumnIndex+1], bottom = cache[tempRowIndex+1][tempColumnIndex],
                            diagonal = cache[tempRowIndex+1][tempColumnIndex+1];

                    int min = Math.min(right, bottom);
                    min = Math.min(min, diagonal);

                    cache[tempRowIndex][tempColumnIndex] = 1+min;
                    maxSquare = Math.max(maxSquare, cache[tempRowIndex][tempColumnIndex]);
                }
                tempColumnIndex--;
            }

            tempRowIndex--;
            tempColumnIndex = columnIndex;

            while (tempRowIndex >= 0 && tempColumnIndex >= 0)    {
                if (matrix[tempRowIndex][tempColumnIndex] == '0')
                    cache[tempRowIndex][tempColumnIndex] = 0;
                else if (matrix[tempRowIndex][tempColumnIndex] == '1')    {
                    cache[tempRowIndex][tempColumnIndex] = 1;
                    maxSquare = Math.max(maxSquare, 1);
                }

                if (matrix[tempRowIndex][tempColumnIndex] != '0' && (tempColumnIndex+1) < columnLen && (tempRowIndex+1) < rowLen
                        && matrix[tempRowIndex+1][tempColumnIndex] == '1'
                        && matrix[tempRowIndex][tempColumnIndex+1] == '1'
                        && matrix[tempRowIndex+1][tempColumnIndex+1] == '1')   {


                    int right = cache[tempRowIndex][tempColumnIndex+1], bottom = cache[tempRowIndex+1][tempColumnIndex],
                            diagonal = cache[tempRowIndex+1][tempColumnIndex+1];

                    int min = Math.min(right, bottom);
                    min = Math.min(min, diagonal);

                    cache[tempRowIndex][tempColumnIndex] = 1+min;
                    maxSquare = Math.max(maxSquare, cache[tempRowIndex][tempColumnIndex]);
                }
                tempRowIndex--;
            }
        }
        return maxSquare*maxSquare;
    }
}


/* Best runtime 6ms: // Mine was: 12ms
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++){
            for (int j = 0; j <= n; j++){

                dp[i][j] = 0;

            }
        }
        int maxv =0;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '1'){

                    int minv = Math.min(dp[i][j],dp[i][j+1] );
                    minv = Math.min(minv,dp[i+1][j] );
                    dp[i+1][j+1] = minv + 1;
                    maxv = Math.max(maxv,dp[i+1][j+1] );
                }
            }
        }
        return maxv*maxv;
    }
}
 */