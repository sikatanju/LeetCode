import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaximizeAmountAfterTwoDaysOfConversions {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

        Map<String, Double> day1 = getMaxAmounts(initialCurrency, graph1);
        Map<String, Double> day2 = getMaxAmounts(graph2, day1);
        return day2.get(initialCurrency);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates)   {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i=0; i<pairs.size(); i++)  {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];
            graph.computeIfAbsent(from, j -> new HashMap<>()).put(to, rate);
            graph.computeIfAbsent(to, j -> new HashMap<>()).put(from, 1/rate);
        }
        return graph;
    }

    private Map<String, Double> getMaxAmounts(String initialCurrency, Map<String, Map<String, Double>> graph)  {
        Map<String, Double> maxAmounts = new HashMap<>();
        maxAmounts.put(initialCurrency, 1.0);
        Queue<String> queue = new LinkedList();
        queue.offer(initialCurrency);
        while (!queue.isEmpty())    {
            String current = queue.poll();
            double currentRate = maxAmounts.get(current);

            for (Map.Entry<String, Double> entry: graph.getOrDefault(current, new HashMap<>()).entrySet())  {

                String neighbor = entry.getKey();

                double rate = entry.getValue();
                double newAmount = rate*currentRate;

                if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0))  {
                    maxAmounts.put(neighbor, newAmount);
                    queue.offer(neighbor);
                }
            }
        }
        return maxAmounts;
    }

    private Map<String, Double> getMaxAmounts(Map<String, Map<String, Double>> graph, Map<String, Double> day1) {
        Map<String, Double> max = new HashMap<>(day1);
        Queue<String> queue = new LinkedList<>(day1.keySet());
        while (!queue.isEmpty())    {
            String current = queue.poll();
            double amount = max.get(current);
            for (Map.Entry<String, Double> entry: graph.getOrDefault(current, new HashMap<>()).entrySet())  {
                String nei = entry.getKey();
                double rate = entry.getValue();
                double newAmount = amount*rate;
                if (newAmount > max.getOrDefault(nei, 0.0)) {
                    max.put(nei, newAmount);
                    queue.offer(nei);
                }
            }
        }

        return max;
    }
}

/* Runtime: 7ms: DFS approach:
class Solution {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        double maxCost = 1.0;
        Map<String, List<Pair<String, Double>>> graph1 = graph(pairs1, rates1);
        Map<String, List<Pair<String, Double>>> graph2 = graph(pairs2, rates2);

        Map<String, Double> cost1 = new HashMap<>();
        dfs(initialCurrency, 1.0, graph1, new HashSet<>(), cost1);
        Map<String, Double> cost2 = new HashMap<>();
        dfs(initialCurrency, 1.0, graph2, new HashSet<>(), cost2);

        for(String curr: cost1.keySet()) {
            double mul1 = cost1.get(curr);
            if (cost2.containsKey(curr)) {
                double mul2 = 1/cost2.get(curr);
                maxCost = Math.max(maxCost, mul1 * mul2);
            }
        }
        return maxCost;
    }


    private void dfs(String node, double curCost, Map<String, List<Pair<String, Double>>> graph, Set<String> visited, Map<String, Double> cost) {
        if (visited.contains(node)) { return; }
        visited.add(node);
        cost.put(node, curCost);
        if (!graph.containsKey(node)) { return; }
        for (Pair<String, Double> pair: graph.get(node)) {
            dfs(pair.getKey(), curCost * pair.getValue(), graph, visited, cost);
        }
    }

    private Map<String, List<Pair<String, Double>>> graph(List<List<String>> pairs, double[] rates) {
        Map<String, List<Pair<String, Double>>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            List<String> pair = pairs.get(i);
            graph.computeIfAbsent(pair.get(0), (x) -> new ArrayList<>())
                .add(new Pair(pair.get(1), rates[i]));
            graph.computeIfAbsent(pair.get(1), (x) -> new ArrayList<>())
                .add(new Pair(pair.get(0), 1.0/rates[i]));
        }
        return graph;
    }
 }
 */


/* Runtime: 10ms:
import java.util.*;

class Solution {
    private void solve(Map<String, Double> amountMap, Map<String, List<Pair>> conversionMap) {
        while (true) {
            int count = 0;

            List<String> keys = new ArrayList<>(amountMap.keySet());
            for (String key : keys) {
                String curr = key;
                double amt = amountMap.get(key);

                if (!conversionMap.containsKey(curr)) continue;

                for (Pair conversion : conversionMap.get(curr)) {
                    String curr2 = conversion.currency;
                    double rate = conversion.rate;
                    double newAmount = amt * rate;

                    if (!amountMap.containsKey(curr2) || amountMap.get(curr2) < newAmount) {
                        count++;
                        amountMap.put(curr2, newAmount);

                    }
                }
            }

            if (count == 0) break;
        }
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, List<Pair>> map1 = new HashMap<>();
        Map<String, List<Pair>> map2 = new HashMap<>();

        // Build graph for pairs1 and rates1
        for (int i = 0; i < pairs1.size(); i++) {
            String currencyA = pairs1.get(i).get(0);
            String currencyB = pairs1.get(i).get(1);
            double rate = rates1[i];

            map1.putIfAbsent(currencyA, new ArrayList<>());
            map1.putIfAbsent(currencyB, new ArrayList<>());

            map1.get(currencyA).add(new Pair(currencyB, rate));
            map1.get(currencyB).add(new Pair(currencyA, 1.0 / rate));
        }

        // Build graph for pairs2 and rates2
        for (int i = 0; i < pairs2.size(); i++) {
            String currencyA = pairs2.get(i).get(0);
            String currencyB = pairs2.get(i).get(1);
            double rate = rates2[i];

            map2.putIfAbsent(currencyA, new ArrayList<>());
            map2.putIfAbsent(currencyB, new ArrayList<>());

            map2.get(currencyA).add(new Pair(currencyB, rate));
            map2.get(currencyB).add(new Pair(currencyA, 1.0 / rate));
        }

        // Initialize amount map
        Map<String, Double> amountMap = new HashMap<>();
        amountMap.put(initialCurrency, 1.0);

        // Solve for both graphs
        solve(amountMap, map1);
        solve(amountMap, map2);

        return amountMap.getOrDefault(initialCurrency, 0.0);
    }

    // Helper class to represent a currency conversion pair
    private static class Pair {
        String currency;
        double rate;

        Pair(String currency, double rate) {
            this.currency = currency;
            this.rate = rate;
        }
    }
}
 */

/* Runtime: 9ms: DP approach:
class Solution {
       public double maxAmount(String init, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> dp = new HashMap<>();
        dp.put(init, 1.0);
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < pairs1.size(); ++j) {
                String a = pairs1.get(j).get(0), b = pairs1.get(j).get(1);
                dp.put(b, Math.max(dp.getOrDefault(b, 0.0), dp.getOrDefault(a, 0.0) * rates1[j]));
                dp.put(a, Math.max(dp.getOrDefault(a, 0.0), dp.getOrDefault(b, 0.0) / rates1[j]));
            }
        }
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < pairs2.size(); ++j) {
                String a = pairs2.get(j).get(0), b = pairs2.get(j).get(1);
                dp.put(b, Math.max(dp.getOrDefault(b, 0.0), dp.getOrDefault(a, 0.0) * rates2[j]));
                dp.put(a, Math.max(dp.getOrDefault(a, 0.0), dp.getOrDefault(b, 0.0) / rates2[j]));
            }
        }
        return dp.get(init);
    }
}

 */