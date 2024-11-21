public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int max = 0, dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for (int i=2; i<=n; i++)    {
            int sum = 0;
            for (int j=1; j<=i; j++)    {
                int left = j-1;
                int right = i-j;
                sum += dp[left]*dp[right];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
