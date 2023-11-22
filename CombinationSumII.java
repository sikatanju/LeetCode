import java.util.*;

public class CombinationSumII {
    private List<List<Integer>> combinationList;
    private int[] candidates;
    private int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.combinationList = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(candidates);
        combinationSum2(0, 0, new ArrayList<>());
        return combinationList;
    }

    private void combinationSum2(int i, int sum, List<Integer> tempList) {
        if(sum == target)   {
            combinationList.add(new ArrayList<>(tempList));
            return;
        }
        if (sum > target || i == candidates.length)
            return;

        tempList.add(candidates[i]);
        combinationSum2(i+1, sum+candidates[i], tempList);
        tempList.remove(tempList.size()-1);
        while (i+1 < candidates.length && candidates[i] == candidates[i+1])
            i++;

        combinationSum2(i+1, sum, tempList);
    }
}


/* Oms Runtime :

import java.util.AbstractList;
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            @Override
            public int size() {
                init();
                return result.size();
            }
            @Override
            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }
            protected void init() {
                if (result != null)
                    return;
                result = new ArrayList<List<Integer>>();
                Arrays.sort(candidates);
                dfsHelper(candidates, target, 0, new LinkedList<Integer>(), result);
            }
        };
    }
    private void dfsHelper(int[] candidates, int target, int start, List<Integer> combination,         List<List<Integer>> result) {
        if(target < 0) return;
        else if(target == 0) {
            System.out.println(combination);
            result.add(new LinkedList<>(combination));
        } else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1]) continue;

                combination.add(candidates[i]);
                dfsHelper(candidates, target - candidates[i], i + 1, combination, result);
                combination.remove(combination.size() - 1);

            }
        }

    }
}


### 1ms runtime :

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int[] count = new int[51];
        for (int c : candidates) {
            count[c]++;
        }

        List<List<Integer>> rs = new ArrayList<>();
        backtrace(rs, new ArrayList<>(), count, 1, target);

        return rs;
    }

    private void backtrace(List<List<Integer>> rs, List<Integer> trace, int[] count, int start, int t) {
        if (0 == t) {
            rs.add(new ArrayList(trace));
            return;
        }

        for (int i=start; i<count.length; ++i) {
            if (count[i] == 0) continue;

            if (i > t) return;

            int revert = 0;
            for (int j=1; j<=count[i]; ++j) {
                if (i * j > t) {
                    break;
                };

                trace.add(i);
                revert++;

                backtrace(rs, trace, count, i + 1, t - i * j);
            }

            while (revert > 0) {
                trace.remove(trace.size() - 1);
                revert--;
            }

        }

    }
}
 */