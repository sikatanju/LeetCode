import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length, totalCapital = w, index=0;
        int[][] projects = new int[len][2];

        for (int i=0; i<len; i++)    {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        while (k-- > 0) {
            while (index < len && projects[index][0] <= totalCapital)    {
                queue.add(projects[index++][1]);
            }
            if (queue.isEmpty())
                break;

            totalCapital += queue.poll();
        }
        return totalCapital;
    }
}


/* Best runtime : 9ms

class Solution {
    public int findMaximizedCapital(int numProjects, int initCap, int[] profits, int[] capital) {

        int cap = initCap;

		if (numProjects > profits.length) {
			numProjects = profits.length;
		}

		int highestCap = 0;

		for (int x = 0; x < capital.length; x++) {
			highestCap = capital[x] > highestCap ? capital[x] : highestCap;
		}

		int projectsDone = 0;
		boolean tooPoor = false;

		for (int x = 0; x < numProjects; x++) {
			if (cap >= highestCap) {
				break;
			}

			int tempIndex = -1;
			int tempMaxCap = -1;

			for (int i = 0; i < capital.length; i++) {
				 if ((cap >= capital[i]) && (profits[i] > tempMaxCap)) {
						 tempMaxCap = profits[i];
						 tempIndex = i;
				 }
			}

			if (tempIndex != -1) {
				cap += tempMaxCap;
				profits[tempIndex] = -1;
				projectsDone++;
			} else {
				tooPoor = true;
				break;
			}
		}

		int remainingProjects = numProjects - projectsDone;

		if ( (!tooPoor) && (remainingProjects > 0) ) {

			Arrays.sort(profits);

			int lowIndex = profits.length - remainingProjects;
			for (int idx = profits.length -1; idx >= lowIndex; idx--) {
				cap += profits[idx];
			}
		}

		return cap;
    }
}
 */

/* Second Best: 15ms :
class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int maxCapital = 0;
        for (int i = 0; i < Capital.length; i++) {
            maxCapital = Math.max(Capital[i], maxCapital);
        }

        if (W >= maxCapital) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
            for (int p : Profits) {
                maxHeap.add(p);
                if (maxHeap.size() > k) maxHeap.poll();
            }
            for (int h : maxHeap) W += h;
            return W;
        }

        int index;
        int n = Profits.length;
        for (int i = 0; i < Math.min(k, n); i++) {
            index = -1;
            for (int j = 0; j < n; ++j) {
                if (W >= Capital[j] && (index == -1 || Profits[index] < Profits[j])) {
                    index = j;
                }
            }
            if (index == -1) break;
            W += Profits[index];
            Capital[index] = Integer.MAX_VALUE;
        }
        return W;
    }
}
 */