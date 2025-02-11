public class MaximumAmountOfMoneyRobotCanEarn {
    private int row, column;
    public int maximumAmount(int[][] coins) {
        row = coins.length;
        column = coins[0].length;
        Integer[][][] dp = new Integer[row][column][3];
        return dfs(0, 0, 0, coins, dp);
    }
    private int dfs(int i, int j, int k, int[][] coins, Integer[][][] dp)   {
        if (i == row || j == column)
            return Integer.MIN_VALUE;

        if (i == row-1 && j == column-1)    {
            if (coins[i][j] < 0 && k < 2)
                return 0;
            return coins[i][j];
        }
        if (dp[i][j][k] != null)
            return dp[i][j][k];

        int right = dfs(i, j+1, k, coins, dp);
        int down = dfs(i+1, j, k, coins, dp);
        int takeCoin = coins[i][j] + Math.max(right, down);

        int notCoin = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && k < 2)   {
            notCoin = Math.max(dfs(i+1, j, k+1, coins, dp), dfs(i, j+1, k+1, coins, dp));
        }
        return dp[i][j][k] = Math.max(takeCoin, notCoin);
    }
}
