// Difficulty : Medium
public class TwoSumII {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2)
            return new int[] {1, 2};

        int start = 0, end = nums.length-1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target)
                return new int[] {start+1, end+1};

            if (sum < target)
                start++;
            else
                end--;
        }
        return new int[]{1};
    }
}
