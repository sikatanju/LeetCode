import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (var temp : nums)   {
            if (set.contains(temp))
                return true;

            set.add(temp);
        }
        return false;
    }
}
