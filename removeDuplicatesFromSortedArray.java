// This problem is from leetCode. Tags : Array, Difficulty : Easy.
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        
        for (int i=1; i<nums.length; i++)   {    
            if (nums[i] != nums[i-1])
                nums[count++] = nums[i];
        }

        return count;
    }

    public static void main(String[] args)  {
        int[] ara = {0,1,1,2,2,2,3,3,4,4};
        removeDuplicatesFromSortedArray obj = new removeDuplicatesFromSortedArray();
        System.out.println (obj.removeDuplicates(ara));
    }
}
