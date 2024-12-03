import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals.size() == 1 ? 1: 0;

        int len = intervals.size(), day = 0, count = 0;
        int[][] intervalls = new int[len][2];
        boolean[] visited = new boolean[len];
        for (var interval: intervals)   {
            intervalls[day][0] = interval.start;
            intervalls[day++][1] = interval.end;
        }
        Arrays.sort((intervalls), (a, b) -> a[0]-b[0]);
        day = 0;

        for (int i=0; i<len; i++)   {
            if (count == len)
                break;
            if (visited[i])
                continue;

            visited[i] = true;
            count++;
            int prevStart = intervalls[i][0], prevEnd = intervalls[i][1];
            day++;
            for (int j=i+1; j<len; j++) {
                if (visited[j])
                    continue;

                int currStart = intervalls[j][0], currEnd = intervalls[j][1];
                if (prevEnd <= currStart)   {
                    visited[j] = true;
                    count++;
                    prevStart = currStart;
                    prevEnd = currEnd;
                }
            }
        }
        return day;
    }
}
class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}