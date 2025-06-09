import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: nums) {
            prefixSum += num;
            int nn = prefixSum-k;
            if (map.containsKey(nn))
                cnt += map.get(nn);

            map.merge(prefixSum, 1, Integer::sum);
        }
        return cnt;
    }
}

/* Best runtime: it goes way over my head. So, not looking into it.
class Solution {
    private static final int NULL = Integer.MIN_VALUE, MIXER = 0x9E3779BA;
    public static int subarraySum(int[] nums, final int k){
        final int mask = mask(nums.length);
        final int[] hashtable = new int[mask + 1];
        int res = 0, sum = 0, zeros = 1;
        for(final int n : nums){
            sum += n;
            final int diff = sum - k;
            if(diff != 0){
                int i = diff * MIXER & mask;
                while(true){
                    final int key = hashtable[i];
                    if(key == 0) break;
                    if(key == diff){
                        res += hashtable[i+1];
                        break;
                    }
                    i = i + 2 & mask;
                }
            }else{
            res += zeros;
            }
            if(sum != 0){
                int i = sum * MIXER & mask;
                while(true){
                    final int key = hashtable[i];
                    if(key == 0){
                        hashtable[i] = sum;
                        hashtable[i + 1] = 1;
                        break;
                    }
                    if(key == sum){
                        hashtable[i+1]++;
                        break;
                    }
                    i = i + 2 & mask;
                }
            }else{
            zeros++;
        }
    }
    return res;
    }
    public static int mask(int n){
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >>8;
        return (n << 1) | 31;
    }
}
 */


/* My naive approach:
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
 */