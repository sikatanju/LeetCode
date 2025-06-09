// From weekly contest 410:

/*
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfGoodNodes {
    private int goodNodes;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length;
        this.goodNodes = 0;
        List<List<Integer>> adj = new ArrayList<>(n);

        for (int i=0; i<=n; i++)
            adj.add(new ArrayList<>());

        for (int i=0; i<n; i++) {
            int from = edges[i][0], to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        dfs(0, -1, adj);
        return this.goodNodes;
    }

    private int dfs(int node, int parent, List<List<Integer>> adj)  {
        int totalNode = 1;
        Set<Integer> set = new HashSet<>();

        for (int curr: adj.get(node))   {
            if (curr != parent) {
                int cnt = dfs(curr, node, adj);
                totalNode += cnt;
                set.add(cnt);
            }
        }
        if (set.size() <= 1)
            this.goodNodes++;

        return totalNode;
    }
}
*/
/* Best runtime: 11ms:
class Solution {
    public int countGoodNodes(int[][] edges) {

        int m = edges.length, n = edges.length + 1;
		int[] treeCount = new int[n];
        int[] subTreeNodes = new int[n];
        int[] parents = new int[n];

        int ans = n;
        for (int i = 1; i <n; i++)
            parents[i] = i;

        parents[0] = -1;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parents[u] != u)
                parents[v] = u;
            else
                parents[u] = v;
        }

        for (int i = m - 1; i >= 0; i--) {

            int u = edges[i][0], v = edges[i][1];
            int parent, child;

            if (v == 0 || parents[u] == v) {
                parent = v;
                child = u;
            } else {
                parent = u;
                child = v;
            }

            if (subTreeNodes[parent] == 0) {
                subTreeNodes[parent] = treeCount[child] + 1;
            } else if (subTreeNodes[parent] != -1 && subTreeNodes[parent] != treeCount[child] + 1) {
                ans--;
                subTreeNodes[parent] = -1;
            }

            treeCount[parent] += treeCount[child] + 1;
        }

        return ans;
    }
}
 */
