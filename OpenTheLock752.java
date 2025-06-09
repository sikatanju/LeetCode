import java.util.*;

public class OpenTheLock752 {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();
        for (var str: deadends)
            visited.add(str);

        if (visited.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        visited.add("0000");
        queue.add("0000");
        int cnt = 0;
        while(!queue.isEmpty()) {
            cnt++;
            queue2 = queue;
            queue = new ArrayDeque<>();

            while (!queue2.isEmpty())   {
                String str = queue2.poll();
                List<String> strs = getStrs(str);
                for (var temp: strs)    {
                    if (temp.equals(target))
                        return cnt;

                    if (!visited.contains(temp))    {
                        queue.add(temp);
                        visited.add(temp);
                    }
                }
            }
        }
        return -1;
    }

    private List<String> getStrs(String str)    {
        List<String> strs = new ArrayList<>();
        char[] chrs = str.toCharArray();
        for(int i=0; i<4; i++)  {
            if (chrs[i] == '0' || chrs[i] == '9') {
                if (chrs[i] == '0')  {
                    chrs[i] = '1';
                    strs.add(String.valueOf(chrs));
                    chrs[i] = '0';
                    chrs[i] = '9';
                    strs.add(String.valueOf(chrs));
                    chrs[i] = '0';
                }   else    {
                    chrs[i] = '0';
                    strs.add(String.valueOf(chrs));
                    chrs[i] = '9';
                    chrs[i] = '8';
                    strs.add(String.valueOf(chrs));
                    chrs[i] = '9';
                }
            }
            else    {
                chrs[i] = (char)(chrs[i]+1);
                strs.add(String.valueOf(chrs));
                chrs[i] = (char)(chrs[i]-1);
                chrs[i] = (char)(chrs[i]-1);
                strs.add(String.valueOf(chrs));
                chrs[i] = (char)(chrs[i]+1);
            }
        }
        return strs;
    }
}
/* Best runtime: 5ms:
import java.util.*;

public class Solution {
    private static final int DEADEND = 2;
    private static final int NOT_VISITED = 0;

    public int openLock(String[] deadends, String target) {
        int[] pow10 = { 1, 10, 100, 1000 };
        int[] visit = new int[10000];

        // 标记 deadends
        for (String dead : deadends) {
            visit[Integer.parseInt(dead)] = DEADEND;
        }

        int start = 0;
        int end = Integer.parseInt(target);
        if (visit[start] == DEADEND || visit[end] == DEADEND) return -1;
        if (start == end) return 0;

        // 使用 Deque 代替 LinkedList，提高性能
        Deque<Integer> forward = new ArrayDeque<>();
        Deque<Integer> backward = new ArrayDeque<>();

        forward.offerLast(start);
        visit[start] = 1;
        backward.offerLast(end);
        visit[end] = -1;

        int steps = 0, visitingDirection = 1;

        while (!forward.isEmpty() && !backward.isEmpty()) {
            // 总是扩展更小的队列
            if (forward.size() > backward.size()) {
                Deque<Integer> tmp = forward;
                forward = backward;
                backward = tmp;
                visitingDirection = -visitingDirection;
            }

            steps++;
            int size = forward.size();
            while (size-- > 0) {
                int current = forward.pollFirst();
                int result = processNeighbors(current, pow10, visit, forward, visitingDirection, steps);
                if (result != -1) return result;
            }
        }
        return -1;
    }

    private int processNeighbors(int current, int[] pow10, int[] visit, Deque<Integer> forward, int visitingDirection, int steps) {
        for (int pow : pow10) {
            int digit = (current / pow) % 10;
            for (int i = -1; i <= 1; i += 2) {
                int newDigit = (digit + i + 10) % 10;  // 处理 0-9 循环
                int next = current + (newDigit - digit) * pow;

                if (visit[next] == -visitingDirection) return steps; // 相遇，返回最短步数
                if (visit[next] == NOT_VISITED) {
                    forward.offerLast(next);
                    visit[next] = visitingDirection;
                }
            }
        }
        return -1;
    }
}

 */
