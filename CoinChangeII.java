public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int  temp = coins[len-1];

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int j=1; j<=amount; j++)   {
            int current = j - temp;
            dp[j] = current < 0 ? 0 : dp[current];
//            if (current < 0)
//                dp[j] = 0;
//            else
//                dp[j] = dp[current];
        }
        for (int i=len-2; i>=0; i--)    {
            int[] arr = new int[amount+1];
            temp = coins[i];
            for (int j=0; j<=amount; j++)   {
                int current = j - temp;
                arr[j] = (current < 0) ? dp[j] : arr[current]+dp[j];
//                if (current < 0)
//                    arr[j] = dp[j];
//                else
//                    arr[j] = arr[current]+dp[j];
            }
            dp = arr;
        }
        return dp[amount];
    }

}

/* Best runtime: 2ms
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
 */
