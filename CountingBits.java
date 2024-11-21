public class CountingBits {
    public int[] countBits(int n) {
        int[] bits = new int[n+1];
        for (int i=1; i<=n; i++)    {
            int num = i, count = 0;
            while (num > 0) {
                if ((num & 1) == 1)
                    count++;

                num >>= 1;
            }
            bits[i] = count;
        }
        return bits;
    }
}


/* Best runtime: 0ms:
class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        bit(ret, 1, 1, n);
        return ret;
    }

    private void bit(int[] ret, int cur, int cnt, int n) {
        if (cur > n) {
            return;
        }
        ret[cur] = cnt;
        cur <<= 1;
        bit(ret, cur, cnt, n);
        bit(ret, cur + 1, cnt + 1, n);
    }
}
*/

/* Second Best: 1ms:
class Solution {
    public int[] countBits(int n) {


        int[] ans = new int[n+1];
        for(int i =1; i<=n ; i++){
           ans[i] = ans[i >> 1]+(i&1);
        }
        return ans;
    }
}
 */