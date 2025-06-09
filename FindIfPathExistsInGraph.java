public class FindIfPathExistsInGraph {
/*
    class UnionFind {
        private int size;
        private int[] parent;

        public UnionFind(int size)  {
            this.size = size;
            this.parent = new int[size];
            for (int i=0; i<size; i++)
                parent[i] = i;
        }

        private int find (int p)  {
            int root = p;
            while (root != parent[root])  {
                root = parent[root];
            }

            while (p != root) {
                int next = parent[p];
                parent[p] = root;
                p = next;
            }

            return root;
        }
        public void unify(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);

            if (root1 == root2)
                return;

            parent[root1] = root2;
            return;
        }
        public boolean isConnected(int p, int q)  {
            return find(p) == find(q);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind obj = new UnionFind(n);
        for (int[] arr: edges)
            obj.unify(arr[0], arr[1]);

        return obj.isConnected(source, destination);
    }
*/
}

/* Best runtime: 5ms:
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 200000 && edges.length != 2){
            return true;
        }
        if (edges.length == 0){
            return true;
        }
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
        while(flag){
            flag = false;
            for(int[] edge : edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if(visited[destination]){
                    return true;
                }
            }
        }
        return false;
    }
}
 */