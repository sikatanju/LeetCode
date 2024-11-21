import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        boolean[][] twoSec = new boolean[rows][cols];
        int[][] minTime = new int[rows][cols], dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int[] minRows: minTime)
            Arrays.fill(minRows, Integer.MAX_VALUE);

        minTime[0][0] = 0;
        minHeap.offer(new int[]{0, 0, 0, 1});
        while (!minHeap.isEmpty())  {
            int[] curr = minHeap.poll();
            int currX = curr[0], currY = curr[1], currTime = curr[2], currAdd = curr[3];

            if (currX == rows-1 && currY == cols-1)
                return currTime;

            for (int[] dir: dirs)   {
                int newX = currX + dir[0], newY = currY + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols)   {
                    int currWaitTime = Math.max(0, moveTime[newX][newY] - currTime);
                    int newWaitTime = currTime + currWaitTime + currAdd;

                    if (newWaitTime < minTime[newX][newY])  {
                        minTime[newX][newY] = newWaitTime;
                        twoSec[currX][currY] = !twoSec[currX][currY];
                        twoSec[newX][newY] = !twoSec[currX][currY];
                        minHeap.offer(new int[]{newX, newY, newWaitTime, currAdd == 1? 2: 1});
                    }
                }
            }
        }
        return -1;
    }
}

/* Fourth Best: 88ms:
class Solution {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minTimeToReach(int[][] moveTime) {
        // int[] -> curRow curCol step time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        int m = moveTime.length, n = moveTime[0].length;
        boolean[][][] visited = new boolean[m][n][3];
        pq.offer(new int[]{0, 0, 1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]][cur[1]][cur[2]]) {
                continue;
            }
            visited[cur[0]][cur[1]][cur[2]] = true;
            if (cur[0] == m - 1 && cur[1] == n - 1) {
                return cur[3];
            }
            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc][3 - cur[2]]) {
                    continue;
                }
                int taken = -1;
                if (cur[3] < moveTime[nr][nc]) {
                    taken = moveTime[nr][nc] + cur[2];
                } else {
                    taken = cur[2] + cur[3];
                }
                if (nr == m - 1 && nc == n - 1) {
                    return taken;
                }
                pq.offer(new int[]{nr, nc, 3 - cur[2], taken});
            }
        }
        throw new RuntimeException();
    }
}
 */