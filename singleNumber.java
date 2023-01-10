import java.util.Set;
import java.util.HashSet;

public class singleNumber {
    public int findNumber (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)    {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        var n = set.toArray();
        return (int)n[0];
        // return set.size();
    }
}
