import java.util.Arrays;

public class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 1;
        nums[0] -= k;
        for (int i=1; i<nums.length; i++)   {
            int max = Math.max(nums[i]-k, nums[i-1]+1);
            nums[i] = Math.min(nums[i]+k, max);
            if (nums[i] != nums[i-1])
                res++;
        }
        return res;
    }
}
