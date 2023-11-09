import java.util.HashSet;
import java.util.Set;

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int minSoFar = Integer.MAX_VALUE, maxSoFar = Integer.MIN_VALUE;
        var totalSum = 0;
        int currentMin = 0, currentMax = 0;

        for (var num: nums) {
            totalSum += num;
            currentMin = currentMin > 0 ? num : currentMin + num;
            currentMax = currentMax < 0 ? num : currentMax + num;
            maxSoFar = Math.max(maxSoFar, currentMax);
            minSoFar = Math.min(currentMin, minSoFar);
        }

        return maxSoFar>0 ? Math.max(maxSoFar, totalSum-minSoFar) : maxSoFar;
    }
}
