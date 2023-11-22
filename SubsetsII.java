import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    private int araLen;
    private int[] ara;
    List<List<Integer>> list;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.list = new ArrayList<>();
        this.ara = nums;
        this.araLen = ara.length;
        Arrays.sort(ara);
        subsetsWithDup(0, new ArrayList<>());
        return list;
    }

    private void subsetsWithDup(int i, List<Integer> tempList)   {
        if (i >= araLen)    {
            list.add(new ArrayList<>(tempList));
            return;
        }

        tempList.add(ara[i]);
        subsetsWithDup(i+1, tempList);
        tempList.remove(tempList.size()-1);
        while (i+1 < araLen && ara[i] == ara[i+1])
            i++;

        subsetsWithDup(i+1, tempList);
    }
}

/* Oms solution : (mine was 1ms) :

class Solution {
    int[] tillFreq ;
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		tillFreq = new int[10];
		int[] numFreq = new int[21];
		for (int i = 0; i < nums.length; i++) {
			tillFreq[i] = ++numFreq[nums[i]+10];
		}
		numFreq = new int[21];
		List<List<Integer>> subSets = new ArrayList<>();
		backTrack2(nums, new ArrayList<>(), subSets, 0,numFreq);
		return subSets;
	}

	private void backTrack2(int[] nums, ArrayList<Integer> arrayList, List<List<Integer>> subSets, int l,int[] numFreq) {
		subSets.add(new ArrayList<>(arrayList));
		for (int i = l; i < nums.length; i++) {
			if ((tillFreq[i] - 1) != numFreq[nums[i]+10])
				continue;
			arrayList.add(nums[i]);
			numFreq[nums[i]+10]++;
			backTrack2(nums, arrayList, subSets, i + 1,numFreq);
			arrayList.remove(arrayList.size() - 1);
			numFreq[nums[i]+10]--;
		}
	}
}


 */
