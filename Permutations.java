import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(0, nums, permutations);
        return permutations;
    }

    private void permute(int i, int[] nums, List<List<Integer>> permutations) {
        if (i==nums.length) {
            permutations.add(new ArrayList<>());
            return;
        }

        List<List<Integer>> tempPermutations = new ArrayList<>();
        permute(i+1, nums, tempPermutations);
        for (var tempPerm: tempPermutations)    {
            for (int j=0; j<=tempPerm.size(); j++)  {
                var temp = new ArrayList<>(tempPerm);
                temp.add(j, nums[i]);
                permutations.add(temp);
            }
        }
    }
}


// 0ms Runtime :

/*
class Solution {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void f(int ind, int n, int[] nums, List<List<Integer>> al){
        if(ind==n){
            List<Integer> arr=new ArrayList<>();
            for(int x : nums){
                arr.add(x);
            }
            al.add(arr);
            return;
        }

        for(int i=ind; i<n; i++){
            swap(nums,i,ind);
            f(ind+1, n, nums, al);
            swap(nums,i,ind);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        f(0,nums.length,nums,ans);
        return ans;
    }
}
 */
