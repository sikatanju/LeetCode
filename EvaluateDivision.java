import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    private class Node  {
        private String ch;
        private double value;
        public Node(String ch, double value)    {
            this.ch = ch;
            this.value = value;
        }
    }
    private Map<String, List<Node>> map;
    private double dfs(Set<String> set, String first, String last)  {
        if (!map.containsKey(first) || !map.containsKey(last))
            return -1.0;

        if (first.equals(last))
            return 1.0;

        for (Node it: map.get(first))   {
            if (set.contains(it.ch))
                continue;

            else if (it.ch.equals(last))
                return it.value;

            set.add(first);
            double val = dfs(set, it.ch, last);
            if (val != -1)
                return val * it.value;
        }

        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        int i=0;
        for (var eqn: equations)    {
            var first = eqn.getFirst();
            var last = eqn.getLast();

            map.putIfAbsent(first, new ArrayList<>());
            map.putIfAbsent(last, new ArrayList<>());

            map.get(first).add(new Node(last, values[i]));
            map.get(last).add(new Node(first, 1.0/values[i++]));
        }
        i=0;
        double[] res = new double[queries.size()];
        for (var query: queries)
            res[i++] = dfs(new HashSet<>(), query.getFirst(), query.getLast());

        return res;
    }
}

/* ### Best runtime : 0ms :
class Solution {
    int[] temp;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,Integer> map = new HashMap<>();
        int n = 1;
        for(List<String> list:equations){
            if(!map.containsKey(list.get(0))){
                map.put(list.get(0),n++);
                //System.out.println(list.get(0)+(n-1));
            }
            if(!map.containsKey(list.get(1))){
                map.put(list.get(1),n++);
                //System.out.println(list.get(1)+(n-1));
            }
        }
        double[][] arr = new double[n][n];
        for(int i=1;i<n;i++)
        arr[i][i]=1;
        int i = 0;
        for(List<String> list:equations){
            double num = values[i++];
            int a = map.get(list.get(0));
            int b = map.get(list.get(1));
            arr[a][b] = num;
            arr[b][a] = 1/num;
        }
        double[] result = new double[queries.size()];
        i=0;
        for(List<String> list:queries){
            int a = 0,b=0;
            if(!map.containsKey(list.get(0))){
                result[i++]=-1;
                continue;
            }
            a = map.get(list.get(0));
            if(!map.containsKey(list.get(1))){
                result[i++]=-1;
                continue;
            }
            b = map.get(list.get(1));
            temp = new int[n];
            result[i++] = helper(a,b,arr);
        }
        return result;
    }
    private double helper(int a,int b,double[][] arr){
        if(arr[a][b]!=0)
        return arr[a][b];
        if(temp[a]==1)
        return -1;
        temp[a]=1;

        for(int i=1;i<arr.length;i++){
            if(i==a)
            continue;
            if(arr[a][i]!=0){
                double value = helper(i,b,arr);
                //System.out.println(a+" "+i+" "+value+" "+(value!=-1));
                if(value!=-1)
                return arr[a][i]*value;
            }
        }
        return -1;
    }
}

 */

/* An Interesting approach, `Pairs` is used here. 2ms runtime :
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String,Double>>> graph = new HashMap<>();
        for (int i =0;i<equations.size();i++) {
            List<Pair<String,Double>> existingNodes = new ArrayList<>();
            if(graph.containsKey(equations.get(i).get(0))) {
                existingNodes = graph.get(equations.get(i).get(0));
            }
            existingNodes.add(new Pair<>(equations.get(i).get(1), values[i]));
            graph.put(equations.get(i).get(0),existingNodes);
            existingNodes = new ArrayList<>();
            if(graph.containsKey(equations.get(i).get(1))) {
                existingNodes = graph.get(equations.get(i).get(1));
            }
            existingNodes.add(new Pair<>(equations.get(i).get(0), 1.0/values[i]));
            graph.put(equations.get(i).get(1),existingNodes);
        }
        double[] result = new double[queries.size()];
        for (int i =0;i<queries.size();i++) {
            String source = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            if (!graph.containsKey(source) && !graph.containsKey(dest)) {
                result[i] = -1;
                continue;
            }
            result[i] = bfs(source, dest,graph);
        }
        return result;
    }
    public double bfs(String source, String dest,Map<String, List<Pair<String,Double>>> graph) {
        Set<String> visited = new HashSet<>();
        visited.add(source);
        Queue<Pair<String, Double>> q = new LinkedList<>();
        q.add(new Pair<>(source, 1.0));
        while(!q.isEmpty()) {
            Pair<String, Double> currNode = q.remove();
            if(currNode.getKey().equals(dest)) return currNode.getValue();
            for (Pair<String,Double> connectedNode : graph.getOrDefault(currNode.getKey(), new ArrayList<>())) {
                if(!visited.contains(connectedNode.getKey())) {
                    q.add(new Pair<>(connectedNode.getKey(), currNode.getValue()*connectedNode.getValue()));
                    visited.add(connectedNode.getKey());
                }
            }
        }
        return -1.0;
    }
}

 */
/* ### My solution is taken from :
class Edge {

    String v;
    double value;

    public Edge (String v, double value) {

        this.v = v;
        this.value = value;
    }
}

class Solution {

    public void addEdge (Map<String, List<Edge>> map, String u, String v, double value) {

        if (!map.containsKey (u)) {
            map.put (u, new ArrayList<> ());
        }

        map.get (u).add (new Edge (v, value));
    }

    public double dfs (Map<String, List<Edge>> map, Set<String> set, String u, String v) {

        if (!map.containsKey (u) || !map.containsKey (v)) {
            return -1;
        }
        else if (u.equals (v)) {
            return 1;
        }

        for (Edge edge : map.get (u)) {
            if (set.contains (edge.v)) {
                continue;
            }
            else if (edge.v.equals (v)) {
                return edge.value;
            }

            set.add (u);
            double val = dfs (map, set, edge.v, v);
            if (val != -1) {
                return val * edge.value;
            }
        }

        return -1;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] answer = new double[queries.size ()];
        Map<String, List<Edge>> map = new HashMap<> ();

        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get (i);
            addEdge (map, equation.get (0), equation.get (1), values[i]);
            addEdge (map, equation.get (1), equation.get (0), 1 / values[i]);
        }

        for (int i = 0; i < answer.length; i++) {
            List<String> query = queries.get (i);
            answer[i] = dfs (map, new HashSet<> (), query.get (0), query.get (1));
        }

        return answer;
    }
}
 */