public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length, buy[] = new int[len], sell[] = new int[len];
        if (len <= 1)
            return 0;

        buy[0] = -prices[0];
        for (int i=1; i<len; i++)   {
            int currentPrice = prices[i];
            buy[i] = Math.max(buy[i-1], sell[i-1] - currentPrice);
            sell[i] = Math.max(sell[i-1], buy[i-1] + currentPrice - fee);
        }

        return sell[len-1];
    }
}


/* Best runtime : 3ms
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int min = prices[0];

        for (int price : prices) {
            if (price < min) min = price;
            else if (price > min + fee) {
                // sell at price that bought at price `min`/
                // with transaction fee.
                profit += (price - min - fee);
                min = price - fee;
            }
        }
        return profit;
    }
}
 */