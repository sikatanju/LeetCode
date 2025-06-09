import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfPointsFromGridQueries2503 {

    public int[] maxPoints(int[][] grid, int[] queries) {
        int r = grid.length, c = grid[0].length, k = queries.length, count = 0;
        int[][] query = new int[k][2];
        for (int i=0; i<k; i++) {
            query[i][0] = queries[i];
            query[i][1] = i;
        }
        Arrays.sort(query, (a, b) -> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        minHeap.add(new int[]{grid[0][0], 0, 0});
        int[] res = new int[k];
        boolean[][] visited = new boolean[r][c];
        for (int l=0; l<k; l++) {
            int num = query[l][0];
            while (!minHeap.isEmpty() && minHeap.peek()[0] < num)   {
                int[] arr = minHeap.remove();
                int i = arr[1], j = arr[2];
                if (visited[i][j])
                    continue;
                count++;
                visited[i][j] = true;
                if (i+1 < r && !visited[i+1][j])
                    minHeap.add(new int[]{grid[i+1][j], i+1, j});
                if (i-1 > -1 && !visited[i-1][j])
                    minHeap.add(new int[]{grid[i-1][j], i-1, j});
                if (j+1 < c && !visited[i][j+1])
                    minHeap.add(new int[]{grid[i][j+1], i, j+1});
                if (j-1 > -1 && !visited[i][j-1])
                    minHeap.add(new int[]{grid[i][j-1], i, j-1});
            }
            res[query[l][1]] = count;
        }
        return res;
    }
}