import java.util.HashMap;
import java.util.Map;

public class MaximumGoodSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> prefixSumMinValue = new HashMap<>();
        long prefixSum = 0, maxSum = Long.MIN_VALUE;
        for (var num: nums) {
            if (prefixSumMinValue.getOrDefault(num, Long.MAX_VALUE) > prefixSum)
                prefixSumMinValue.put(num, prefixSum);

            prefixSum += num;

            if (prefixSumMinValue.containsKey(num+k))
                maxSum = Math.max(maxSum, prefixSum - prefixSumMinValue.get(num+k));

            if (prefixSumMinValue.containsKey(num-k))
                maxSum = Math.max(maxSum, prefixSum - prefixSumMinValue.get(num-k));
        }
        return maxSum == Long.MIN_VALUE ? 0: maxSum;
    }
}
