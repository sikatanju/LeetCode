import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0 || intervals == null)
            return true;

        int[][] intervalss = new int[intervals.size()][2];
        int i=0;
        for (var temp: intervals)   {
            intervalss[i][0] = temp.start;
            intervalss[i++][1] = temp.end;
        }
        Arrays.sort(intervalss, (a, b) -> a[0]-b[0]);
        for ( i=1; i<intervalss.length; i++) {
            if (intervalss[i-1][1] > intervalss[i][0])
                return false;
        }
        return true;
    }
    private class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/*
class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
 */
/* Another approach:

    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            Interval A = intervals.get(i);
            for (int j = i + 1; j < n; j++) {
                Interval B = intervals.get(j);
                if (Math.min(A.end, B.end) > Math.max(A.start, B.start)) {
                    return false;
                }
            }
        }
        return true;
    }
 */