import java.util.HashMap;
import java.util.Map;

// Difficulty : Easy
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 1)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++)   {
            if (map.containsKey(nums[i]))   {
                int first = map.get(nums[i]);
                if (Math.abs(i-first) <= k)
                    return true;
                else
                    map.replace(nums[i], i);
            }
            else
                map.put(nums[i], i);
        }
        return false;
    }
}
