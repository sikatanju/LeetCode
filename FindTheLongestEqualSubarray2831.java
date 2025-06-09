public class FindTheLongestEqualSubarray2831 {
/*
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.size(); i++)   {
            int num = nums.get(i);
            map.computeIfAbsent(num, j->new ArrayList<>()).add(i);
        }
        int max = 1;
        for (int key: map.keySet()) {
            List<Integer> list = map.get(key);
            int low = 0, high = 0, n = list.size();

            while (high < n)    {
                int rr = list.get(high) - list.get(low) + 1;
                int ll = high - low + 1;
                if (rr-ll <= k) {
                    max = Math.max(ll, max);
                    high++;
                }   else    {
                    low++;
                }
            }
        }
        return max;
    }
*/
}
