public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        var temp = new int[len+2];
        for (int i=1; i<=len; i++)
            temp[i] = nums[i-1];

        temp[0] = temp[len+1] = 1;
        Integer[][] dp = new Integer[len+2][len+2];
        return dfs(1, temp.length-2, temp, dp);
    }
    private int dfs(int low, int high, int[] nums, Integer[][] dp) {
        if (low > high)
            return 0;
        if (dp[low][high] != null) {
            return dp[low][high];
        }
        dp[low][high] = 0;
        for (int i=low; i<=high; i++)  {
            int coins = nums[low-1] * nums[i] * nums[high+1];
            coins += dfs(low, i-1, nums, dp) + dfs(i+1, high, nums, dp);
            dp[low][high] = Math.max(dp[low][high], coins);
        }
        return dp[low][high];
    }
}
