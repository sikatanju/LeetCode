public class ProductsOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] returnAra = new int[len];
        returnAra[0] = 1;
        returnAra[len-1] = 1;

        for (int i=1; i<len; i++)
            returnAra[i] = returnAra[i-1] * nums[i-1];

        int temp = 1;
        for (int i=len-1; i>=0; i--)    {
            returnAra[i] = returnAra[i] * temp;
            temp = temp * nums[i];
        }
        return returnAra;
    }
}


/*    2ms runtime.
        int len = nums.length;
        int i=1, j=len-2;

        int[] prefix = new int[len];
        int[] suffix = new int[len];
        prefix[0] = 1;
        suffix[len-1] = 1;

        while (i<len)   {
            prefix[i] = prefix[i-1] * nums[i-1];
            suffix[j] = suffix[j+1] * nums[j+1];
            i++;
            j--;
        }

        nums = new int[len];
        for (int k=0; k<len; k++)
            nums[k] = prefix[k]*suffix[k];
 */