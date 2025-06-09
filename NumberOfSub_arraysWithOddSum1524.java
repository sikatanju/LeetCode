public class NumberOfSub_arraysWithOddSum1524 {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long prefixSum = 0;
        long even_cnt = 0, odd_cnt = 0;
        int res = 0;
        for (var num: arr)  {
            prefixSum += num;
            if (prefixSum % 2 != 0)  {
                res++;
                res += even_cnt;
                odd_cnt++;
            }   else    {
                res += odd_cnt;
                even_cnt++;
            }
            res %= MOD;
        }
        return res;
    }
}

/* Improved Runtime: 3ms:
class Solution {

    private static final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else if (arr.length == 1) {
            return arr[0] % 2 == 0 ? 0 : 1;
        }
        // int odd = 0;
        // for (final int num : arr) {
        //     odd += (num % 2);
        // }
        // int even = arr.length - odd;
        // if (odd == 0) {
        //     return 0;
        // }
        // int ans = 1;
        // for (int i = 1; i < odd; i++) {
        //     ans %= MOD;
        //     ans *= 2;
        //     ans %= MOD;
        // }
        // for (int i = 0; i < even; i++) {
        //     ans %= MOD;
        //     ans *= 2;
        //     ans %= MOD;
        // }
        // return ans;
        long oddCount = 0, prefixSum = 0;
        for(int a : arr){
            prefixSum += a;
            oddCount += prefixSum % 2;
        }
        oddCount += (arr.length - oddCount) * oddCount;
        return (int)(oddCount % 1_000_000_007);
    }
}
 */

/* Best runtime: 1ms:

class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0;
        int sum = 0;
        for(int i : arr){
            odd += ((sum ^= i) & 1);
        }
        return (int)((odd + ((arr.length - odd) * (long)odd)) % 1_000_000_007);
    }
}
*/