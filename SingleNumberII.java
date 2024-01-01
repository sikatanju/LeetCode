public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0; i<32; i++)    {
            int sum = 0;
            int mask = (1 << i);
            for (int num: nums) {
                if ((mask & num) != 0)
                    sum++;
            }
            if (sum % 3 != 0)   {
                result += mask;
            }
        }
        return result;
    }
}


/* 0ms runtime :
class Solution {
    public int singleNumber(int[] nums) {
        int one =0,threes=0;
        for(int n:nums){
            one ^=(n & (~threes));
            threes ^=(n & (~one));
        }
        return one;
    }
}
 */