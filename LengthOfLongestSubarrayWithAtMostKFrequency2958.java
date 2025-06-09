public class LengthOfLongestSubarrayWithAtMostKFrequency2958 {
/*
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int low = 0, high = 0, n = nums.length, max = 1;

        while (high < n)    {
            int num = nums[high];
            if (!map.containsKey(num))  {
                map.put(num, 1);
                high++;
            }
            else    {
                if (map.get(num) == k)  {
                    while (map.getOrDefault(num, 0) == k)   {
                        map.put(nums[low], map.get(nums[low])-1);
                        if (map.get(nums[low]) == 0)
                            map.remove(nums[low]);

                        low++;
                    }
                }   else    {
                    map.put(num, map.get(num)+1);
                    high++;
                }
            }
            max = Math.max(max, high-low);
        }

        return max;
    }
*/
}

/* Best runtime: 35ms:
    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            int n = nums.length;
            Map<Integer,Queue<Integer>> cnt = new HashMap<>(n);
            int max = 0;
            for (int i = 0, j = 0; i < n; i++) {
                Queue<Integer> p = cnt.get(nums[i]);
                if (p == null) {
                    p = new LinkedList<>();
                    cnt.put(nums[i],p);
                }
                p.offer(i);
                if (p.size() > k) {
                    j = Math.max(j, p.poll()+1);
                }
                max = Math.max(max, i-j+1);
            }
            return max;
        }
    }
 */