import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for (var ch: tasks) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }

        for (var key : map.keySet())
            heap.add(map.get(key));

        int totalUnitOfTime = 0;

        if (n==0)   {
            return tasks.length;
            // Updated from solution.
//            while (!heap.isEmpty())
//                totalUnitOfTime += heap.remove();
//
//            return totalUnitOfTime;
        }
        else {
            PriorityQueue<Integer> heap2 = new PriorityQueue<>(Comparator.reverseOrder());
            int coolDown = n+1;
            while (!heap.isEmpty()) {
                var temp = heap.remove();
                if (temp-1 != 0)
                    heap2.add(temp-1);

                coolDown--;
                totalUnitOfTime++;
                if (heap.isEmpty() && heap2.isEmpty())
                    break;

                if (coolDown == 0)  {
                    while(!heap.isEmpty())
                        heap2.add(heap.remove());

                    heap = heap2;
                    heap2 = new PriorityQueue<>(Comparator.reverseOrder());
                    coolDown = n+1;
                }
                else if (heap.isEmpty() && coolDown > 0){
                    while (coolDown > 0)    {
                        totalUnitOfTime++;
                        coolDown--;
                    }
                    heap = heap2;
                    heap2 = new PriorityQueue<>();
                    coolDown = n+1;
                }
            }
            return totalUnitOfTime;
        }
    }
}


/* Best Runtime : 1ms for Java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch: tasks)
            count[ch-'A']++;
        int max = 0;
        int C = 1;
        for (int i=0; i<26; i++) {
            if (count[i] == 0)
                continue;
            if (max < count[i]) {
                max = count[i];
                C = 1;
            }
            else if (count[i] == max)
                C++;
        }
        int space = ((n + 1) * (max - 1)) + C;
        return (space < tasks.length) ? tasks.length : space;
    }
}

############ 2ms runtime :
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks){
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxIdleTime = (freq[25] - 1) * n;
        for(int i = 24; i >= 0; i--){
            maxIdleTime -= Math.min(freq[25] - 1, freq[i]);
        }
        int idleTime = Math.max(maxIdleTime, 0);
        return tasks.length + idleTime;
    }
}
 */