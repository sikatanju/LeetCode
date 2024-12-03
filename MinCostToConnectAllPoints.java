import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int len = points.length, minCost =0;
        for (int i=0; i<len; i++)   {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j=i+1; j<len; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{dist, j});
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        minHeap.add(new int[]{0,0});

        while (visited.size() < len)    {
            int[] curr = minHeap.poll();
            int dist = curr[0];
            int node = curr[1];
            if (visited.contains(node))
                continue;

            minCost += dist;
            visited.add(node);
            for (int[] nei: map.getOrDefault(node, Collections.emptyList()))    {
                int dis = nei[0], nextNode = nei[1];
                if (!visited.contains(nextNode))
                    minHeap.offer(new int[]{dis, nextNode});
            }
        }
        return minCost;
    }
}

/* Best runtime: 20ms:
class Solution {
    public int minCostConnectPoints(int[][] points) {
        // 01:59 - 2:10
        int[] minDistTo = new int[points.length];
        boolean computed[] = new boolean[points.length];
        int cost = 0;
        computed[0] = true;

        for (int i = 0; i < points.length; i++) {
            minDistTo[i] = Integer.MAX_VALUE;
        }

        int[] from = points[0];
        for (int i = 1; i < points.length; i++) {
            int minDistPoint = -1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < points.length; j++) {
                if (computed[j])
                    continue;
                int[] to = points[j];
                int dist = Math.abs(to[0] - from[0]) + Math.abs(to[1] - from[1]);
                dist = Math.min(minDistTo[j], dist);
                minDistTo[j] = dist;
                if (dist < minDist) {
                    minDist = dist;
                    minDistPoint = j;
                }
            }
            computed[minDistPoint] = true;
            cost += minDist;
            from = points[minDistPoint];
        }
        return cost;

    }
}
 */