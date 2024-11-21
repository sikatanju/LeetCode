import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestDistanceAfterRoadAdditionQueriesI {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries)   {
        ArrayList<Integer>[] list = new ArrayList[n-1];
        int[] temp = new int[n], res = new int[queries.length];
        for (int i=0; i<n; i++) {
            if (i != n-1)
                list[i] = new ArrayList<>(List.of(i+1));

            temp[i] = i;
        }
        for (int i=0; i<queries.length; i++)  {
            int current = queries[i][0];
            int next = queries[i][1];

            list[current].add(next);
            ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(List.of(current));

            while (!arrayDeque.isEmpty())   {
                int tt = arrayDeque.poll();
                if (tt == n-1)
                    break;

                for (int t: list[tt])   {
                    if (temp[t] > temp[tt]+1)   {
                        temp[t] = temp[tt]+1;
                        arrayDeque.add(t);
                    }
                }
                res[i] = temp[n-1];
            }
        }
        return res;
    }

    public int[] shortestDistanceAfterQueriess(int n, int[][] queries) {
        ArrayList<Integer>[] list = new ArrayList[n - 1];
        int[] d = new int[n], result = new int[queries.length];
        for (int i = 1; i < n; i++) {
            list[i-1] = new ArrayList<>(List.of(i));
            d[i] = i;
        }

        for (int i = 0; i < queries.length; i++) {
            int current = queries[i][0], next = queries[i][1];
            list[current].add(next);
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.add(current);
            while (!queue.isEmpty()) {
                int k = queue.poll();
                if (k == n - 1) {
                    break;
                }
                for (int j : list[k]) {
                    if (d[k] + 1 < d[j]) {
                        d[j] = d[k] + 1;
                        queue.offer(j);
                    }
                }
            }
            result[i] = d[n - 1];
        }
        return result;
    }
}

/* Best runtime:
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = n - i - 1;
        }

        ArrayList<Integer> adj[] = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            adj[i].add(i - 1);
        }

        int ans[] = new int[queries.length];

        int i = 0;

        for (int q[] : queries) {

            adj[q[1]].add(q[0]);

            update(adj, q[0], q[1], arr);

            ans[i++] = arr[0];

        }

        return ans;

    }

    void update(ArrayList<Integer> adj[], int u, int v, int arr[]) {

        if (arr[u] <= arr[v] + 1) {
            return;
        }

        arr[u] = arr[v] + 1;

        for (int to : adj[u]) {
            update(adj, to, u, arr);
        }

    }

}
 */

// Second Best runtime: 18ms:
class SolutionSDARAQ {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        int[]res=new int[queries.length];
        int k=0;
        for(int i=0;i<n-1;i++){
            graph.get(i).add(i+1);
        }
        int[]distance=new int[n];
        for(int i=0;i<n;i++)
            distance[i]=i;

        for(int i=0;i<queries.length;i++)   {
            graph.get(queries[i][0]).add(queries[i][1]);
            if(queries[i][1]==n-1)  {
                if(distance[queries[i][0]]+1 < distance[n-1])
                    distance[n-1]=distance[queries[i][0]]+1;
            }
            else    {
                if(distance[queries[i][0]]+1<distance[queries[i][1]])distance[queries[i][1]]=distance[queries[i][0]]+1;

                int value=bfs(queries[i][1],n-1,graph,n,distance);
                // System.out.println(value);
                // System.out.println(Arrays.toString(distance));
                if(value<distance[n-1])distance[n-1]=value;
            }
            res[k++]=distance[n-1];
        }
         return res;
    }
    private int bfs(int start, int end, ArrayList<ArrayList<Integer>> graph, int n,int[]dist) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // dist[start] = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return dist[end];
    }
}