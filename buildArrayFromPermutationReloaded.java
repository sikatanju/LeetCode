// Problem : 1920 : Build Array from permutation ...
// This impletentation is from "EOAndersson". https://leetcode.com/EOAndersson/
// This bitwise implementation only use O(1) space and will run at O(n) time.

import java.util.Arrays;

public class buildArrayFromPermutationReloaded {
    public static void buildArray(int[] ara)   {
        int mask = 1023;

        for (int i=0; i<ara.length; i++)
            ara[i] |= (ara[ara[i]] & mask) << 10;

        for (int i=0; i<ara.length; i++)    
            ara[i] = ara[i] >> 10;

        System.out.println (Arrays.toString(ara));
    }

    public static void main(String[] args)  {
        int[] nums = {0,2,1,5,3,4};
        buildArray(nums);
    }
}
