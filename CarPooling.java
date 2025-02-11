import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int i = 0, j = 0, n = trips.length, currPass = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2]-b[2]);
        while (j<n) {
            while (j < n && currPass+trips[j][0] <= capacity)    {
                queue.add(new int[]{trips[j][0], trips[j][2], trips[j][2]});
                currPass += trips[j][0];
                j++;
            }
            if (j == n)
                return true;

            int size = queue.size();
            while (!queue.isEmpty() && trips[j][1] >= queue.peek()[1]) {
                currPass -= queue.poll()[0];
            }
            if (queue.size() == size)
                return false;
        }
        return true;
    }
}
