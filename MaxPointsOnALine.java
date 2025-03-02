import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3)
            return len;

        int maxLine = 0;
        for (int i=0; i<len; i++)
            maxLine = Math.max(maxLine, getMaxLine(points[i][0], points[i][1], i+1, points, len));

        return maxLine;
    }

    private int getMaxLine(int x1, int y1, int j, int[][] points, int len)  {
        Map<Double, int[]> lines = new HashMap<>(len-j+1, 0.95f);
        int max = 2;
        for (; j<len; j++)  {
            int x2 = points[j][0], y2 = points[j][1];
            Double slope = ((y2 == y1) ? 0.0 : (x2 == x1) ? Double.POSITIVE_INFINITY : (double)(y2-y1)/(x2-x1));
            var line = lines.get(slope);
            if (line == null)
                lines.put(slope, new int[]{2});
            else
                max = Math.max(max, ++line[0]);
        }
        return max;
    }
}

/* Best runtime : 3ms :

    class Solution { //ref 4ms
        public int maxPoints(int[][] points) {
            int len=points.length;
            if (len<=2) {
                return len;
            }
            int max=2;
            for (int i=0; i<len; i++) {
                max = Math.max(max, getMax(points[i][0], points[i][1], i+1, points, len));
            }
            return max;
        }

        private int getMax(int x1, int y1, int j, int[][] points, int len) {
            int max=2;
            Map<Double, int[]> lines=new HashMap<>(len-j+1, .95f);
            for ( ; j<len; j++) {
                Double slope = (points[j][1] == y1 ) ? 0.0 : ( points[j][0] == x1 ) ? Double.POSITIVE_INFINITY : (double)(points[j][1]- y1 )/( points[j][0]-x1);
                int[] line = lines.get(slope);
                if (line == null) {
                    lines.put(slope, new int[]{2});
                } else {
                    max=Math.max(max, ++line[0]);
                }
            }
            return max;
        }
    }
    public int maxPoints(int[][] points) {
            int len=points.length;
            if (len<=2) {
                return len;
            }
            int max=2;
            for (int i=0; i<len; i++) {
                max=Math.max(max, getMax(points[i][0], points[i][1], i+1, points, len));
            }
            return max;
        }

        private int getMax(int x, int y, int j, int[][] points, int len) {
            int max=2;
            Map<Double, int[]> lines=new HashMap<>(len-j+1, .95f);
            for ( ; j<len; j++) {
                Double slope=(points[j][1]==y) ? 0.0 : (points[j][0]==x) ? Double.POSITIVE_INFINITY : (double)(points[j][1]-y)/(points[j][0]-x);
                int[] count = lines.get(slope);
                if (count==null) {
                    lines.put(slope, new int[] {2});
                } else {
                    max=Math.max(max, ++count[0]);
                }
            }
            return max;
        }
    }

* */




/* Solution that I followed:
class Solution {
    // This method returns the maximum number of points that lie on the same line
    // given a set of points represented by the 2D array points
    public int maxPoints(int[][] points) {
        // n is the number of points in the array
        int n = points.length;

        // If there are 0 or 1 points, there is at most one line that can be formed
        // (i.e., the line formed by the single point, or no line if there are no points)
        if(n <= 2) return n;

        // Initialize the maximum number of points on a line to 2, since there must be at least 2 points to form a line
        int ans = 2;

        // Iterate through all pairs of points
        for(int i = 0 ;i < n; i++){
            for(int j = i+1; j < n ; j++){
                // temp is the number of points on the line formed by point i and point j
                int temp = 2;
                // Check if any other points are on the same line as point i and point j
                for(int k = j+1 ; k<n ; k++ ){
                    // Check if point k is on the same line as point i and point j
                    // This is done by checking if the slope between point i and point k is equal to the slope between point i and point j
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);
                    if(x == y){
                        // If the slopes are equal, point k is on the same line as point i and point j
                        temp++;
                    }
                }
                // Update the maximum number of points on a line if necessary
                if(temp > ans){
                    ans = temp;
                }
            }
        }
        // Return the maximum number of points on a line
        return ans;
    }
}
 */