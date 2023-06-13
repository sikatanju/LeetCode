/*// // This problem is from leetCode. Tags : Array. Difficulty : Easy
// https://leetcode.com/problems/remove-element/
import java.util.Arrays;

public class removeElement {
    public static int removeElementt(int[] nums, int val)  {
        int k = 0;
        for (int i=0; i<nums.length; i++)   {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        // System.out.println (Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args)  {
        int[] ara = {1, 1, 2, 3, 4, 5, 6, 6, 7};
        System.out.println(removeElementt(ara, 6));
    }
}
*/