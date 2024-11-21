import java.util.Arrays;

public class MinimumCostForCuttingCakeI {

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int rowCount = 1, columnCount = 1, res = 0;
        m -= 2;
        n -= 2;
        while (m >= 0 && n >= 0)    {
            if (horizontalCut[m] > verticalCut[n])  {
                res += horizontalCut[m] * columnCount;
                rowCount++;
                m--;
            }
            else {
                res += verticalCut[n] * rowCount;
                columnCount++;
                n--;
            }
        }
        while (n >= 0)  {
            res += verticalCut[n] * rowCount;
            columnCount++;
            n--;
        }
        while (m >= 0)  {
            res += horizontalCut[m] * columnCount;
//            rowCount++;
            m--;
        }
        return res;
    }
}


/* Simplest solution : Very intuitive
 public int minimumCost(int m, int n, int[] h, int[] v) {
        int res = Arrays.stream(h).sum() + Arrays.stream(v).sum();
        for (int a : h)
            for (int b : v)
                res += Math.min(a, b);
        return res;
    }
 */