public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int currSum = 0, totalSumEK = 0;
        for (int i=0; i<nums.length; i++)	{
            currSum += nums[i];
            if (i+1 < nums.length)	{
                for (int j=i+1; j<nums.length; j++)	{
                    if (currSum == k)
                        totalSumEK++;

                    currSum += nums[j];
                }
                if (currSum == k)
                    totalSumEK++;
            }
            else    {
                if (currSum == k)
                    totalSumEK++;
            }
            currSum = 0;
        }
        return totalSumEK;
    }
}
