// This problem is from leetCode. Tags : Array. Difficulty : Easy
// https://leetcode.com/problems/two-sum/


import java.util.Arrays;
public class twoNums {
    public int[] twoSum (int[] nums, int target)    {
        int[] ara = {0, 0};
        for (int i=0; i<nums.length; i++)   {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target)    {
                    ara[0] = i;
                    ara[1] = j;
                }
            }
        }
        return ara;
    }
    public static void main(String[] args)  {
        twoNums nums = new twoNums();
        
        int[] ara = {3,2,4};
        System.out.println (Arrays.toString(nums.twoSum(ara, 6)));
    }
}
