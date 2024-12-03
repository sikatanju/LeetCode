import java.util.HashMap;
import java.util.Map;

public class IdentifyTheLargestOutlierInAnArray {
    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0,  outlier = -(int)1e9;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
            sum += num;
        }

        for (int num: nums) {
            int except = sum-num-num;
            int count = map.getOrDefault(except, 0);
            if (except == num)
                count--;

            if (count > 0)
                outlier = Math.max(outlier, except);
        }
        return outlier;
    }
}
