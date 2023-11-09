public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        var maxSoFar = nums[0];
        var currentSum = 0;

        for (var num: nums) {
            currentSum = currentSum < 0 ? num : currentSum+num;
            maxSoFar = Math.max(currentSum, maxSoFar);
        }

        return maxSoFar;
    }
}
