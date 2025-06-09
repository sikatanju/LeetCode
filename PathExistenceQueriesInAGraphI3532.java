public class PathExistenceQueriesInAGraphI3532 {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] union = new int[n];
        for (int i=0; i<n; i++)
            union[i] = i;

        boolean[] res = new boolean[queries.length];
        int prev = nums[0];

        for (int i=1; i<n; i++)   {
            int curr = nums[i];
            if (Math.abs(curr-prev) <= maxDiff) {
                union[i] = union[i-1];
            }
            prev = curr;
        }
        for (int i=0; i<queries.length; i++)    {
            int[] arr = queries[i];
            if (union[arr[0]] == union[arr[1]]) {
                res[i] = true;
            }
        }
        return res;
    }
}
/* Best runtime: 2ms
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] group = new int[nums.length];
        int groupId = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i]-nums[i-1] <= maxDiff){
                group[i] = groupId;
            }else{
                groupId++;
                group[i] = groupId;
            }
        }

        boolean[] answer = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];

            if(group[start] == group[end]){
                answer[i] = true;
            }else{
                answer[i] = false;
            }
        }

        return answer;
    }
}
 */