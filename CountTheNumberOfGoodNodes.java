// From weekly contest 410:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfGoodNodes {
    private int count;
    public int countGoodNodes(int[][] edges) {
        this.count = 0;
        ArrayList<Integer>[] adjList = new ArrayList[edges.length+1];
        for (int i=0; i<= edges.length; i++)
            adjList[i] = new ArrayList<>();

        for (int[] edge: edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        dfs(0, edges.length+1, adjList);
        return this.count;
    }

    private int dfs(int node, int parent, ArrayList<Integer>[] adjList)   {
        int total = 1;
        Set<Integer> set = new HashSet<>();
        for (int con_node: adjList[node])   {
            if (con_node != parent) {
                int count = dfs(con_node, node, adjList);
                total += count;
                set.add(count);
            }
        }
        if (set.size() <= 1)
            this.count++;

        return total;
    }
}


