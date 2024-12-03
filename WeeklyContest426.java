import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WeeklyContest426 {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum += x;
        }
        int best = -(int)1e9;
        for(int x : nums) {
            int except = sum - x - x;
            int cnt = map.getOrDefault(except, 0);
            if(except == x) {
                cnt--;
            }
            if(cnt > 0) {
                best = Math.max(best, except);
            }
        }
        return best;
    }
    public int smallestNumber(int n) {
        if (n == 1)
            return 1;

        for (int i=1; i<=10; i++)   {
            int temp = (int)(Math.pow(2, i)-1);
            if (temp >= n)
                return temp;
        }
        return -1;
    }
}
