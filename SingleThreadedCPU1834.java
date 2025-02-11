import java.util.PriorityQueue;

public class SingleThreadedCPU1834 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1]-b[1]);
        PriorityQueue<int[]> taskHeap = new PriorityQueue<>((a, b) -> a[2]==b[2] ? a[0]-b[0] : a[2]-b[2]);

        int idx=0, currTime = 1, n = tasks.length, res[] = new int[n];

        for (int i=0; i<n; i++) {
            minHeap.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        currTime = minHeap.peek()[1];
        while (idx < n)   {
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= currTime)
                taskHeap.offer(minHeap.poll());

            if (!taskHeap.isEmpty())    {
                int[] temp = taskHeap.poll();
                res[idx++] = temp[0];
                currTime += temp[2];
            }   else {
                currTime = minHeap.peek()[1];
            }
        }
        return res;
    }
}


/* Best runtime: 88ms:
class Task {

    int startTime;
    int processTime;
    int index;

    Task(int startTime,int processTime,int index){
        this.startTime = startTime;
        this.processTime = processTime;
        this.index = index;
    }
}

class Solution {

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;
        int[] ans = new int[n];
        Task[] extTasks = new Task[n];  //extTasks : exist Tasks

        for(int i = 0;i < n;i++){
            extTasks[i] = new Task(tasks[i][0], tasks[i][1], i);
        }

        Arrays.sort(extTasks, new StartTime());
        PriorityQueue<Task> pq = new PriorityQueue<>(new Duration());

        int ai = 0;  //ai : answer index [will help to fill answer array]
        int idx = 0;  //ti : task index [ iterate over existing tasks,will help to know tasks pending]
        int currentTime = 0;

        while(ai < n){

            while(idx < n && extTasks[idx].startTime <= currentTime)
                     pq.add(extTasks[idx++]);


            if (pq.size() == 0){
                currentTime = extTasks[idx].startTime;
                continue;
            }

            Task bestFit = pq.remove();
            ans[ai++] = bestFit.index;
            currentTime += bestFit.processTime;
        }

        return ans;
    }

    public class StartTime implements Comparator<Task>{
        @Override
        public int compare(Task one,Task two){
            return one.startTime - two.startTime;
        }
    }

    public class Duration implements Comparator<Task>{
        @Override
        public int compare(Task one,Task two){

            if(one.processTime == two.processTime)
               return one.index - two.index;

            return one.processTime - two.processTime;
        }
    }

}
 */
/*
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1]-b[1]);
        PriorityQueue<int[]> taskHeap = new PriorityQueue<>((a, b) -> a[2]==b[2] ? a[0]-b[0] : a[2]-b[2]);

        int idx=0, currTime = 1, n = tasks.length, res[] = new int[n];

        for (int i=0; i<n; i++) {
            minHeap.offer(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        currTime = minHeap.peek()[1];
        while (idx < n)   {
            while (!minHeap.isEmpty() && minHeap.peek()[1] <= currTime)
                taskHeap.offer(minHeap.poll());

            if (!taskHeap.isEmpty())    {
                int[] temp = taskHeap.poll();
                res[idx++] = temp[0];
                currTime += temp[2];
            }   else {
                currTime = minHeap.peek()[1];
            }
        }

        return res;
    }
}
 */