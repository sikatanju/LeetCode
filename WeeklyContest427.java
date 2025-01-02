public class WeeklyContest427 {
    public long maxSubarraySum(int[] nums, int k) {
        if (k == 1)
            return getMaxSubArray(nums);

        long maxSum = Long.MIN_VALUE;
        for (int i=0; i<nums.length; i++)   {
            maxSum = Math.max(maxSum, maxSubarraySum2(nums, k, i));
        }
        return maxSum;
    }
    private long maxSubarraySum2(int[] nums, int k, int startIndex) {
        if (k == 1)
            return getMaxSubArray(nums);

        long maxSum = Long.MIN_VALUE;
        int low = startIndex, high = startIndex, len = nums.length, count = 0;
        long tempSum = 0;
        while (high < len && count < k)   {
            tempSum += nums[high++];
            count++;
        }
        if (count != 0 && count % k == 0)
            maxSum = Math.max(tempSum, maxSum);

        while (high<len) {
            if (high + k <= len) {
                int tempCount = 0;
                while (tempCount++ < k) {
                    tempSum += nums[high++];
                    count++;
                }
            } else {
                tempSum += nums[high];
                high++;
                tempSum -= nums[low++];
            }
            if (count != 0 && count % k == 0)
                maxSum = Math.max(tempSum, maxSum);
        }
        while (low < high)  {
            count--;
            tempSum -= nums[low++];
            if (count != 0 && count % k == 0)
                maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum;
    }
    private long getMaxSubArray(int[] nums) {
        var maxSoFar = nums[0];
        var currentSum = 0;

        for (var num: nums) {
            currentSum = currentSum < 0 ? num : currentSum+num;
            maxSoFar = Math.max(currentSum, maxSoFar);
        }

        return maxSoFar;
    }
    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i=0; i<len; i++)   {
            int temp = nums[i], tempIndex = i;
            if (temp > 0)   {
                tempIndex += temp;
                tempIndex %= len;
            }   else if (temp < 0)  {
                int steps = Math.abs(temp);
                while (steps > 0)    {
                    if (tempIndex == 0) {
                        tempIndex = len-1;
                        steps--;
                        continue;
                    }
                    tempIndex--;
                    steps--;
                }
            }
            res[i] = nums[tempIndex];
        }
        return res;
    }
}
