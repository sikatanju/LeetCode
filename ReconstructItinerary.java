import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (var ticket: tickets)
            map.computeIfAbsent(ticket.get(0), i -> new PriorityQueue<>()).offer(ticket.get(1));

        List<String> res = new ArrayList<>();
        dfs(map, res, "JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, List<String> res, String from) {
        PriorityQueue<String> minHeap = adj.get(from);
        while (minHeap != null && !minHeap.isEmpty())
            dfs(adj, res, minHeap.poll());

        res.add(from);
    }
}


/*
public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        Map<String, List<String>> adj = new HashMap<>();
        for (var ticket: tickets)
            adj.computeIfAbsent(ticket.get(0), i -> new ArrayList<>()).add(ticket.get(1));

        List<String> res = new ArrayList<>();
        res.add("JFK");

        if(dfs(adj, res, "JFK", tickets.size()+1))
            return res;

        return new ArrayList<>();
    }

    private boolean dfs(Map<String, List<String>> map, List<String> res, String src, int len)    {
        if (res.size() == len)
            return true;

        if (!map.containsKey(src))
            return false;

        List<String> str = new ArrayList<>(map.get(src));
        for (int i=0; i<str.size(); i++)    {
            String temp = str.get(i);
            map.get(src).remove(i);
            res.add(temp);
            if (dfs(map, res, temp, len))
                return true;

            map.get(src).add(i, temp);
            res.removeLast();
        }
        return false;
    }
 */