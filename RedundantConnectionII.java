public class RedundantConnectionII {
/*
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] arr1 = {-1, -1}, arr2 = {-1, -1};
        int n = edges.length;
        int[] root = new int[n+1];

        for (int[] edge: edges) {
            int parent = edge[0], child = edge[1];
            if (root[child] == 0)   {
                root[child] = parent;
            }   else    {
                arr1 = new int[]{parent, child};
                arr2 = new int[]{root[child], child};
                edge[1] = 0;
            }
        }
        for (int i=0; i<=n; i++)
            root[i] = i;

        for (int[] edge: edges) {
            int child = edge[1], parent = edge[0];
            if (child == 0)
                continue;

            int rootParent = findRoot(root, parent);
            if (rootParent == child)    {
                if (arr2[0] == -1)
                    return edge;
                else
                    return arr2;
            }
            root[child] = parent;
        }
        return arr1;
    }

    private int findRoot(int[] root, int node)  {
        int parent = node;
        while (parent != root[parent])
            parent = root[parent];

        while (node != parent)  {
            int next = root[node];
            root[node] = parent;
            node = next;
        }
        return parent;
    }
 */
}

/* Best runtime: 0ms (mine is 1ms):
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] extraEdge = new int[2];
        for (int[] e: edges) {
            if (parent[e[1]] != 0) extraEdge = e;
            else parent[e[1]] = e[0];
        }
        if (extraEdge[0] == 0) {
            boolean[] visited = new boolean[edges.length+1];
            for (int[] edge: edges) {
                if (visited[edge[0]] && visited[edge[1]]) return edge;
                visited[edge[0]] = true;
                visited[edge[1]] = true;
            }
        }
        for (int current = extraEdge[1]; current != 0; current = parent[current]) {
            if (parent[current] == extraEdge[1]) return new int[] { parent[extraEdge[1]], extraEdge[1]};
        }
        return extraEdge;
    }
}

 */