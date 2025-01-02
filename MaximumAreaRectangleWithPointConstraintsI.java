import java.util.*;

public class MaximumAreaRectangleWithPointConstraintsI {
    public int maxRectangleArea(int[][] points) {
        Set<String> set = new HashSet<>();
        for (int[] p: points)
            set.add(p[0]+"/"+p[1]);

        int len = points.length, maxArea = -1;
        for (int i=0; i<len; i++)   {
            for (int j=i+1; j<len; j++) {
                for (int k=j+1; k<len; k++) {
                    for (int l=k+1; l<len; l++) {
                        int x1 = points[i][0], y1 = points[i][1];
                        int x2 = points[j][0], y2 = points[j][1];
                        int x3 = points[k][0], y3 = points[k][1];
                        int x4 = points[l][0], y4 = points[l][1];

                        int minX = Math.min(Math.min(x1, x2), Math.min(x3, x4));
                        int maxX = Math.max(Math.max(x1, x2), Math.max(x3, x4));

                        int minY = Math.min(Math.min(y1, y2), Math.min(y3, y4));
                        int maxY = Math.max(Math.max(y1, y2), Math.max(y3, y4));

                        if (set.contains(minX+"/"+minY) && set.contains(minX+"/"+maxY) && set.contains(maxX+"/"+minY) && set.contains(maxX+"/"+maxY))   {
                            var valid = true;
                            for (int[] point: points)   {
                                int x = point[0], y = point[1];
                                if (x >= minX && x <= maxX && y >= minY && y <= maxY)   {
                                    if (!(x == minX && y == minY) && !(x == minX && y == maxY) && !(x == maxX && y == minY) && !(x == maxX && y == maxY))  {
                                        valid = false;
                                        break;
                                    }
                                }
                            }
                            if (valid) {
                                maxArea = Math.max(maxArea, (maxX - minX) * (maxY - minY));
                            }
                        }
                    }
                }
            }
        }
        return maxArea;
    }
}

/*
class Solution {
public int maxRectangleArea(int[][] points) {
        Set<String> set = new HashSet<>();
        int n = points.length;
        int maxArea = -1;

        for (int[] p : points)
            set.add(p[0] + "," + p[1]);

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        int x1 = points[i][0], y1 = points[i][1];
                        int x2 = points[j][0], y2 = points[j][1];
                        int x3 = points[k][0], y3 = points[k][1];
                        int x4 = points[l][0], y4 = points[l][1];

                        int minX = Math.min(Math.min(x1,x2),Math.min(x3,x4));
                        int minY = Math.min(Math.min(y1,y2),Math.min(y3,y4));

                        int maxX = Math.max(Math.max(x1,x2),Math.max(x3,x4));
                        int maxY = Math.max(Math.max(y1,y2),Math.max(y3,y4));

                        if (maxX==minX || maxY==minY)
                            continue;

                        if (set.contains(minX+","+minY) && set.contains(minX+","+maxY) &&
                                set.contains(maxX+","+minY) && set.contains(maxX+","+maxY)) {
                            boolean valid = true;
                            for (int[] p : points) {
                                if (p[0]>=minX && p[0]<=maxX && p[1]>=minY && p[1]<=maxY) {

                                    if (!(p[0]==minX && p[1]==minY) && !(p[0]==minX && p[1]==maxY) &&
                                            !(p[0]==maxX && p[1]==minY) && !(p[0]==maxX && p[1]==maxY)) {

                                        valid = false; break;
                                    }
                                }
                            }
                            if (valid) {
                                int area = (maxX - minX)*(maxY - minY);
                                maxArea = Math.max(maxArea, area);
                            }
                        }
                    }
                }
            }
        }
        return maxArea;
    }
}
 */