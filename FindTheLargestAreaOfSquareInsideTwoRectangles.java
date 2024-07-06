public class FindTheLargestAreaOfSquareInsideTwoRectangles {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long largestSquare = 0;
        for (int i=0; i<bottomLeft.length; i++) {
            for (int j=i+1; j<bottomLeft.length; j++) {
                int firstLeftX = bottomLeft[i][0];
                int firstLeftY = bottomLeft[i][1];
                int firstRightX = topRight[i][0];
                int firstRightY = topRight[i][1];

                int secondLeftX = bottomLeft[j][0];
                int secondLeftY = bottomLeft[j][1];
                int secondRightX = topRight[j][0];
                int secondRightY = topRight[j][1];

                int leftX = Math.max(firstLeftX, secondLeftX);
                int leftY = Math.max(firstLeftY, secondLeftY);
                int rightX = Math.min(firstRightX, secondRightX);
                int rightY = Math.min(firstRightY, secondRightY);

                if (leftX < rightX && leftY < rightY)   {
                    long length = Math.min(rightX-leftX, rightY-leftY);
                    largestSquare = Math.max(largestSquare, length*length);
                }
            }
        }
        return largestSquare;
    }
}

/* Best runtime : 4ms :

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long maxArea = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            long minSide = Math.min(topRight[i][0] - bottomLeft[i][0], topRight[i][1] - bottomLeft[i][1]);
            if (maxArea > minSide * minSide) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                long minSide1 = Math.min(topRight[j][0] - bottomLeft[j][0], topRight[j][1] - bottomLeft[j][1]);
                if (maxArea > minSide1 * minSide1) {
                    continue;
                }
                long area = getArea(bottomLeft[i], topRight[i], bottomLeft[j], topRight[j]);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    private long getArea(int[] bl1, int[] tr1, int[] bl2, int[] tr2) {
        int [] bl = new int[2];
        int [] tr = new int[2];
        bl[0] = Math.max(bl1[0], bl2[0]);
        bl[1] = Math.max(bl1[1], bl2[1]);
        tr[0] = Math.min(tr1[0], tr2[0]);
        tr[1] = Math.min(tr1[1], tr2[1]);

        if (bl[0] < tr[0] && bl[1] < tr[1]) {
            // System.out.println(bl[0] + " - " + bl[1] + ", " + tr[0] + " - " + tr[1]);
            int min = tr[0] - bl[0];
            min = Math.min(tr[1] - bl[1], min);
            return (long) min * min;
        }
        return 0;
    }
}

############### 5ms runtime :
class Solution {
  public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
    int minSide = 0;
    for (int i = 0; i < bottomLeft.length; ++i)
      for (int j = i + 1; j < bottomLeft.length; ++j) {
        final int ax1 = bottomLeft[i][0];
        final int ay1 = bottomLeft[i][1];
        final int ax2 = topRight[i][0];
        final int ay2 = topRight[i][1];
        final int bx1 = bottomLeft[j][0];
        final int by1 = bottomLeft[j][1];
        final int bx2 = topRight[j][0];
        final int by2 = topRight[j][1];
        final int overlapX = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        final int overlapY = Math.min(ay2, by2) - Math.max(ay1, by1);
        minSide = Math.max(minSide, Math.min(overlapX, overlapY));
      }
    return (long) minSide * minSide;
  }
}
 */