import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        int min = intervals[0][0];
        int max = intervals[0][1];

        for (int i=1; i<intervals.length; i++)  {
            if (intervals[i][0] <= max) {
                if (max < intervals[i][1])
                    max = intervals[i][1];
            }
            else {
                list.add(new int[]{min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        list.add(new int[] {min, max});
        return list.toArray(new int[0][]);
    }
}

/*
***** Runtime : 1ms
class Solution {
    public int[][] merge(int[][] intervals) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < intervals.length; i++) {
			min = Math.min(min, intervals[i][0]);
			max = Math.max(max, intervals[i][0]);
		}

		int[] range = new int[max - min + 1];
		for (int i = 0; i < intervals.length; i++) {
			range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
		}

		int start = 0, end = 0;
		LinkedList<int[]> result = new LinkedList<>();
		for (int i = 0; i < range.length; i++) {
			if (range[i] == 0) {
				continue;
			}
			if (i <= end) {
				end = Math.max(range[i], end);
			} else {
				result.add(new int[] {start + min, end + min});
				start = i;
				end = range[i];
			}
		}
		result.add(new int[] {start + min, end + min});
		return result.toArray(new int[result.size()][]);
	}
}

* ************************ Runtime : 2 ms
class Solution {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for(int[] interval : intervals) {
            max = Math.max(max, interval[1]);
        }
        int[] open = new int[max + 1];
        int[] close = new int[max + 1];
        for(int[] interval : intervals) {
            for(int i=interval[0];i<=interval[1];i++) {
                open[interval[0]]++; // opening [
                close[interval[1]]++;//  closing ]
            }

        }
        int nestedLevel = 0;
        // System.out.println(Arrays.stream(merged).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        ArrayList<int[]> result = new ArrayList<>();
        int[] lastRange = new int[2];
        for(int i=0;i<open.length;i++) {
            if (nestedLevel == 0 && nestedLevel + open[i] > 0) {
                lastRange[0] = i;
            }
            nestedLevel += open[i];
            if (nestedLevel > 0 && nestedLevel - close[i] == 0) {
                 lastRange[1] = i;
                result.add(lastRange);
                lastRange = new int[2];
            }
            nestedLevel -= close[i];
        }
        return result.toArray(new int[][] {});
    }
}
*
* ****** Runtime : 3ms ************************
class Solution {
    void qsort (int[][] aa) {
        int l, r, i, j, med, medVal, stn = 0;
        int[] tmp, stack = new int[aa.length + 1];
        //int[] stack = new int[aa.length + 1];
        stack[stn++] = aa.length - 1;
        stack[stn++] = 0;
        while (stn != 0) {
            l = stack[--stn];
            r = stack[--stn];
            i = l - 1; j = r + 1;
            med = (i + j + 1)/2; medVal = (aa[med][0] << 14) + aa[med][1];
            while (true) {
                while ((aa[++i][0] << 14) + aa[i][1] < medVal);
                while ((aa[--j][0] << 14) + aa[j][1] > medVal);
                //while (aa[++i] < medVal);
                //while (aa[--j] > medVal);
                //System.out.println("i= " + i + " j= " + j);
                if (i >= j) break;
                tmp = aa[i];
                aa[i] = aa[j];
                aa[j] = tmp;
            }
            if (r > i) {
                stack[stn++] = r;
                stack[stn++] = i;
            }
            if (l < --i) {
                stack[stn++] = i;
                stack[stn++] = l;
            }
            //System.out.println(Arrays.toString(aa));
        }
    }
    public int[][] merge(int[][] intervals) {
        qsort(intervals);
        //int[] arr = {0,0,0,-1,0,0};
        //qsort(arr);
        //System.out.println("FIN: " + Arrays.toString(arr));
        // for (int[] ar : intervals) System.out.println("FIN1: " + Arrays.toString(ar));
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            //System.out.println("itv[" + i + "]: " + Arrays.toString(intervals[i]));
            //System.out.println("itv[" + j + "]: " + Arrays.toString(intervals[j]));
            if (intervals[i][0] <= intervals[j][1]) {   //System.out.println("YES1");
                if (intervals[i][1] > intervals[j][1])
                //{  System.out.println("YES2");
                    intervals[j][1] = intervals[i][1];
                //}
            } else //{
                //System.out.println("NO1");
                intervals[++j] = intervals[i];
            //}
        }
        int[][] ans = new int[j + 1][];
        for (int i = 0; i <= j; i++) ans[i] = intervals[i];
        //System.out.println("FIN2: " + Arrays.toString(ar));
        return ans;
    }
}
*/