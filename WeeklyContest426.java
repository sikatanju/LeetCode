import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Map;

public class WeeklyContest426 {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        int n = edges1.length + 1;
        int[] cnt1 = new int[n];
        for (int from = 0; from < n; from++) {
            cnt1[from] = getNodesWithinK(graph1, from, k);
        }

        Map<Integer, List<Integer>> graph2 = buildGraph(edges2);
        int m = edges2.length + 1;
        int[] cnt2 = new int[m];
        int max = -1;
        for (int from = 0; from < m; from++) {
            cnt2[from] = getNodesWithinK(graph2, from, k-1);
            max = Math.max(max, cnt2[from]);
        };

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = cnt1[i] + max;
        }
        return res;
    }

    private int getNodesWithinK (Map<Integer, List<Integer>> graph, int from, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{from, -1});

        int cnt = 0;
        int layer = 0;
        while (!queue.isEmpty() && layer <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int curr = arr[0], parent = arr[1];
                for (int next : graph.get(curr)) {
                    if (next == parent) continue;
                    queue.offer(new int[]{next, curr});
                }
                cnt++;
            }
            layer++;
        }
        return cnt;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        int n = edges.length + 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        return graph;
    }

    public int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int sum = 0;
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            sum += x;
        }
        int best = -(int)1e9;
        for(int x : nums) {
            int except = sum - x - x;
            int cnt = map.getOrDefault(except, 0);
            if(except == x) {
                cnt--;
            }
            if(cnt > 0) {
                best = Math.max(best, except);
            }
        }
        return best;
    }
    public int smallestNumber(int n) {
        if (n == 1)
            return 1;

        for (int i=1; i<=10; i++)   {
            int temp = (int)(Math.pow(2, i)-1);
            if (temp >= n)
                return temp;
        }
        return -1;
    }
}
/*
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> graph1 = buildGraph(edges1);
        int n = edges1.length + 1;
        int[] cnt1 = new int[n];
        for (int from = 0; from < n; from++) {
            cnt1[from] = getNodesWithinK(graph1, from, k);
        }

        Map<Integer, List<Integer>> graph2 = buildGraph(edges2);
        int m = edges2.length + 1;
        int[] cnt2 = new int[m];
        int max = -1;
        for (int from = 0; from < m; from++) {
            cnt2[from] = getNodesWithinK(graph2, from, k-1);
            max = Math.max(max, cnt2[from]);
        };

        // System.out.println("cnt1: " + Arrays.toString(cnt1));
        // System.out.println("cnt2: " + Arrays.toString(cnt2));

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = cnt1[i] + max;
        }
        return res;
    }

    int getNodesWithinK (Map<Integer, List<Integer>> graph, int from, int k) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{from, -1});

        int cnt = 0;
        int layer = 0;
        while (!queue.isEmpty() && layer <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] arr = queue.poll();
                int curr = arr[0], parent = arr[1];
                for (int next : graph.get(curr)) {
                    if (next == parent) continue;
                    queue.offer(new int[]{next, curr});
                }
                cnt++;
            }
            layer++;
        }
        return cnt;
    }

    Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        int n = edges.length + 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        return graph;
    }
}
*/