import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1)
            return 0;

        int count = 0;
        Arrays.sort(intervals, Comparator.comparingInt((int[] row) -> row[0]).thenComparingInt(row->row[1]));

        int prev = intervals[0][1];

        for (int i=1; i<intervals.length; i++)  {
            int low = intervals[i][0], high = intervals[i][1];
            if (low >= prev)
                prev = high;

            else    {
                count++;
                prev = Math.min(prev, high);
            }
        }
        return count;
    }
}

/* 3ms runtime:
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max=intervals[0][1];
        int min=max;
        for(int[] i:intervals){
            max=Math.max(max, i[1]);
            min=Math.min(min, i[1]);
        }
        int shift=1-min, len=max-min+2;
        int[] inter=new int[len];
        for(int[] i:intervals){
            int l=i[0]+shift, r=i[1]+shift;
            if(l>inter[r])
                inter[r]=l;
        }
        int count=1, start=1;
        for(int i=2;i<len;i++){
            if(start<=inter[i]){
                count++;
                start=i;
            }
        }
        return intervals.length-count;
    }
}


######################### 4ms runtime :

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;

        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int shift = 1 - min;
        int maxIntervalRange = 2 + max - min;
        int[] rightEnds = new int[maxIntervalRange];

        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right]) {
                rightEnds[right] = left;
            }
        }

        int start = 1;
        int count = 1;

        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }

        return intervals.length - count;
    }
}



############## 5ms runtime:

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }

        int shift = 1 - min;
        int maxIntervalRange = 2 + max - min;
        int[] rightEnds = new int[maxIntervalRange];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (left > rightEnds[right])
                rightEnds[right] = left;
        }

        int start = 1;
        int count = 1;
        for (int i = 2; i < maxIntervalRange; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }

        return intervals.length - count;
    }
}
 */

