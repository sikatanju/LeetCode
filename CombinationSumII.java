import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum2(0, 0, target, new ArrayList<>(), list, candidates);
        return list;
    }

    private void combinationSum2(int i, int sum, int target, List<Integer> tempList, List<List<Integer>> list, int[] candidates) {
        if(sum == target)   {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (sum > target || i >= candidates.length)
            return;

        tempList.add(candidates[i]);
        combinationSum2(i+1, sum+candidates[i], target, tempList, list,candidates);

        tempList.remove(tempList.size()-1);
        combinationSum2(i+1, sum, target, tempList, list, candidates);
    }
}
