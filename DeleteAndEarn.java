import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        if (len == 2)   {
            if (nums[1]-1 != nums[0])
                return nums[1]+nums[0];

            return Math.max(nums[1], nums[0]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (var num: nums)	{
            if (!map.containsKey(num))	{
                list.add(num);
                map.put(num, num);
            }
            else	{
                map.replace(num, map.get(num)+num);
            }
        }
        int[] ara = new int[list.size()];
        int[] result = new int[ara.length];

        int index = 0;
        for (var temp: list)
            ara[index++] = temp;

        Arrays.sort(ara);

        result[0] = map.get(ara[0]);
        if (result.length == 1)
            return result[0];

        if (ara[1]-1 != ara[0])
            result[1] = map.get(ara[1]) + map.get(ara[0]);
        else
            result[1] = map.get(ara[1]);



        for (int i=2; i<ara.length; i++)	{
            int currentNum = map.get(ara[i]);
            if (ara[i]-1 == ara[i-1])   {
                int max = Integer.MIN_VALUE;
                for (int j=0; j<i-1; j++) {
                    max = Math.max(result[j], max);
                }
                result[i] = currentNum+max;
            }
            else   {
                int previousOne = result[i-1];
                int previousTwo = result[i-2];
                result[i] = Math.max(currentNum+previousOne, currentNum+previousTwo);
            }
        }
        return Math.max(result[ara.length-1], result[ara.length-2]);
    }
}

/* Best runtime : 1ms:
// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         short size = 10000;
//         short count[] = new short[size+1];
//         for(short i = 0; i < )
//     }
// }

class Solution {
    private int max(int a1, int a2) {
        return a1 > a2 ? a1 : a2;
    }

    public int deleteAndEarn(int[] nums) {
        short size = 10000;
        short[] arr = new short[size + 1];
        for (short i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }

        short i = size;
        while (arr[i] == 0) i--;

        int a0 = 0;
        int a1 = 0;
        int a2 = 0;

        for( ; i > 0; i--) {
            int temp = a0;
            a0 = arr[i] * i + max(a1, a2);
            a2 = a1;
            a1 = temp;
        }
        return max(a0, a1);
    }
}
 */


/* Second best : 2ms:
class Solution {
    public int deleteAndEarn(int[] nums) {

        int n = 0;
        for(int num : nums){
            n = Math.max(n, num);
        }
        int[] dp = new int[n+1];
        for(int num : nums){
            dp[num] += num;
        }
        for(int i = 2; i <= n; i++){
            dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
        }
        return dp[n];
    }
}
 */