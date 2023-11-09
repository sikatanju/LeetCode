public class MinimumPathSum {
    public int minPathSum(int[][] grid)    {
        int rowLen = grid.length, columnLen = grid[0].length;

        for (int i=1; i<rowLen; i++)
            grid[i][0] += grid[i-1][0];

        for (int j=1; j<columnLen; j++)
            grid[0][j] += grid[0][j-1];

        for (int i=1; i<rowLen; i++)    {
            for (int j=1; j<columnLen; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }

        return grid[rowLen-1][columnLen-1];
    }
}

/* 0ms runtime solution...

class Solution {
    int[][] mm;
    int[][] cost;
    public int minPathSum(int[][] grid) {
        int m = grid[0].length, n = grid.length;
        this.mm = new int[m][n];
        this.cost = grid;
        return dp(m-1, n-1);
    }
    public int dp(int x, int y) {
        if (x==0 && y ==0) return cost[0][0];

        if (mm[x][y] != 0) return mm[x][y];

        if (x == 0) mm[x][y] = dp(x,y-1) + cost[y][x];
        else if (y == 0) mm[x][y] = dp(x-1,y) + cost[y][x];
        else mm[x][y] = Math.min(dp(x-1,y), dp(x,y-1)) + cost[y][x];
        return mm[x][y];
    }
}

 */