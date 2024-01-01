import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((index1, index2) ->  {
            return distance(points[index2]) - distance(points[index1]);
        });
        for (int i=0; i<points.length; i++) {
            priorityQueue.add(i);
            if (priorityQueue.size() > k)
                priorityQueue.remove();
        }
        int[][] newAra = new int[k][2];
        int i=0;
        while (!priorityQueue.isEmpty())    {
            int index = priorityQueue.remove();
            newAra[i][0] = points[index][0];
            newAra[i++][1] = points[index][1];
        }
        return newAra;
    }

    private int distance(int[] p)   {
        return p[0] * p[0] + p[1] * p[1];
    }
}

/* Best runtime : 3ms :
// points = [[3,3],[5,-1],[-2,4]], k = 2
// 18,26,20
//

//quick select, 每次选valid的一半sort
// K Closest Points to Origin => find k smallest -> [0, k + 1) -> find k + 1 th
// return: array -> Arrays.copyOf(arr, len) -> [0, len) -> [0, k + 1)



public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //cc
        quick_select(points, 0, points.length - 1, k - 1);
        return Arrays.copyOf(points, k);
    }
    private void quick_select(int[][]p, int l, int r, int k){
        if(l >= r) return;
        int[] x = p[r + l >> 1];
        int i = l - 1, j = r + 1;
        while(i < j){
            while(getDist(p[++i]) < getDist(x));
            while(getDist(p[--j]) > getDist(x));
            if(i < j){
                int[] temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
        if(j == k) return;
        else if(j > k) quick_select(p, l, j, k);
        else quick_select(p, j + 1, r, k);
    }
    private int getDist(int[] p){
        return p[0]*p[0] + p[1]*p[1]; //p[0]^2 is incorrect, ^ is bitwise XOR operation
    }
}

/*
	public static void main(String[] args) {
		int[][] arr = new int[][] {
			{0,1},
			{1,2},
			{-1,0},
			{-1,-2},
			{3,8},
			{0,0}
		};
		Solution sol = new Solution();
		int[][] res = sol.kClosest(arr, 4);
		for(int[] x : res) {
			System.out.print("[" + Integer.toString(x[0]) + ",");
			System.out.print(Integer.toString(x[1]) +"]");
			System.out.println();
		}
	}
*/

//###################
/* Another good runtime example : 0(n) : 5ms :
// Time:  O(n)
// Space: O(1)
class Solution {
    private class Pair {
        long dist;
        int idx;
        public Pair(long dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            int[] point = points[i];
            long dist = point[0] * point[0] + point[1] * point[1];
            arr[i] = new Pair(dist, i);
        }

        long kthDist = quickSelect(arr, 0, n - 1, k);

        // Generate results.
        int[][] ret = new int[k][2];
        int count = 0;
        for (Pair x : arr) {
            if (x.dist <= kthDist) {
                ret[count++] = points[x.idx];
            }
            if (count == k) break;
        }

        return ret;
    }

    private long quickSelect(Pair[] arr, int a, int b, int k) {
        long pivot = arr[a + (b - a) / 2].dist;

        int i = a, t = a, j = b;

        // SPPLL
        //     b
        // a
        //  i
        //   j
        while (t <= j) {
            if (arr[t].dist < pivot) {
                swap(arr, t, i);
                t++;
                i++;
            } else if (arr[t].dist > pivot) {
                swap(arr, t, j);
                j--;
            } else {
                t++;
            }
        }

        if (k <= i - a) {
            return quickSelect(arr, a, i - 1, k);
        } else if (k <= j - a + 1) {
            return pivot;
        } else {
            return quickSelect(arr, j + 1, b, k - (j - a + 1));
        }
    }

    private void swap(Pair[] arr, int a, int b) {
        Pair temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
*/

/* Another solution :
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(K == points.length) return points;

        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });

        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > K) pq.poll();
        }
        return pq.toArray(new int[0][0]);
    }
}
 */

/* Mine : Wrong answer due to duplicate value like : (2, 2), (-2, 2), (2, -2)
    public int[][] kClosest(int[][] points, int k) {
        int pointsLen = points.length;
        if (pointsLen == k)
            return points;

        PriorityQueue<Double> heap = new PriorityQueue<>();
        Map<Double, Integer> map = new HashMap<>();
        Map<Double, Integer> map2 = new HashMap<>();

        for (int i=0; i<pointsLen; i++) {
            double temp = Math.pow(points[i][0], 2);
            temp += Math.pow(points[i][1], 2);
            temp = Math.sqrt(temp);
            heap.add(temp);
            if (!map.containsKey(temp))
                map.put(temp, i);
            else
                map2.put(temp, i);
        }

        int[][] newAra = new int[k][2];
        int i=0;

        while (k-- > 0) {
            double temp = heap.remove();
            int index = 1;
            if (map.containsKey(temp))  {
                index = map.get(temp);
                map.remove(temp);
            }
            else
                index = map2.get(temp);

            newAra[i][0] = points[index][0];
            newAra[i++][1] = points[index][1];
        }

        return newAra;
    }

 */