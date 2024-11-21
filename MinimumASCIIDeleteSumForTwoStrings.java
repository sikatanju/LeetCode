public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int rowLen = s1.length(), columnLen = s2.length();
        int[][] dp = new int[rowLen+1][columnLen+1];
        char[] rows = s1.toCharArray(), columns = s2.toCharArray();

        for (int i=1; i<=columnLen; i++)
            dp[0][i] = dp[0][i-1] + (int)columns[i-1];
        for (int i=1; i<=rowLen; i++)
            dp[i][0] = dp[i-1][0] + (int)rows[i-1];

        for (int i=1; i<=rowLen; i++)    {
            for (int j=1; j<=columnLen; j++) {
                if (rows[i-1] == columns[j-1])
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j] + rows[i-1], dp[i][j-1] + columns[j-1]);
            }
        }

        return dp[rowLen][columnLen];
    }
}
