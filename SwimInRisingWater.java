import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int rowLen = grid.length, columnLen = grid[0].length;
        if (rowLen == 1 && columnLen == 1)
            return grid[0][0];

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        int maxCost = 0;
        boolean[][] visited = new boolean[rowLen][columnLen];
        visited[0][0] = true;

        while (!minHeap.isEmpty())  {
            int[] curr = minHeap.poll();
            int i = curr[1], j = curr[2], currCost = curr[0];
            maxCost = Math.max(maxCost, currCost);
            if (i == rowLen-1 && j == columnLen-1)
                break;

            if (i+1 < rowLen && !visited[i+1][j])   {
                minHeap.offer(new int[]{grid[i+1][j], i+1, j});
                visited[i+1][j] = true;
            }
            if (j+1 < columnLen && !visited[i][j+1])    {
                minHeap.offer(new int[]{grid[i][j+1], i, j+1});
                visited[i][j+1] = true;
            }
            if (i-1 >= 0 && !visited[i-1][j])   {
                minHeap.offer(new int[]{grid[i-1][j], i-1, j});
                visited[i-1][j] = true;
            }
            if (j-1 >= 0 && !visited[i][j-1])   {
                minHeap.offer(new int[]{grid[i][j-1], i, j-1});
                visited[i][j-1] = true;
            }
        }
        return maxCost;
    }
}

/* Best runtime: 0ms:
class Solution {
  int len;
final static int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

public int swimInWater(int[][] grid) {
    len = grid.length;
    int left = Math.max(grid[0][0], grid[len - 1][len - 1]), right = len * len - 1, mid, res = 0;
    while (left <= right) {
        mid = (left + right) / 2;
        boolean[] seen = new boolean[len * len];
        if (dfs(0, 0, grid, mid, seen)) {
            res = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return res;
}
public boolean dfs(int xn, int yn, int[][] grid, int mid, boolean[] seen) {
    int idx = xn * len + yn;
    if (seen[idx]) return true;
    seen[idx] = true;
    for (int i = 0; i < 4; i++) {
        int newx = xn + dirs[i][0], newy = yn + dirs[i][1];
        if (newx >= 0 && newx < len && newy >= 0
                && newy < len && !seen[newx * len + newy] && grid[newx][newy] <= mid) {
            if (newx == len - 1 && newy == len - 1) {
                return true;
            }
            if (dfs(newx, newy, grid, mid, seen)) {
                return true;
            }
        }
    }
    return false;
}
}
 */

/* Second best: 1ms:
class Solution {
    private int N;
    private int[] ROW_DIRECTIONS = new int[]{0, 1, 0, -1};
    private int[] COL_DIRECTIONS = new int[]{1, 0, -1, 0};
    private boolean[][] visited;
    public int swimInWater(int[][] g) {
        this.N = g.length;
        int l = Math.max(g[0][0], g[N - 1][N - 1]);
        int r = N * N - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            this.visited = new boolean[N][N];
            if(dfs(g, 0, 0, m)) r = m;
            else l = m + 1;
        }
        return l;
    }
    private boolean dfs(int[][] g, int r, int c, int T) {
        if(r < 0 || c < 0 || r >= N || c >= N || visited[r][c] || g[r][c] > T) return false;
        visited[r][c] = true;
        if(r == N - 1 && c == N - 1) return true;
        for(int i = 0; i < 4; ++i)
            if(dfs(g,  r + ROW_DIRECTIONS[i], c + COL_DIRECTIONS[i], T))
                return true;
        return false;
    }
}

// class Solution {
//     public int swimInWater(int[][] g) {
//         int N = g.length - 1;
//         int[] ROW_DIRECTIONS = new int[]{0, 1, 0, -1};
//         int[] COL_DIRECTIONS = new int[]{1, 0, -1, 0};
//         Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
//         pq.offer(new int[]{g[0][0], 0, 0});
//         while(!pq.isEmpty()) {
//             int[] cur = pq.poll();
//             if(cur[1] == N && cur[2] == N) return Math.abs(cur[0]);
//             for(int i = 0; i < 4; ++i) {
//                 int r = cur[1] + ROW_DIRECTIONS[i];
//                 int c = cur[2] + COL_DIRECTIONS[i];
//                 if(r >= 0 && r <= N && c >= 0 && c <= N && g[r][c] > -1) {
//                     pq.offer(new int[]{Math.max(g[r][c], Math.abs(cur[0])), r, c});
//                     g[r][c] *= -1;
//                 }
//             }
//         }
//         return -1;
//     }
// }
 */