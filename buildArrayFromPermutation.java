// This problem is from leetCode - #1920 - build Array from permutation.
import java.util.Arrays;

public class buildArrayFromPermutation {
    public int[] buildArray(int[] nums)    {
        int[] ara = new int[nums.length];
        
        for (int i=0; i<nums.length; i++)   {
            ara[i] = nums[nums[i]];
        }

        /*for (int i=0; i<nums.length-1; i++)    {
            System.out.print (ara[i] + ",");
        }
        System.out.println (ara[nums.length-1]);*/
        return ara;
    }

    public static void main(String[] args)  {
        
        int[] nums = {5,0,1,2,3,4};
        
        buildArrayFromPermutation obj = new buildArrayFromPermutation();

        System.out.println (Arrays.toString(obj.buildArray(nums)));
    }
}
