public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int low = nums[0];
        int high = nums[0];

        do {
            low = nums[low];
            high = nums[nums[high]];
        }   while (low != high);

        low = nums[0];

        while (low != high) {
            low = nums[low];
            high = nums[high];
        }

        return low;
    }
}

/* 3ms runtime :
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // Take the absolute value to handle negative numbers
            if (nums[num] < 0) {
                return num;
            }
            nums[num] = -nums[num];
        }

        // Restore the array to its original state (optional)
        for (int i = 0; i < n; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return -1; // No duplicate found
    }
}
 */

/* 1ms runtime :
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int count[]=new int[n];
        for(int num:nums){
            if(count[num]>0){
                return num;
            }
            count[num]++;
        }
        return -1;
    }
}
 */