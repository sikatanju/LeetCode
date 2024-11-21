import java.util.*;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        weights[src] = 0;
        for (int i=0; i<=k; i++)    {
            int[] tempWeights = Arrays.copyOf(weights, weights.length);
            for (int[] flight: flights) {
                int source = flight[0], des = flight[1], weight = flight[2];
                if (weights[source] == Integer.MAX_VALUE)
                    continue;
                tempWeights[des] = Math.min(weights[source] + weight, tempWeights[des]);
            }
            weights = tempWeights;
        }
        return weights[dst] == Integer.MAX_VALUE ? -1: weights[dst];
    }
}
/* Best runtime: 0ms:
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            if (isBellmanFordCompleted(flights, dist)) {
                break;
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private boolean isBellmanFordCompleted(int[][] flights, int[] dist) {
        int[] prevDist = dist.clone();
        boolean completed = true;

        for (int[] edge : flights) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (prevDist[u] != Integer.MAX_VALUE && prevDist[u] + wt < dist[v]) {
                dist[v] = prevDist[u] + wt;
                completed = false;
            }
        }

        return completed;
    }
}
*/

/* Shortest Path Algorithm:
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (var flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] });
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, src, 0 });

        while (!q.isEmpty()) {
            var curr = q.poll();
            int cst = curr[0], node = curr[1], stops = curr[2];
            if (stops > k) continue;

            for (var neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCost = cst + w;
                if (nextCost < prices[nei]) {
                    prices[nei] = nextCost;
                    q.offer(new int[] { nextCost, nei, stops + 1 });
                }
            }
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
 */

/* Dijkstra's Algorithm:
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n];
        int[][] dist = new int[n][k + 5];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], INF);

        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[]{flight[1], flight[2]});
        }

        dist[src][0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        minHeap.offer(new int[]{0, src, -1});

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int cst = top[0], node = top[1], stops = top[2];
            if (node == dst) return cst;
            if (stops == k || dist[node][stops + 1] < cst) continue;
            for (int[] neighbor : adj[node]) {
                int nei = neighbor[0], w = neighbor[1];
                int nextCst = cst + w;
                int nextStops = stops + 1;
                if (dist[nei][nextStops + 1] > nextCst) {
                    dist[nei][nextStops + 1] = nextCst;
                    minHeap.offer(new int[]{nextCst, nei, nextStops});
                }
            }
        }
        return -1;
    }
}
 */