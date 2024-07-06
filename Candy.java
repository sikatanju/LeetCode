public class Candy {
    public int candies(int[] ratings) {
        int araLen = ratings.length;

        int[] candies = new int[araLen];
        int minCandy = araLen;

        for (int i=0; i<araLen; i++)    {
            if (i-1 >= 0 && i+1 < araLen)  {
                if (ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1]+1;

                else if (ratings[i] > ratings[i+1]) {
                    candies[i] = candies[i+1]+1;
                    prev(ratings, candies, i);
                }

            }
            else if (i-1 >= 0)   {
                if (ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1]+1;
            }
            else if (i+1 < araLen) {
                if (ratings[i] > ratings[i+1])  {
                    candies[i] = candies[i+1]+1;
                    prev(ratings, candies, i);
                }
            }
        }

        for (var temp: candies)
            minCandy += temp;

        return minCandy;
    }

    private void prev(int[] ratings, int[] candies, int i) {
        if (i <= 0)
            return;

        if (ratings[i-1] > ratings[i])  {
            int prev = i-1, curr = i;
            while (prev >= 0 && ratings[prev] > ratings[curr] && candies[prev] <= candies[curr])  {
                candies[prev]++;
                prev--;
                curr--;
            }
        }
    }
}

/* Best runtime : 3ms :
class Solution {
    public int candy(int[] ratings) {
        return sol(ratings, 0, 0);
    }

    public int sol(int[] r, int s, int prev) {

        if (s >= r.length) {
            return 0;
        }

        if (s == (r.length-1)) {
            return 1 + Math.max(0, prev-1);
        }

        if ((s+1) == (r.length-1)) {

            if (r[s] == r[r.length-1]) {
                return 2 + Math.max(0, prev-1);
            } else if (r[s] > r[r.length-1]) {
                return 3 + Math.max(0, prev-2);
            } else {
                return 3 + Math.max(0, prev-1);
            }

            // return ((r[s] == r[r.length-1]) ? 2 : 3) + Math.max(0, prev-1);
        }

        if (r[s] == r[s+1]) {
            return 1 + sol(r, s+1, 0) + Math.max(0, prev-1);
        }

        if (r[s] > r[s+1]) {
            int low = minima(r, s, 1);
            int cnt = (low-s+1);
            return cnt*(cnt+1)/2 - 1 + sol(r, low, 0) + Math.max(0, prev-cnt);
        } else {
            int high = minima(r, s, -1);
            int cnt = (high-s+1);
            return cnt*(cnt+1)/2 - cnt + sol(r, high, cnt) + Math.max(0, prev-1);
        }

    }

    public int minima(int[] r, int s, int a) {

        for (int i=(s+1); i<(r.length-1); i++) {
            if (a*r[i] <= a*r[i+1]) {
                return i;
            }
        }

        return r.length-1;
    }
}
*/

/* Second best : 7ms :
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i=1; i<n; i++) {
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for (int i=n-2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
*/


/* Accepted Solution :

    public int candies(int[] ratings) {
        int araLen = ratings.length;

        int[] candies = new int[araLen];
        int minCandy = araLen;

        for (int i=0; i<araLen; i++)    {
            if (i-1 >= 0 && i+1 < araLen)  {
                if (ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1]+1;

                else if (ratings[i] > ratings[i+1]) {
                    candies[i] = candies[i+1]+1;
                    prev(ratings, candies, i);
                }

            }
            else if (i-1 >= 0)   {
                if (ratings[i] > ratings[i-1])
                    candies[i] = candies[i-1]+1;
            }
            else if (i+1 < araLen) {
                if (ratings[i] > ratings[i+1])  {
                    candies[i] = candies[i+1]+1;
                    prev(ratings, candies, i);
                }
            }
        }

        for (var temp: candies)
            minCandy += temp;

        return minCandy;
    }

    private void prev(int[] ratings, int[] candies, int i) {
        if (i <= 0)
            return;

        if (ratings[i-1] > ratings[i])  {
            int prev = i-1, curr = i;
            while (prev >= 0 && ratings[prev] > ratings[curr])  {
                if (candies[prev] <= candies[curr])
                    candies[prev]++;

                prev--;
                curr--;
            }
        }
    }
 */