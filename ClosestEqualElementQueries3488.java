import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClosestEqualElementQueries3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++)
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        for (var arr: map.values()) {
            int nn = arr.size();
            if (nn == 1)
                nums[arr.getFirst()] = -1;

            else    {
                for (int i=0; i<nn; i++)    {
                    int curr = arr.get(i);
                    int high = arr.get((i+1+nn)%nn), low = arr.get((i-1+nn)%nn);
                    int highDiff = Math.min(Math.abs(high-curr), n - curr + high);
                    int lowDiff = Math.min(Math.abs(curr-low), n - low + curr);
                    nums[curr] = Math.min(highDiff, lowDiff);
                }
            }
        }
        List<Integer> res = new ArrayList<>(queries.length);
        for (int idx: queries)
            res.add(nums[idx]);

        return res;
    }
}
