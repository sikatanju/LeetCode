import java.lang.reflect.Array;
import java.util.Arrays;

public class RedundantConnection {
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        this.parent = new int[len+1];
        this.rank = new int[len+1];

        for (int i=0; i<=len; i++)  {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);

        for (int i=0; i<=len; i++)  {
            if (!union(edges[i][0], edges[i][1]))
                return edges[i];
        }
        return edges[0];
    }
    private int find(int n) {
        int p = parent[n];
        while (p != parent[p])  {
            p = parent[p];
        }
        return p;
    }
    private boolean union(int n1, int n2)   {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2)
            return false;
        if (rank[p1] > rank[p2])    {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }   else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
