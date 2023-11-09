import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 0, high = 1000000000+1;
        while (low < high)  {
            int mid = low + (high-low)/2;
            if (canEatAll(piles, mid, h))
                high = mid;
            else
                low = mid + 1;
        }
        if (low == 0)
            return 1;

        return low;
    }
    private boolean canEatAll(int[] piles, long perHour, int h)  {
        if (perHour == 0)
            return true;

        long hours = 0;
        for (var pile : piles)  {
            hours += pile/perHour;
            if (pile % perHour != 0)
                hours++;
        }
        return hours <= h;
    }
}



/* 0ms runtime :
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long s = 0;
        for (int pile : piles) {
            s += pile;
        }

        int left = (int) ((s - 1) / h) + 1;
        int right = (int) ((s - n) / (h - n + 1) + 1);
        while (left < right) {
            int mid = left + (right - left) / 2;

            long totalTime = 0;
            for (int pile : piles) {
                totalTime += ((pile - 1) / mid + 1);
            }

            if (totalTime <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}



2ms runtime :
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long pileCount = 0;
        for (int pile : piles) {
            pileCount += pile;
        }

        int left = Math.max(1, (int) (pileCount / h));
        int right = (int) ((pileCount + h) / (h - n + 1));
        while (left < right) {
            int mid = left + (right - left) / 2;

            // O(n)
            int totalTime = 0;
            for (int pile : piles) {
                totalTime += ((pile - 1) / mid + 1); // overflow

                if (totalTime > h) { // avoid overflow
                    break;
                }
            }

            if (totalTime <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
 */













/*
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] piles, int speed) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / speed;
            if (piles[i] % speed > 0) hours++;
        }
        return hours;
    }
}
 */