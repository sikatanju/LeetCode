import java.util.*;

public class CourseScheduleII {
    private class Node  {
        private int value;
        public Node(int value) {
            this.value = value;
        }
    }

    private Map<Integer, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void addNode(int num)    {
        var node = new Node(num);
        nodes.putIfAbsent(num, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(int from, int to)   {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);
        if (fromNode == null || toNode == null)
            throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
    }

    private int[] topologicalSort()  {
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();

        for (var node: nodes.values())
            topologicalSort(node, set, stack);

        int[]  ara = new int[stack.size()];

        int index = stack.size()-1;
        while (index >= 0)
            ara[index--] = stack.pop().value;

        return ara;
    }

    private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack)   {
        if (visited.contains(node))
            return;

        visited.add(node);
        for (var neighbour: adjacencyList.get(node))
            topologicalSort(neighbour, visited, stack);

        stack.push(node);
    }

    public boolean hasCycle()   {
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0)  {
            int temp = numCourses;
            int[] ara = new int[numCourses--];
            for (int i=0; i<temp; i++)
                ara[i] = numCourses--;

            return ara;
        }

        for (int i=0; i<prerequisites.length; i++)    {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (!nodes.containsKey(from))   {
                var node = new Node(from);
                nodes.put(from, node);
                adjacencyList.put(node, new ArrayList<>());
            }
            if (!nodes.containsKey(to)) {
                var node = new Node(to);
                nodes.put(to, node);
                adjacencyList.put(node, new ArrayList<>());
            }
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);
            adjacencyList.get(fromNode).add(toNode);
        }
        if (hasCycle())
            return new int[]{};

        var ara = topologicalSort();
        if (numCourses > ara.length)    {
            Set<Integer> set = new HashSet<>();
            int[] newAra = new int[numCourses--];
            int i=numCourses, j = ara.length-1;
            while (i>=0)    {
                if (j>=0)   {
                    set.add(ara[j]);
                    newAra[i--] = ara[j--];
                }
                else if (!set.contains(numCourses)) {
                    newAra[i--] = numCourses--;
                }
                else
                    numCourses--;
            }
            return newAra;
        }
        return ara;
    }
}

/* Bestruntime : 1ms :

class Solution {
    private int top;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        top = numCourses - 1;

        int[] postList = new int[numCourses];
        int[] nextIndex = new int[prerequisites.length];
        int[] nextNode = new int[prerequisites.length];

        for(int i = 0; i < numCourses; i++){
            postList[i] = -1;
        }

        int index = 0;
        for(int[] prerequisite : prerequisites) {
            nextIndex[index] = postList[prerequisite[1]];
            nextNode[index] = prerequisite[0];
            postList[prerequisite[1]] = index;
            index++;
        }

        int[] stack = new int[numCourses];
        int[] visited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(0 == visited[i]){
                if(!DFS(i, visited, postList, nextIndex, nextNode, stack)) {
                    return new int[0];
                }
            }
        }
        return stack;
    }

    private boolean DFS(int numCourses, int[] visited, int[] postList, int[] nextIndex, int[] nextNode, int[] stack){
        visited[numCourses] = 1;
        for(int i = postList[numCourses]; i != -1; i = nextIndex[i]){
            if(1 == visited[nextNode[i]]) {
                return false;
            }
            if(0 == visited[nextNode[i]]){
                if(!DFS(nextNode[i], visited, postList, nextIndex, nextNode, stack)){
                    return false;
                }
            }
        }
        visited[numCourses] = 2;
        stack[top] = numCourses;
        top--;
        return true;
    }
}



###########################


2ms runtime:

class Solution {
    private static int order_number;


    private static boolean DFS(int node, ArrayList<Integer>[] adj, boolean[] vis, boolean[] p_vis,
                            int[] order){
        boolean isCycle = false;
        vis[node] = true;
        p_vis[node] = true;

        for(var v : adj[node]){
            if(vis[v] && p_vis[v])
                isCycle=true;
            else if(!vis[v])
                isCycle = DFS(v, adj, vis, p_vis, order);

            if(isCycle)
                break;
        }
        p_vis[node] = false;
        order[order_number--] = node;
        return isCycle;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<numCourses; i++)
            adj[i] = new ArrayList<>();

        for(var edge: prerequisites)
            adj[edge[1]].add(edge[0]);

        boolean[] vis = new boolean[numCourses], p_vis =  new boolean[numCourses];
        int[] order = new int[numCourses];
        order_number = numCourses-1;
        boolean isCycle = false;

        for(int i=0; i<numCourses;i++){
            if(!vis[i] && DFS(i,adj,vis, p_vis, order)){
                isCycle = true;
                break;
            }
        }

        return isCycle ? new int[0]: order ;
    }
}
 */