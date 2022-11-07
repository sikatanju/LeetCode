// LeetCode : https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/
// Difficulty : Medium.

// First reverse all the integers from the original array, and then add all the reversed number at the back of the original array.
// Then find the distinct number of integers from the array.

import java.util.Set;
import java.util.HashSet;

public class countNumberOfDistinctIntegers {
    public int countDistinctIntegers(int[] nums) {
        // Since, Set doesn't contains any duplicate number of elements. We've gone with Set.
        Set<Integer> hashSet = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++)   {
            hashSet.add(nums[i]);
            hashSet.add(reverse(nums[i]));
        }
        return hashSet.size();   
    }
    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev *= 10;
            rev += (num % 10);
            num /= 10;
        }
        return rev;
    }
}
