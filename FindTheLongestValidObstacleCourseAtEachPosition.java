import java.util.Arrays;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    private int len;
    private int findIndex(int[] arr, int val)   {
        int low = 0, high = len-1, index = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] <= val)   {
                low = mid+1;
                index = low;
            }
            else {
                high = mid-1;
            }
        }
        return index;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        this.len = obstacles.length;
        int[] dp = new int[len+1], res = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for (int i=0; i<len; i++)   {
            int index = findIndex(dp, obstacles[i]);
            res[i] = index;
            dp[index] = obstacles[i];
        }
        return res;
    }
}

/* Best runtime: 24ms:
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int size = 1;

        // longest not decreasing subsequence
        int[] lis = new int[n + 1];

        int[] count = new int[n];
        count[0] = 1;

        lis[size] = obstacles[0];

        for (int i = 1; i < n; i++) {
            int curr = obstacles[i];
            if (curr >= lis[size]) {
                lis[++size] = curr;
                // length of subsequence which end can be updated to curr
                count[i] = size;
            } else {
                // longest increasing subsequence logic
                int left = 1;
                int right = size;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (lis[mid] > curr) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                lis[left] = curr;
                // length of subsequence which end can be updated to curr
                count[i] = left;
            }
        }
        return count;
    }
}
 */

/* Best memory, implemented with TreeMap:
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        TreeMap<Integer,Integer> mp = new TreeMap<>();

        mp.put(obstacles[0], 1);
        int[] ans = new int[obstacles.length];
        ans[0]=1;
        for(int i=1; i<obstacles.length; i++){
            // lowerbound and add current to the mp
            int count=1;
            if(mp.floorKey(obstacles[i]) != null){
                 count =mp.get( mp.floorKey(obstacles[i]))+1;
            }

            if(mp.higherKey(obstacles[i]) != null){
                if(mp.get(mp.higherKey(obstacles[i])) <= count)
                 mp.remove(mp.higherKey(obstacles[i]));
            }
            mp.put(obstacles[i], count);
            ans[i]=count;
        }
        return ans;
    }
}
 */