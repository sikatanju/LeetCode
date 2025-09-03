public class BestTimeToBuyAndSellStockIII {
    /*public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;
        for (var price: prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;
    }*/
}

/* Full fledged DP approach:
 class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][3];
        // for(int[][] mat:dp){
        //     mat[n][0]=0;
        //     mat[n][1]=0;
        // }
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j][0]=0;
            }
        }
        for(int index=n-1;index>=0;index--){
            for(int buy=1;buy>=0;buy--){
                for(int cap=2;cap>0;cap--){
                    int profit1=0;
                    int profit2=0;
                    if(buy==1){
                        //buy it
                        profit1=-prices[index]+dp[index+1][0][cap];
                        //dont buy it 
                        profit2=dp[index+1][1][cap];
                    }
                    else{
                        //sell it
                        profit1=prices[index]+dp[index+1][1][cap-1];
                        //dont sell it
                        profit2=dp[index+1][0][cap];
                    }
                    dp[index][buy][cap]=Math.max(profit1,profit2);             
                }
            }
        }
        return dp[0][1][2];

        
    }
}

class Solution {
 static int counter = 0;
    static int[] data = {6, 4, 0, 0, 1, 0, 0, 3, 3, 3, 2, 1, 0, 3, 0, 2, 7, 7, 11, 2, 3, 19, 6, 1, 13, 17, 12, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 10, 10, 13, 10, 13, 10, 12, 12, 15, 10, 15, 10, 15, 15, 15, 13, 12, 10, 15, 15, 15, 13, 12, 10, 10, 10, 13, 10, 13, 10, 12, 12, 15, 9, 15, 9, 15, 15, 15, 12, 12, 9, 15, 15, 15, 12, 12, 9, 10, 10, 15, 10, 15, 10, 10, 10, 15, 9, 15, 9, 13, 13, 13, 12, 8, 7, 13, 13, 13, 12, 8, 7, 10, 10, 12, 10, 12, 10, 10, 10, 12, 9, 12, 9, 10, 10, 10, 9, 8, 7, 7, 7, 7, 6, 5, 4, 6, 6, 8, 6, 8, 6, 6, 6, 8, 5, 8, 5, 6, 6, 6, 5, 4, 3, 3, 3, 3, 2, 1, 0, 7, 10, 6, 14, 11, 7, 15, 12, 11, 9, 14, 12, 15, 16, 10, 7, 14, 7, 14, 8, 14, 16, 5, 10, 13, 14, 15, 11, 11, 6, 19965, 4, 19994, 39994, 59994, 79993, 99995, 119994, 139994, 159996, 179994, 199992, 99999};        
    public static int maxProfit(int[] prices)
    {
        return data[counter++];
    }
}
 */

/* Best runtime: 4ms:
    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;
        for (var price: prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;
    }
 */
/* My Attempted Solution :
public int maxProfit(int[] prices) {
        int[] maxProfit = new int[2];

        int leastPrice = 100000, leastLeastPrice = 100000, len = prices.length;

        for (int i=0; i<len; i++)   {
            if (prices[i] < leastPrice)    {
                if (leastLeastPrice == leastPrice)  {
                    leastPrice = prices[i];
                }
                else {
                    if (leastPrice < leastLeastPrice)
                        leastLeastPrice = leastPrice;

                    leastPrice = prices[i];
                }
                continue;
            }

            var todayProfit = prices[i] - leastPrice;
            var todayProfitII = prices[i] - leastLeastPrice;

            if (i+1 < len && prices[i+1] < prices[i])   {
                if (todayProfit > 0)    {
                    if (maxProfit[0] <= maxProfit[1])   {
                        if (todayProfitII > todayProfit)    {
                            maxProfit[0] = todayProfitII;
                            leastLeastPrice = leastPrice;
                        }
                        else
                            maxProfit[0] = todayProfit;
                    }
                    else    {
                        if (todayProfitII > todayProfit)    {
                            maxProfit[1] = todayProfitII;
                            leastLeastPrice = leastPrice;
                        }
                        else
                            maxProfit[1] = todayProfit;
                    }

                }
                if (leastPrice == leastLeastPrice)
                    leastPrice = prices[i+1];
                else {
                    if (leastPrice < leastLeastPrice)
                        leastLeastPrice = leastPrice;

                    leastPrice = prices[i];
                }
            }
            else {
                if (i+1 < len && prices[i+1] > prices[i])
                    continue;

                else {
                    if (todayProfit > 0)    {
                        if (maxProfit[0] <= maxProfit[1])
                            maxProfit[0] = Math.max(todayProfit, todayProfitII);
                        else
                            maxProfit[1] = Math.max(todayProfit, todayProfitII);
                    }
                }
            }
        }
        return maxProfit[0]+maxProfit[1];
    }
 */
