import java.lang.reflect.Array;
import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length, max = Integer.MIN_VALUE;
        int[] dp = new int[len], cn = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(cn, 1);
        for (int i=0; i<len; i++)   {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j])  {
                    if (dp[j]+1 > dp[i])    {
                        dp[i] = dp[j]+1;
                        cn[i] = cn[j];
                    }
                    else if (dp[j]+1 == dp[i])
                        cn[i] += cn[j];
                }
            }
            max = Math.max(max, dp[i]);
        }
        int total = 0;
        for (int i=0; i<len; i++)   {
            if (dp[i] == max)
                total += cn[i];
        }
        return total;
    }
}
