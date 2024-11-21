public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] buy = new int[len+1], sell = new int[len+1];
        buy[1] = -prices[0];
        for (int i=2; i<=len; i++)  {
            int curretPrice = prices[i-1];
            buy[i] = Math.max(buy[i-1], sell[i-2]-curretPrice);
            sell[i] = Math.max(sell[i-1], buy[i-1]+curretPrice);
        }
        return sell[len];
    }
}

