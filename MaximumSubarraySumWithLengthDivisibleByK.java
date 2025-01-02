import java.util.Arrays;

public class MaximumSubarraySumWithLengthDivisibleByK {
    public long maxSubarraySum(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;
        int len = nums.length;
        long[] prefixSum = new long[len+1];
        for (int i=0; i<len; i++)
            prefixSum[i+1] = nums[i] + prefixSum[i];

        long[] minPrefixSum = new long[len];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE);

        for (int i=0; i<=len; i++)  {
            int remain = i % k;
            if (i>=k)   {
                long tempSum =  prefixSum[i]-minPrefixSum[remain];
                maxSum = Math.max(maxSum, tempSum);
            }
            minPrefixSum[remain] = Math.min(minPrefixSum[remain], prefixSum[i]);
        }
        return maxSum;
    }
}

/* Best runtime: 4ms:
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] maxSum = new long[n];
        long minSum = 0;
        for (int i = n - 1; i >= n - k + 1; i--) {
            maxSum[i] = Integer.MIN_VALUE;
            minSum += nums[i];
        }
        minSum += nums[n - k];
        maxSum[n - k] = minSum;
        long ans = minSum;
        for (int i = n - k - 1; i >= 0; i--) {
            minSum = minSum + nums[i] - nums[i + k];
            // System.out.println(minSum+" "+maxSum[i+k]);
            maxSum[i] = Math.max(minSum, minSum+maxSum[i + k] );
            ans = Math.max(maxSum[i], ans);
        }
        return ans;
    }
}
 */