import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(0, candidates, 0, target, currentList, list);
        return list;
    }

    private void dfs(int i, int[] ara, int sum, int target, List<Integer> currentList, List<List<Integer>> list) {
        if (sum == target)  {
            list.add(new ArrayList<>(currentList));
            return;
        }
        if (i >= ara.length || sum > target)
            return;

        currentList.add(ara[i]);
        dfs(i, ara, sum+ara[i], target, currentList, list);
        currentList.remove(currentList.size()-1);

        dfs(i+1, ara, sum, target, currentList, list);
    }
}


// Best Runtime: 0ms :


/*

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            return new AbstractList<List<Integer>>() {
            private List<List<Integer>> ans;

            @Override
            public List<Integer> get(int index) {
                if (ans == null) {
                    init();
                }
                return ans.get(index);
            }

            private void init() {
                ans = new ArrayList<>();
                Arrays.sort(candidates);
                findCombination(0, target, new ArrayList<>());
            }

            private void findCombination(int index, int target, ArrayList<Integer> elements) {
                if (target == 0) {
                    ans.add(new ArrayList<>(elements));
                    return;
                }
                if (target < 0 || index == candidates.length) {
                    return;
                }
                for (int i = index; i < candidates.length; i++) {

                    if (target >= candidates[i]) {
                        elements.add(candidates[i]);
                        // 不限次数
                        findCombination(i, target - candidates[i], elements);
                        elements.remove(elements.size() - 1);
                    } else {
                        // 数组是经过排序的，后续都比当前元素大，不用再搜索
                        break;
                    }
                }
            }

            @Override
            public int size() {
                if (ans == null) {
                    init();
                }
                return ans.size();
            }
        };
    }
}

 */