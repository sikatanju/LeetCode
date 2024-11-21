import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int len = edges.length;
        if (len > n-1)
            return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++)   {
            adj.add(new ArrayList<>());
        }
        for (int[] row: edges)  {
            int from = row[0], to = row[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Set<Integer> set = new HashSet<>();
        return dfs(0, set, adj, -1) && set.size() == n;
    }
    private boolean dfs(int i, Set<Integer> visited, List<List<Integer>> list, int prev)    {
        if (visited.contains(i))
            return false;

        visited.add(i);
        for (int num: list.get(i))    {
            if (num == prev)
                continue;

            if (!dfs(num, visited, list, i))
                return false;
        }
        return true;
    }
}


/*
class UnionFind{
    private int[] father;
    private int count;
    public UnionFind(int n) {
        father = new int[n];
        count = n;
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
        if(father[x]==x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void connect(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if(rootA!=rootB) {
            father[rootA] = rootB;
            count--;
        }
    }
}

public class Solution {
public boolean validTree(int n, int[][] edges) {
    // write your code here
    if(n<=0 || edges==null) {
        return false;
    }
    if(edges.length!=n-1) {
        return false;
    }
    UnionFind uf = new UnionFind(n);
    for(int[] edge : edges) {
        int num1 = edge[0];
        int num2 = edge[1];
        uf.connect(num1, num2);
    }
    return uf.getCount()==1;
}
}
 */