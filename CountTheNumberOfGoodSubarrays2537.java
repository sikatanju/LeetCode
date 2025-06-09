import java.util.HashMap;
import java.util.Map;

public class CountTheNumberOfGoodSubarrays2537 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        long res = 0;
        int low = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = freq.getOrDefault(num, 0);
            k -= cnt;
            freq.put(num, cnt + 1);
            while (k <= 0) {
                int cnt2 = freq.getOrDefault(nums[low], 0);
                freq.put(nums[low], cnt2 - 1);
                k += --cnt2;
            }
            res += low;
        }
        return res;
    }
}