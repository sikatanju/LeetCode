import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        subsets(0, new ArrayList<>(), list, nums);
        return list;
    }

    private void subsets(int i, List<Integer> tempList, List<List<Integer>> list, int[] ara)   {
        if (i >= ara.length)    {
            list.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(ara[i]);
        subsets(i+1, tempList, list, ara);
    }
}
