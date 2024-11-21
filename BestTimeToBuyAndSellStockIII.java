import java.util.Comparator;
import java.util.PriorityQueue;

public class BestTimeToBuyAndSellStockIII {
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
}

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
