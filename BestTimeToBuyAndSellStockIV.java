import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (k > len/2)  {
            int maxProfitSoFar = 0;
            for (int i=1; i<len; i++)   {
                if (prices[i] > prices[i-1])
                    maxProfitSoFar += prices[i] - prices[i-1];
            }
            return maxProfitSoFar;
        }

        int[][] dp = new int[k+1][len];
        for (int i=1; i<=k; i++)    {
            int max = dp[i-1][0] - prices[0];
            for (int j=1; j<len; j++)   {
                dp[i][j] = Math.max(dp[i][j-1], max + prices[j]);
                max = Math.max(max, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][len-1];
    }
}


/* Best runtime : 1ms :
class Solution {
    //space optimization

    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int []prev=new int[2*k+1];
        int []curr=new int[2*k+1];

        for(int ind=n-1;ind>=0;ind--){
            for(int tran=2*k-1;tran>=0;tran--){
                if(tran%2==0){
                    curr[tran]=Math.max(-prices[ind]+prev[tran+1],prev[tran]);
                }
                else{
                    curr[tran]= Math.max(prices[ind]+prev[tran+1],prev[tran]);
                }
            }
            prev=curr;
        }
        return prev[0];
    }
}
 */