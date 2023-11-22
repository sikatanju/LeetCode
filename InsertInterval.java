import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ara = new ArrayList<>();

        for (var interval: intervals)  {
            if (newInterval[1] < interval[0])   {
                ara.add(newInterval);
                newInterval = interval;
            }
            else if (interval[1] < newInterval[0])  {
                int[] temp = new int[2];
                temp[0] = interval[0];
                temp[1] = interval[1];
                ara.add(temp);
            }
            else    {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        ara.add(newInterval);
        return ara.toArray(new int[ara.size()][]);
    }
}


/*
        if (intervals.length == 0)  {
            int[][] temp = new int[1][2];
            temp[0][0] = newInterval[0];
            temp[0][1] = newInterval[1];
            return temp;
        }
        List<int[]> arrays = new ArrayList<>();

        int low = newInterval[0];
        int high = newInterval[1];
        int intervalsLen = intervals.length;

        int[] temp = new int[2];
        int[] firstAra = new int[2];
        int[] secondAra = new int[2];

        boolean isFirstAraFull = false;
        boolean isSecondAraFull = false;
        boolean isIntervalMergeDone = false;

        int i=0, j=0;
        for (; i<intervalsLen; i++) {
            if (low > intervals[i][1] && i+1 < intervalsLen && low >= intervals[i+1][0])  {
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                arrays.add(temp);
            }
            else if (low < intervals[i][1] && high > intervals[i][1] && i == intervalsLen-1)   {
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = high;
                arrays.add(temp);
            }
            else if (low > intervals[i][0] && high < intervals[i][1])   {
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
                arrays.add(temp);
            }
            else if (low < intervals[i][1] && i+1 < intervalsLen && high < intervals[i+1][0] && !isFirstAraFull && !isSecondAraFull)    {
                temp = new int[2];
                temp[0] = intervals[i][0];
                temp[1] = newInterval[1];
                arrays.add(temp);
                i++;
                break;
            }
            else  if (low <= intervals[i][1] && !isFirstAraFull)   {
                firstAra[0] = intervals[i][0];
                firstAra[1] = intervals[i][1];
                isFirstAraFull = true;
            }
            else  if (high <= intervals[i][1] && !isSecondAraFull)   {
                secondAra[0] = intervals[i][0];
                secondAra[1] = intervals[i][1];
                isSecondAraFull = true;
            }
            else if (i == intervalsLen-1 && !isIntervalMergeDone)    {
                if (isFirstAraFull) {
                    temp = new int[2];
                    temp[0] = firstAra[0];
                    temp[1] = newInterval[1];
                    arrays.add(temp);
                }
                else if (!isFirstAraFull && !isSecondAraFull)    {
                    temp = new int[2];
                    temp[0] = intervals[i][0];
                    temp[1] = newInterval[1];
                    arrays.add(temp);
                }
            }
            if (isFirstAraFull && isSecondAraFull && !isIntervalMergeDone)  {
                temp = new int[2];
                temp[0] = firstAra[0];
                temp[1] = secondAra[1];
                arrays.add(temp);
                isIntervalMergeDone = true;
                i++;
                break;
            }
        }
        int len = intervalsLen-i;
        len += arrays.size();

        int[][] newIntervals = new int[len][2];

        for (; j<arrays.size(); j++)   {
            temp = new int[2];
            var ara = arrays.get(j);
            newIntervals[j][0] = ara[0];
            newIntervals[j][1] = ara[1];
        }

        if (i<intervalsLen) {
            for (; i<intervalsLen; i++, j++) {
                newIntervals[j][0] = intervals[i][0];
                newIntervals[j][1] = intervals[i][1];
            }
        }
        return newIntervals;
    }
 */