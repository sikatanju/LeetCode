import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    private int target, n;
    private boolean[] taken;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;

        Arrays.sort(nums);
        reverse(nums);
        n = nums.length;
        target = sum / k;
        this.taken = new boolean[n];
        return backtrack(0, 0, k, nums);
    }
    private boolean backtrack(int i, int currSum, int k, int[] nums)    {
        if (k == 0)
            return true;

        if (currSum == target)
            return backtrack(0, 0, k-1, nums);

        for (; i<n; i++) {
            if (taken[i] || currSum+nums[i] > target)
                continue;

            taken[i] = true;
            if (backtrack(i+1, currSum+nums[i], k, nums))
                return true;

            taken[i] = false;
            if (currSum == 0)
                return false;
        }
        return false;
    }
    private void reverse(int[] nums)    {
        int low = 0, high = nums.length-1;
        while (low <= high) {
            int temp = nums[low];
            nums[low++] = nums[high];
            nums[high--] = temp;
        }
    }
}