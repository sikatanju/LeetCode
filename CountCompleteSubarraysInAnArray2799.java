public class CountCompleteSubarraysInAnArray2799 {
/*    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        int distinct = set.size();
        int idx = 0, n = nums.length;
        int cnt = 0;
        for (int i=0; i<=n-distinct; i++) {
            idx = i;
            set = new HashSet<>();
            while (idx < n && set.size() < distinct)  {
                set.add(nums[idx++]);
            }
            if (set.size() >= distinct)
                cnt += (1+(n-idx));
        }
        return cnt;
    }
 */
}
