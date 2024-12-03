import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for (int q: Arrays.stream(queries).sorted().toArray())  {
            while (i < intervals.length && intervals[i][0] <= q)
                minHeap.offer(new int[]{intervals[i][1]-intervals[i][0]+1, intervals[i++][1]});

            while (!minHeap.isEmpty() && minHeap.peek()[1] < q)
                minHeap.poll();

            map.put(q, minHeap.isEmpty() ? -1: minHeap.peek()[0]);
        }
        int[] res = new int[queries.length];
        for (i=0; i<queries.length; i++)    {
            res[i] = map.get(queries[i]);
        }
        return res;
    }
}

/* Best runtime: 79ms:
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> map= new HashMap<>();
        Arrays.sort(intervals, (x,y)-> (x[0]-y[0]));
        int arr[]= new int[queries.length], i=0;
        PriorityQueue<int[]> pq= new PriorityQueue<>((x, y)->((x[1]-x[0])-(y[1]-y[0])));
        for(int j=0; j<arr.length; j++) arr[j]=queries[j];
        Arrays.sort(arr);
        for(int q : arr){
            while(i < intervals.length && intervals[i][0]<=q){
                pq.offer(intervals[i++]);
            }
            while(pq.size()!=0 && pq.peek()[1]<q){
                pq.poll();
            }
            map.put(q, (pq.size()==0 ? -1 : pq.peek()[1]-pq.peek()[0]+1));
        }
        for(i=0; i<queries.length; i++){
            queries[i]= map.get(queries[i]);
        }
        return queries;
    }
}
 */