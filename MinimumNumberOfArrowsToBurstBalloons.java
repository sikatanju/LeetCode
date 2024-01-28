import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int numOfArrows = 1;
        int arrowPosition = points[0][1];
        for (int i=1; i<points.length; i++) {
            if (arrowPosition >= points[i][0])
                continue;

            numOfArrows++;
            arrowPosition = points[i][1];
        }
        return numOfArrows;
    }
}
