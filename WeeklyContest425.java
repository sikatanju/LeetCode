import java.util.*;

public class WeeklyContest425 {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int len = s.length();
        int div = len/k;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<len; i += div)  {
            String sub = s.substring(i, i+div);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        for (int i=0; i<len; i += div)  {
            String sub = t.substring(i, i+div);
            if (map.getOrDefault(sub, 0) > 0)
                map.replace(sub, map.get(sub)-1);
            else
                return false;
        }
        return true;
    }
    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length+1;
        long maximumSum = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge: edges) {
            int src = edge[0], des = edge[1], wei = edge[2];
            String str = Integer.toString(src) + Integer.toString(des);
            String str2 = Integer.toString(des) + Integer.toString(src);
            if (!set.contains(str) && !set.contains(str2))    {
                set.add(str);
                set.add(str2);
                maximumSum += wei;
            }
            map.get(src).add(wei);
            map.get(des).add(wei);
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);
        for (int i=0; i<n; i++) {
            List<Integer> list = map.get(i);
            if (list.size() > k)    {
                for (var temp: list)
                    minHeap.offer(temp);

                int index = list.size()-k;
                while (!minHeap.isEmpty() && index-- > 0) {
                    maximumSum -= minHeap.poll();
                }
            }
        }
        return maximumSum;
    }
}

/*

 */
/*
public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE, len = nums.size();
        int[] ara = new int[len];
        for (int i=0; i<len; i++)
            ara[i] = nums.get(i);

        for (int i=0; i<len; i++)   {
            int tempSum = ara[i], count = 1, index = i+1;
            if (count >= l && tempSum > 0)
                minSum = Math.min(minSum, tempSum);
            while (index < len && count < r)   {
                tempSum += ara[index++];
                count++;
                if (count >= l && tempSum > 0)
                    minSum = Math.min(minSum, tempSum);
            }
        }

        return (minSum != Integer.MAX_VALUE && minSum > 0) ? minSum: -1;
    }
 */