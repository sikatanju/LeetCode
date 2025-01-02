import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int len1 = edges1.length, len2 = edges2.length;
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            int from = edges1[i][0], to = edges1[i][1];
            map1.computeIfAbsent(from, j -> new ArrayList<>()).add(to);
            map1.computeIfAbsent(to, j -> new ArrayList<>()).add(from);
        }
        for (int i=0; i<len2; i++)    {
            int from = edges2[i][0], to = edges2[i][1];
            map2.computeIfAbsent(from, j -> new ArrayList<>()).add(to);
            map2.computeIfAbsent(to, j -> new ArrayList<>()).add(from);
        }
        int[] count1 = new int[len1+1], count2 = new int[len2+1];
        for (int i=0; i<=len1; i++)  {
            count1[i] = countNodes(map1, i, k);
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<=len2; i++) {
            max = Math.max(countNodes(map2, i, k-1), max);
        }
        for (int i=0; i<=len1; i++)
            count1[i] += max;

        return count1;
    }

    private int countNodes(Map<Integer, List<Integer>> map, int from, int k)   {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{from, -1});
        int count = 0, depth = 0;
        while (!queue.isEmpty() && depth <= k)  {
            int size = queue.size();
            for (int i=0; i<size; i++)  {
                int[] curr = queue.poll();
                int currNode = curr[0], parentNode = curr[1];
                for (int nextNode: map.get(currNode))   {
                    if (nextNode == parentNode)
                        continue;

                    queue.offer(new int[]{nextNode, currNode});
                }
                count++;
            }
            depth++;
        }

        return count;
    }
}
/* uwi solution: around 102ms I guess:
	class Solution {
		int[] ds(int s, int[][] g) {
			int[][] ps = parents(g, s);
			return ps[2];
		}


		public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {

			int n = edges1.length + 1;
			int[][] g1 = packU(n, edges1);
			int m = edges2.length + 1;
			int[][] g2 = packU(m, edges2);

			int[] ans = new int[n];
			for(int i = 0;i < n;i++){
				int[] ds = ds(i, g1);
				for(int j = 0;j < n;j++){
					if(ds[j] <= k){
						ans[i]++;
					}
				}
			}

			int max = 0;
			for(int i = 0;i < m;i++){
				int[] ds = ds(i, g2);
				int num = 0;
				for(int j = 0;j < m;j++){
					if(ds[j] <= k-1){
						num++;
					}
				}
				max = Math.max(max, num);
			}
			for(int i = 0;i < n;i++){
				ans[i] += max;
			}
			return ans;
		}

		public static int[][] parents(int[][] g, int root) {
			int n = g.length;
			int[] par = new int[n];
			Arrays.fill(par, -1);

			int[] depth = new int[n];
			depth[0] = 0;

			int[] q = new int[n];
			q[0] = root;
			for (int p = 0, r = 1; p < r; p++) {
				int cur = q[p];
				for (int nex : g[cur]) {
					if (par[cur] != nex) {
						q[r++] = nex;
						par[nex] = cur;
						depth[nex] = depth[cur] + 1;
					}
				}
			}
			return new int[][]{par, q, depth};
		}

		public static int[][] packU(int n, int[][] ft)
		{
			int[][] g = new int[n][];
			int[] p = new int[n];
			for(int[] u : ft){
				p[u[0]]++; p[u[1]]++;
			}
			for(int i = 0;i < n;i++)g[i] = new int[p[i]];
			for(int[] u : ft){
				g[u[0]][--p[u[0]]] = u[1];
				g[u[1]][--p[u[1]]] = u[0];
			}
			return g;
		}


	}
 */
/* Best runtime: 33ms:
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        int[] parent1 = findParent(edges1);
        int[] parent2 = findParent(edges2);
        List<Integer>[] graph1 = buildGraph(parent1, edges1);
        List<Integer>[] graph2 = buildGraph(parent2, edges2);
        int[] indeg1 = leafToRootIndeg(parent1, edges1);
        int[] indeg2 = leafToRootIndeg(parent2, edges2);
        int[][] dp1 = new int[n][k + 1];
        leafToRootTopologicalSort(indeg1, parent1, dp1, k);
        int[][] dp2 = new int[m][k + 1];
        leafToRootTopologicalSort(indeg2, parent2, dp2, k);
        indeg1 = rootToLeafIndeg(parent1, edges1);
        indeg2 = rootToLeafIndeg(parent2, edges2);
        rootToLeafTopologicalSort(indeg1, parent1, graph1, dp1, k);
        rootToLeafTopologicalSort(indeg2, parent2, graph2, dp2, k);
        int maxTree2 = 0;

        for (int i = 0; i < m; i++) {
            int total = 0;

            for (int j = 0; j < k; j++) {
                total += dp2[i][j];
            }

            maxTree2 = Math.max(maxTree2, total);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int total = 0;

            for (int j = 0; j <= k; j++) {
                total += dp1[i][j];
            }

            total += maxTree2;
            answer[i] = total;
        }

        return answer;
    }

    private void rootToLeafTopologicalSort(int[] indeg, int[] parent, List<Integer>[] graph,
                                            int[][] dp, int k) {
        int len = parent.length;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int p = parent[node];

            if (node != p && k > 0) {
                int first = 0;
                int second = dp[node][0];

                for (int i = 1; i <= k; i++) {
                    int temp = dp[node][i];
                    dp[node][i] += dp[p][i - 1] - first;
                    first = second;
                    second = temp;
                }
            }

            for (int child : graph[node]) {
                indeg[child]--;

                if (indeg[child] == 0) {
                    queue.add(child);
                }
            }
        }
    }

    private void leafToRootTopologicalSort(int[] indeg, int[] parent, int[][] dp, int k) {
        int len = parent.length;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int p = parent[node];
            dp[node][0] = 1;

            if (node == p) {
                continue;
            }

            for (int i = 0; i < k && dp[node][i] > 0; i++) {
                dp[p][i + 1] += dp[node][i];
            }

            indeg[p]--;

            if (indeg[p] == 0) {
                queue.add(p);
            }
        }
    }

    private int[] leafToRootIndeg(int[] parent, int[][] edges) {
        int len = parent.length;
        int[] indeg = new int[len];

        for (int[] edge : edges) {
            if (parent[edge[1]] == edge[0]) {
                indeg[edge[0]]++;
            } else {
                indeg[edge[1]]++;
            }
        }

        return indeg;
    }

    private int[] rootToLeafIndeg(int[] parent, int[][] edges) {
        int len = parent.length;
        int[] indeg = new int[len];

        for (int[] edge : edges) {
            if (parent[edge[1]] == edge[0]) {
                indeg[edge[1]]++;
            } else {
                indeg[edge[0]]++;
            }
        }

        return indeg;
    }

    private List<Integer>[] buildGraph(int[] parent, int[][] edges) {
        int len = edges.length + 1;
        List<Integer>[] graph = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            if (parent[edge[1]] == edge[0]) {
                graph[edge[0]].add(edge[1]);
            } else {
                graph[edge[1]].add(edge[0]);
            }
        }

        return graph;
    }

    private int[] findParent(int[][] edges) {
        int len = edges.length + 1;
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        parent[0] = 0;

        for (int[] edge : edges) {
            if (parent[edge[1]] == -1) {
                parent[edge[1]] = edge[0];
            } else {
                parent[edge[0]] = edge[1];
            }
        }

        return parent;
    }
}
 */