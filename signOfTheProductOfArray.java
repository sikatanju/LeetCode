// From LeetCode -- Difficulty : Easy.
// https://leetcode.com/problems/sign-of-the-product-of-an-array/

public class signOfTheProductOfArray {
    public static int returnFunc(int[] ara)    {        
        int prd = 1;
    
        for (int temp : ara)    {
            if (temp == 0)
                return 0;
            if (temp < 0)
                prd = -prd;
        }

        if (prd > 0)
            return 1;
        else
            return -1;
    }
    public static void main(String[] args)  {
        int[] ara = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        System.out.println(returnFunc(ara));
    }
}
