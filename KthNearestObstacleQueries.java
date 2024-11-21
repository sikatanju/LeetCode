import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class KthNearestObstacleQueries {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int len = queries.length;
        int[] res = new int[len];

        for (int i=0; i<len; i++)   {
            var temp = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            queue.offer(temp);
            while (queue.size() > k)
                queue.poll();

            if (i+1 < k)
                res[i] = -1;
            else
                res[i] = queue.peek();
        }
        return res;
    }
}

/*
class Solution22 {
    public int[] resultsArray(int[][] queries, int k) {
        TreeSet<int[]> set = new TreeSet<>((i, j) -> {
            int x1 = i[0], y1 = i[1], x2 = j[0], y2 = j[1];
            long d1 = dis(x1, y1), d2 = dis(x2, y2);
            if (d1 == d2) {
                return x1 == x2 ? y1 < y2 ? -1 : 1 : x1 < x2 ? -1 : 1;
            }
            return d1 < d2 ? -1 : 1;
        });

        int[] ans = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int d = dis(q[0], q[1]);
            if (set.size() == k) {
                int[] t = set.last();
                if (d < dis(t[0], t[1])) {
                    set.pollLast();
                }
            }
            if (set.size() < k) {
                set.add(q);
            }
            if (set.size() == k) {
                int[] t = set.last();
                ans[i++] = dis(t[0], t[1]);
            } else {
                ans[i++] = -1;
            }
        }
        return ans;
    }
    int dis(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }
}
*/
/*
class SolutionQueries {
    class STNode {
        STNode left, right;
        long from, to, mid, sum;
        STNode(long from, long to) {
            this.from = from;
            this.to = to;
            mid = from + (to - from) / 2;
            sum = 0;
            left = null;
            right = null;
        }
        void add(long p, long x) {
            sum += x;
            if (from != to) {
                if (p <= mid) {
                    if (left == null)
                        left = new STNode(from, mid);
                    left.add(p, x);
                } else {
                    if (right == null)
                        right = new STNode(mid + 1, to);
                    right.add(p, x);
                }
            }
        }
        long getSum(long p, long q) {
            if (p == from && q == to)
                return sum;
            if (q <= mid)
                return left == null ? 0 : left.getSum(p, q);
            else if (p > mid)
                return right == null ? 0 : right.getSum(p, q);
            else {
                long a = left == null ? 0 : left.getSum(p, mid);
                long b = right == null ? 0 : right.getSum(mid + 1, q);
                return a + b;
            }
        }
    }
    public int[] resultsArray(int[][] qs, int k) {
        long MAX = 2000000000L;
        STNode root = new STNode(0, MAX);
        int n = qs.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            long x = Math.abs(qs[i][0]) + Math.abs(qs[i][1]);
            root.add(x, 1);
            if (root.getSum(0, MAX) < k)
                ans[i] = -1;
            else {
                long p = 0, q = MAX;
                while (p < q) {
                    long mid = p + (q - p) / 2;
                    if (root.getSum(0, mid) < k)
                        p = mid + 1;
                    else
                        q = mid;
                }
                ans[i] = (int)p;
            }
        }
        return ans;
    }
}
 */