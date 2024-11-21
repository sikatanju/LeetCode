public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int len = arr.length, dp[] = new int[len+1];
        if (len <= 1)
            return arr[0];

        for (int i=1; i<=len; i++)  {
            int max = 0;
            for (int j=1; j<=Math.min(i, k); j++)   {
                max = Math.max(max, arr[i-j]);
                int option = dp[i-j] + (max * j);
                dp[i] = Math.max(dp[i], option);
            }
        }
        return dp[len];
    }
}


/* Best runtime : 1ms
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[500];

        for (int max = dp[0] = arr[0], i = 1; i < k; ) {
            if (arr[i] > max)
                max = arr[i];
            dp[i] = max * ++i;
        }

        for (int i = k; i < arr.length; i++)
            find(arr, k, i, dp);

        return dp[arr.length - 1];
    }

    private static void find(int[] arr, int k, int i, int[] dp) {
        int maxSum = 0;
        for (int max = arr[i], j = i, bound = i - k; j > bound; ) {
            if (max < arr[j])
                max = arr[j];

            int sum = dp[--j] + max * (i - j);
            if (sum > maxSum)
                maxSum = sum;

        }
        dp[i] = maxSum;
    }
}
 */