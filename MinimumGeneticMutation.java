import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        List<String> banks = Arrays.asList(bank);
        Set<String> vist = new HashSet<>();
        int minSteps = 0;

        queue.add(startGene);
        vist.add(startGene);

        while (!queue.isEmpty())    {
            for (int i=queue.size(); i>0; i--)  {
                var str = queue.poll();
                if (str.equals(endGene))
                    return minSteps;

                char[] chars = str.toCharArray();

                for (int k=0; k<8; k++) {
                    char ch = chars[k];

                    for (int j=0; j<4; j++) {
                        chars[k] = "ACGT".charAt(j);

                        String ss = new String(chars);
                        if (!vist.contains(ss) && banks.contains(ss))   {
                            queue.add(ss);
                            vist.add(ss);
                        }
                    }
                    chars[k] = ch;
                }
            }
            minSteps++;
        }
        return -1;
    }
}


/* Best runtime : 0ms:
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> seen = new HashSet<>();
        List<String> curLayer = new ArrayList<>();
        curLayer.add(startGene);
        int numMutations = 0;
        while (!curLayer.isEmpty()) {
            List<String> nextLayer = new ArrayList<>();
            numMutations++;
            for (String gene : curLayer) {
                for (String bankGene : bank) {
                    if (diff(gene, bankGene) != 1) {
                        continue;
                    }
                    if (bankGene.equals(endGene)) {
                        return numMutations;
                    }
                    if (!seen.contains(bankGene)) {
                        seen.add(bankGene);
                        nextLayer.add(bankGene);
                    }
                }
            }
            curLayer = nextLayer;
        }
        return -1;
    }

    private int diff(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
 */
/*

    public int minMutation(String start, String end, String[] bank) {
        // a queue to store each gene string (node)
        Queue<String> q = new LinkedList<>();
        // a hash set to store if we've visited a node
        HashSet<String> vis = new HashSet<String>();
        // convert bank to List
        List<String> banks = Arrays.asList(bank);
        // distance
        int steps = 0;
        // we start from gene string `start` as a starting point
        // push it to the queue
        q.add(start);
        // and mark it visited
        vis.add(start);
        // BFS
        while (!q.isEmpty()) {
            // iterate from the back because the size of q varies
            // which would result in wrong answer if you iterate from 0
            // alternatively, you can define a new variable for q.size() before the for-loop
            // i.e.
            // int n = q.size();
            // for (int i = 0; i < n; i++) {
            for (int i = q.size(); i > 0; i--) {
                // get the gene string from the queue
                String s = q.poll();
                // if it is same as `end`, that means we found the answer
                if (s.equals(end)) return steps;
                // otherwise, given a gene string with 8-character long
                // we can replace each character with "A", "C", "G" and "T"
                char[] ca = s.toCharArray();
                for (int j = 0; j < 8; j++) {
                    // s[j] will be modified later,
                    // hence store the original character here
                    char oc = ca[j];
                    // iterate ACGT
                    // alternatively, you can use `for (char c : "ACGT") { ... }`
                    for (int k = 0; k < 4; k++) {
                        // replace the j-th character in s with the k-th character in ACGT
                        ca[j] = "ACGT".charAt(k);
                        // we can reach the next node if the next node hasn't been visited
                        // and the next node is available in `bank`
                        String t = new String(ca);
                        if (!vis.contains(t) && banks.contains(t)) {
                            // push the next node to the queue
                            q.add(t);
                            // and mark it visited
                            vis.add(t);
                        }
                    }
                    // since we updated the character, we revert it back
                    ca[j] = oc;
                }
            }
            // increase the step count
            steps += 1;
        }
        // not able to reach `end`, return -1 here
        return -1;
    }
 */