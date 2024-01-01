public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        int[][] dp = new int[rows][columns];

        for (int i=0; i<rows; i++)    {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;
        }
        for (int j=0; j<columns; j++) {
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = 1;
            else
                break;
        }

        for (int i=1; i<rows; i++)    {
            for (int j=1; j<columns; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[rows-1][columns-1];
    }
}


/* ######### Best Memory Solution :
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1) return 0;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) dp[i][0] = 1;
            else break;
        }

        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        for (int i= 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if ( obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}



 ######### My 1ms runtime :

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int rowLen = obstacleGrid.length, columnLen = obstacleGrid[0].length;
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (obstacleGrid[i][j] == 1) {
                    if (i != 0 && j != 0)
                        obstacleGrid[i][j] = -1;
                    else {
                        if (rowLen == 1)    {
                            int tempJ = j;
                            while (tempJ < columnLen)
                                obstacleGrid[i][tempJ++] = -1;
                        }
                        else if (columnLen == 1)    {
                            int tempI = i;
                            while (tempI < rowLen)
                                obstacleGrid[tempI++][j] = -1;
                        }
                        else if (i == 0) {
                            int tempJ = j;
                            while (tempJ < columnLen)
                                obstacleGrid[i][tempJ++] = -1;
                        }
                        else {
                            int tempI = i;
                            while (tempI < rowLen)
                                obstacleGrid[tempI++][j] = -1;
                        }
                    }
                }
            }
        }
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (i==0 || j == 0) {
                    if (obstacleGrid[i][j] != -1)
                        obstacleGrid[i][j] = 1;
                }
                else {
                    if (obstacleGrid[i][j] == -1)
                        continue;

                    if (obstacleGrid[i][j-1] != -1 && obstacleGrid[i-1][j] != -1)
                        obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];

                    else if (obstacleGrid[i][j-1] == -1 && obstacleGrid[i-1][j] == -1)
                        continue;
                    else {
                        if (obstacleGrid[i][j-1] == -1)
                            obstacleGrid[i][j] = obstacleGrid[i-1][j];
                        else
                            obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    }
                }
            }
        }
        return obstacleGrid[rowLen-1][columnLen-1] == -1 ? 0: obstacleGrid[rowLen-1][columnLen-1];
    }



##########################



###########   My 4ms runtime :

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i=0; i<obstacleGrid.length; i++)   {
            for (int j=0; j<obstacleGrid[0].length; j++)    {
                if (obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = -1;
            }
        }
        return uniquePathsWithObstacles(0, 0, obstacleGrid.length, obstacleGrid[0].length, obstacleGrid);
    }

    private int uniquePathsWithObstacles(int row, int column, int rows, int columns, int[][] obstacleGrid) {
        if (row == rows || column == columns)
            return 0;
        if (obstacleGrid[row][column] == -1)
            return 0;
        if (obstacleGrid[row][column] > 0)
            return obstacleGrid[row][column];
        if (row == rows-1 && column == columns-1)
            return 1;

        obstacleGrid[row][column] = (uniquePathsWithObstacles(row+1, column, rows, columns, obstacleGrid) + uniquePathsWithObstacles(row, column+1, rows, columns, obstacleGrid));
        return obstacleGrid[row][column];
    }

*/