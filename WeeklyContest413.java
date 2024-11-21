import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class WeeklyContest413 {
    public int maxScore(List<List<Integer>> grid) {
        int maxSoFar = -1;
        int rowLen = grid.size(), columnLen = grid.get(0).size();
        int[][] dp = new int[rowLen][columnLen];
        for (int i=0; i<columnLen; i++) {
            dp[0][i] = grid.get(0).get(i);
        }

        for (int i=1; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                int current = grid.get(i).get(j);
                int r = i-1;
                maxSoFar = -1;
                for (int k=0; k<columnLen; k++)  {

                    if (k != j) {
                        maxSoFar = Math.max(current+grid.get(r).get(k), maxSoFar);
                    }
                }
                dp[i][j] = maxSoFar;
            }
        }
        maxSoFar = -1;
        for (int i=0; i<columnLen; i++)
            maxSoFar = Math.max(dp[rowLen-1][i], maxSoFar);

        return maxSoFar;
    }

    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = queries.length;
        int[] res = new int[len];
        int kk = 1;

        for (int i=0; i<len; i++)   {
            int temp = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            queue.offer(temp);
            if (i+1 >= k)   {
                PriorityQueue<Integer> tempQueue = new PriorityQueue<>();
                int index = 0, num = 0;
                while (index < k)   {
                    num = queue.poll();
                    tempQueue.offer(num);
                    index++;
                }
                while (queue.size() > 0)    {
                    tempQueue.offer(queue.poll());
                }
                queue = tempQueue;
                res[i] = num;
            }   else {
                res[i] = -1;
            }
        }
        return res;
    }
//    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
//        Set<Character> set1 = new HashSet<>();
//        set1.add('a');
//        set1.add('c');
//        set1.add('e');
//        set1.add('g');
//
//        Set<Character> set2 = new HashSet<>();
//        set2.add('b');
//        set2.add('d');
//        set2.add('f');
//        set2.add('h');
//
//        char ch1 = coordinate1.charAt(0), ch2 = coordinate2.charAt(0);
//        int num1 = Integer.parseInt(""+coordinate1.charAt(1)), num2 = Integer.parseInt(""+coordinate2.charAt(1));
//        int isWhite1 = 0, isWhite2 =  0;
//
//        if (set1.contains(ch1)) {
//            if (num1 % 2 == 0)  {
//                isWhite1 = 1;
//            }
//        }   else {
//            if (num1 % 2 != 0)  {
//                isWhite1 = 1;
//            }
//        }
//        if (set1.contains(ch2)) {
//            if (num2 % 2 == 0)  {
//                isWhite2 = 1;
//            }
//        }   else {
//            if (num2 % 2 != 0)  {
//                isWhite2 = 1;
//            }
//        }
//
//        return isWhite1 == isWhite2;
//    }

}


// import java.util.*;
// import java.util.function.*;

// public class Main {
//     public static void main(String[] args) throws Exception {
//         System.out.println(new Solution().solve());
//     }
// }

//class Solution {
//    public int[] resultsArray(int[][] queries, int k) {
//        int n = queries.length;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        int[] ans = new int[n];
//        Arrays.fill(ans, -1);
//        for (int i = 0; i < n; i++) {
//            pq.add(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
//            while (pq.size() > k)
//                pq.poll();
//            if (pq.size() == k)
//                ans[i] = pq.peek();
//        }
//
//        return ans;
//    }
//}