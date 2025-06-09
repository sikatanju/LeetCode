import java.util.Arrays;

public class CountTheNumberOfFairPairs2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<n; i++) {
            int low = getLower(nums, i, lower);
            int high = getUpper(nums, i, upper);
            res += high-low;
        }
        return res;
    }

    private int getUpper(int[] arr, int idx, int upper) {
        int low = idx+1, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[idx]+arr[mid] <= upper)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }

    private int getLower(int[] arr, int idx, int upper) {
        int low = idx+1, high = arr.length-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (arr[idx]+arr[mid] >= upper)
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}

/* Best runtime: 23ms:

import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower - 1);
    }

    private long count(int[] nums, int target) {
        long res = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) right--;
            else res += right - left++;
        }
        return res;
    }
}
 */