/* NeetCode Solution:
public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if (visit.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visit.add("0000");

        int turns = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String lock = queue.poll();
                if (lock.equals(target)) return turns;

                for (String next : children(lock)) {
                    if (!visit.contains(next)) {
                        queue.offer(next);
                        visit.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }

    private List<String> children(String lock) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' + 1) % 10) + '0');
            res.add(new String(arr));

            arr = lock.toCharArray();
            arr[i] = (char) (((arr[i] - '0' - 1 + 10) % 10) + '0');
            res.add(new String(arr));
        }
        return res;
    }
}
 */

/* Solution from AlgoMonster:
class Solution {
    private String startCombination; // Start combination for the lock
    private String targetCombination; // Target combination to unlock
    private Set<String> deadEnds = new HashSet<>(); // Set to store deadends

    // Method to find the minimum number of moves to open the lock
    public int openLock(String[] deadends, String target) {
        startCombination = "0000";
        this.targetCombination = target;

        // Add all deadends to the set
        Collections.addAll(this.deadEnds, deadends);

        // If the starting point is a deadend, we cannot proceed
        if (this.deadEnds.contains(startCombination)) {
            return -1;
        }

        // If target is startCombination return 0 as no steps required
        if (target.equals(startCombination)) {
            return 0;
        }

        // Use bidirectional BFS to find the shortest path
        return bidirectionalBfs();
    }

    // Helper method to perform bidirectional BFS search on the lock combinations
    private int bidirectionalBfs() {
        Map<String, Integer> visitedFromStart = new HashMap<>(); // Record steps from start
        Map<String, Integer> visitedFromTarget = new HashMap<>(); // Record steps from target
        Deque<String> queueFromStart = new ArrayDeque<>(); // Queue for BFS from start
        Deque<String> queueFromTarget = new ArrayDeque<>(); // Queue for BFS from target

        // Initialize the BFS from both ends
        visitedFromStart.put(startCombination, 0);
        visitedFromTarget.put(targetCombination, 0);
        queueFromStart.offer(startCombination);
        queueFromTarget.offer(targetCombination);

        while (!queueFromStart.isEmpty() && !queueFromTarget.isEmpty()) {
            // Always extend the smaller queue to optimize performance
            int turns = queueFromStart.size() <= queueFromTarget.size() ?
                        extendQueue(visitedFromStart, visitedFromTarget, queueFromStart) :
                        extendQueue(visitedFromTarget, visitedFromStart, queueFromTarget);

            // If turns not equals to -1, a solution has been found
            if (turns != -1) {
                return turns;
            }
        }
        return -1; // If no solution is found
    }

    // Expand the current level of the BFS search and check for intersections
    private int extendQueue(Map<String, Integer> currentVisited, Map<String, Integer> oppositeVisited, Deque<String> currentQueue) {
        int currentSize = currentQueue.size();
        for (int i = 0; i < currentSize; ++i) {
            String currentCombination = currentQueue.poll();
            int currentStepCount = currentVisited.get(currentCombination);

            // Evaluate next possible combinations
            for (String nextCombination : getNextCombinations(currentCombination)) {
                // Skip if visited or is a dead end
                if (currentVisited.containsKey(nextCombination) || deadEnds.contains(nextCombination)) {
                    continue;
                }

                // If this combination has been reached from the opposite direction, return the total move count
                if (oppositeVisited.containsKey(nextCombination)) {
                    return currentStepCount + 1 + oppositeVisited.get(nextCombination);
                }

                // Record the step count and add the new combination to the queue
                currentVisited.put(nextCombination, currentStepCount + 1);
                currentQueue.offer(nextCombination);
            }
        }
        return -1;
    }

    // Generate all next possible lock combinations from a given combination
    private List<String> getNextCombinations(String combination) {
        List<String> nextCombinations = new ArrayList<>();
        char[] chars = combination.toCharArray();

        for (int i = 0; i < 4; ++i) {
            char originalChar = chars[i];

            // Turn the wheel one step forward
            chars[i] = originalChar == '9' ? '0' : (char) (originalChar + 1);
            nextCombinations.add(new String(chars));

            // Turn the wheel one step backwards
            chars[i] = originalChar == '0' ? '9' : (char) (originalChar - 1);
            nextCombinations.add(new String(chars));

            // Restore the original state for the next iteration
            chars[i] = originalChar;
        }

        return nextCombinations;
    }
}
 */