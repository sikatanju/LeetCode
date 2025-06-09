//import java.util.*;
public class CourseSchedule {
/* Khan's Algorithm (Topological Sort):
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i=0; i<numCourses; i++)
            adjList.add(new ArrayList<>());

        int[] inDegrees = new int[numCourses];
        for (int[] edge: prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i=0; i<numCourses; i++)    {
            if (inDegrees[i] == 0)
                queue.offer(i);
        }

        int idx = 0;
        while (!queue.isEmpty())    {
            int node = queue.poll();
            idx++;
            for (var num: adjList.get(node))    {
                inDegrees[num]--;
                if (inDegrees[num] == 0)
                    queue.offer(num);
            }
        }
        return idx == numCourses;
    }
*/
}

/* Myone:
    private class Node  {
        private int node;
        public Node()   {}
        public Node(int node)   {
            this.node = node;
        }
    }

    private Map<Integer, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    private void addNode(int num)   {
        var node = new Node(num);
        nodes.putIfAbsent(num, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    private void addEdge(int from, int to)   {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        adjacencyList.get(fromNode).add(toNode);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i=0; i<prerequisites.length; i++)  {
            for (int j=0; j<1; j++) {
                addNode(prerequisites[i][j]);
                addNode(prerequisites[i][j+1]);
                addEdge(prerequisites[i][j], prerequisites[i][j+1]);
            }
        }


        return hasCycle() ? false : true;
    }

    private boolean hasCycle()   {
        Set<Node> all = new HashSet<>();
        all.addAll(nodes.values());

        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        while (!all.isEmpty())  {
            // var current = all.toArray()[0];
            var current = all.iterator().next();
            if (hasCycle((Node)current, all, visited, visiting))
                return true;
        }
        return false;
    }
    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visited, Set<Node> visiting)    {
        all.remove(node);
        visiting.add(node);
        for (var neighbour: adjacencyList.get(node))    {
            if (visited.contains(neighbour))
                continue;
            if (visiting.contains(neighbour))
                return true;
            if (hasCycle(neighbour, all, visited, visiting))
                return true;
        }
        visiting.remove(node);
        visited.add(node);
        return false;
    }
 */
/* Best Runtime : 1ms :

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0){
            return true;
        }
        int[]course = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            course[prerequisites[i][1]]++;
        }
        boolean[] visited = new boolean[prerequisites.length];
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i=0;i<prerequisites.length;i++){
                if(!visited[i]){
                    if(course[prerequisites[i][0]]==0){
                        visited[i]=true;
                        course[prerequisites[i][1]]--;
                        flag = true;
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(course[i]!=0){
                return false;
            }
        }
        return true;
    }
}


################## 2ms runtime :

enum State { kInit, kVisiting, kVisited }

class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    List<Integer>[] graph = new List[numCourses];
    State[] states = new State[numCourses];

    for (int i = 0; i < numCourses; ++i)
      graph[i] = new ArrayList<>();

    for (int[] prerequisite : prerequisites) {
      final int u = prerequisite[1];
      final int v = prerequisite[0];
      graph[u].add(v);
    }

    for (int i = 0; i < numCourses; ++i)
      if (hasCycle(graph, i, states))
        return false;

    return true;
  }

  private boolean hasCycle(List<Integer>[] graph, int u, State[] states) {
    if (states[u] == State.kVisiting)
      return true;
    if (states[u] == State.kVisited)
      return false;

    states[u] = State.kVisiting;
    for (final int v : graph[u])
      if (hasCycle(graph, v, states))
        return true;
    states[u] = State.kVisited;

    return false;
  }
}


############### 3ms runtime :

class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}

 */