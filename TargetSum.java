public class TargetSum {
    private int totalNumOfSum;
    public int findTargetSumWays(int[] nums, int target) {
        totalNumOfSum = 0;
        dfs(0, 0, nums, target);
        return totalNumOfSum;
    }
    private void dfs (int i, int sum, int[] nums, int target)	{
        if (sum == target && i == nums.length)	{
            this.totalNumOfSum++;
        }
        if (i >= nums.length)
            return;

        dfs(i+1, sum+(nums[i]), nums, target);
        dfs(i+1, sum+(-nums[i]), nums, target);
    }
}

/* Best runtime : 5ms:
class Solution {
  int[] dp;

    public int findTargetSumWays(int[] nums, int target) {
       int sum=0;
       for(int x:nums){
        sum+=x;
       }
       target=Math.abs(target);
       int s1 = (sum+target)/2;
       if((sum+target)%2==1)return 0;
       dp =new int[s1+1];
       dp[0]=1;
        find(0,nums,s1);
        return dp[s1];
    }
    public void find(int i,int[] nums,int target){
        if(i==nums.length)return;
        for(int k=target;k>=nums[i];k--){
            dp[k]+=dp[k-nums[i]];
        }
        find(i+1,nums,target);
    }
}
 */