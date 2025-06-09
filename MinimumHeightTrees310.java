import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return new ArrayList<>(Arrays.asList(0));

        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        for (int[] arr: edges)  {
            int from = arr[0];
            int to = arr[1];
            adjacentList.computeIfAbsent(from, i -> new ArrayList<>()).add(to);
            adjacentList.computeIfAbsent(to, i -> new ArrayList<>()).add(from);
        }

        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> res = new HashMap<>();
        int minHeight = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            visited = new boolean[n];
            int count = 1, height = 0;
            visited[i] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (true)   {
                int size = queue.size();
                while (size-- > 0 && !queue.isEmpty())  {
                    int key = queue.poll();
                    for (int nei: adjacentList.get(key))    {
                        if (!visited[nei])  {
                            queue.add(nei);
                            visited[nei] = true;
                            count++;
                        }
                    }
                }
                height++;
                if (count == n)
                    break;
            }
            if (height < minHeight) {
                res.computeIfAbsent(height, k -> new ArrayList<>()).add(i);
                minHeight = height;
            }   else
                res.computeIfAbsent(height, k -> new ArrayList<>()).add(i);
        }
        return res.get(minHeight);
    }
}
