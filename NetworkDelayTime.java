import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int minCost = Integer.MAX_VALUE, len = times.length;
        int[] weights = new int[n+1];
        Arrays.fill(weights, Integer.MAX_VALUE);

        weights[k] = 0;
        weights[0] = -1;
        for (int i=0; i<=n; i++) {
            for (int[] time: times) {
                int src = time[0], des = time[1], weight = time[2];
                if (weights[src] != Integer.MAX_VALUE && weights[src]+weight < weights[des])
                    weights[des] = weights[src]+weight;
            }
        }
        int max = Arrays.stream(weights).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1: max;
    }
}

/* Runtime: 4ms:
import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize an array to store the minimum time to reach each node
        int[] minTime = new int[n + 1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;

        // Relax all edges (n - 1) times using Bellman-Ford algorithm
        for (int i = 1; i < n; i++) {
            boolean updated = false;
            for (int[] time : times) {
                int source = time[0];
                int destination = time[1];
                int travelTime = time[2];

                if (minTime[source] != Integer.MAX_VALUE && minTime[source] + travelTime < minTime[destination]) {
                    minTime[destination] = minTime[source] + travelTime;
                    updated = true;
                }
            }
            // If no update was made, we can terminate early
            if (!updated) break;
        }

        // Find the maximum time to reach all nodes
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) return -1;
            maxDelay = Math.max(maxDelay, minTime[i]);
        }

        return maxDelay;
    }
}
 */
/* Dijkstra's Algorithm:
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(k, 0);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {k, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], time = curr[1];
            if (dist.get(node) < time) {
                continue;
            }
            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0], weight = nei[1];
                if (time + weight < dist.get(nextNode)) {
                    dist.put(nextNode, time + weight);
                    q.offer(new int[] {nextNode, time + weight});
                }
            }
        }

        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
 */
/* Shortest Path faster algorithm:
public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) adj.put(i, new ArrayList<>());
        for (int[] time : times) {
            adj.get(time[0]).add(new int[] {time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 1; i <= n; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(k, 0);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {k, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], time = curr[1];
            if (dist.get(node) < time) {
                continue;
            }
            for (int[] nei : adj.get(node)) {
                int nextNode = nei[0], weight = nei[1];
                if (time + weight < dist.get(nextNode)) {
                    dist.put(nextNode, time + weight);
                    q.offer(new int[] {nextNode, time + weight});
                }
            }
        }

        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

 */