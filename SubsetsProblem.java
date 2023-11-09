import java.util.ArrayList;
import java.util.List;

public class SubsetsProblem {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        findSubsets(0, nums, tempList, subsets);
        return subsets;
    }

    private void findSubsets(int i, int[] nums, List<Integer> tempList, List<List<Integer>> subsets) {
        if (i >= nums.length)   {
            subsets.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(nums[i]);
        findSubsets(i+1, nums, tempList, subsets);
        tempList.remove(tempList.size()-1);
        findSubsets(i+1, nums, tempList, subsets);
    }
}
