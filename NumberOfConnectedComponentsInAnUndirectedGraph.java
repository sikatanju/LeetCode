import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            int from = edge[0], to = edge[1];
            list.get(from).add(to);
            list.get(to).add(from);
        }
        for (int i=0; i<n; i++) {
            if (!visited[i])    {
                dfs(i, visited, list);
                count++;
            }
        }
        return count;
    }
    private void dfs(int curr, boolean[] visited, List<List<Integer>> list) {
        if (visited[curr])
            return;

        visited[curr] = true;
        for (int num: list.get(curr))   {
            if (!visited[num])  {
                dfs(num, visited, list);
            }
        }
    }
}
