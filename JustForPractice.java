import java.nio.DoubleBuffer;
import java.util.*;

public class JustForPractice {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == j) {
                    lcp[i][j] = n - i;
                } else if (nums[i] == nums[j]) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (lcp[0][i] >= i && i <= j - i + 1) {
                    ans++;
                } else if (lcp[i][j + 1] >= j - i + 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
class Solution {
    public int beautifulSplits(int[] nums) {
        int count = 0, z[] = z(nums);
        for (int i = 1; i < nums.length; i++) {
            count += z[i] >= i ? nums.length - i - i : 0;
            int[] next = new int[nums.length - i];
            for (int j = i; j < nums.length; j++) {
                next[j - i] = nums[j];
            }
            int[] Z = z(next);
            for (int j = 1; j < Z.length; j++) {
                count += Z[j] >= j && (j < i || z[i] < i) ? 1 : 0;
            }
        }
        return count;
    }
    private static int[] z(int[] s) {
        int[] z = new int[s.length];
        for (int i = 1, x = 0, y = 0; i < s.length; i++) {
            for (z[i] = Math.max(0, Math.min(z[i - x], y - i + 1)); i + z[i] < s.length && s[z[i]] == s[i + z[i]]; y = i + z[x = i]++) {
            }
        }
        return z;
    }
}
*/


/*
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

        Map<String, Double> day1 = getMaxAmounts(initialCurrency, graph1);
        Map<String, Double> day2 = getMaxAmounts(graph2, day1);
        return day2.getOrDefault(initialCurrency, 0.0);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates)   {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i=0; i<pairs.size(); i++)  {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i], rate2 = 1/rates[i];
            graph.computeIfAbsent(from, j -> new HashMap<>()).put(to, rate);
            graph.computeIfAbsent(to, j -> new HashMap<>()).put(from, rate2);
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
    public int minimumOperations(int[] nums) {
        int count = 0;
        while (true)    {
            if (isUnique(nums))
                break;
            else {
                count++;
                if (nums.length <= 3)
                    return count;

                int[] temp = new int[nums.length-3];
                for (int i=0; i<temp.length; i++)   {
                    temp[i] = nums[i+3];
                }
                nums = temp;
            }
        }
        return count;
    }
    private boolean isUnique(int[] nums)    {
        Set<Integer> set = new HashSet<>();
        for (int num: nums)
            set.add(num);

        return set.size() == nums.length;
    }

 */
    /*
    import java.util.Arrays;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        nums[0] -= k;
        int res = 1;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(nums[i] + k, Math.max(nums[i] - k, nums[i - 1] + 1));
            if (nums[i] != nums[i - 1]) res++;
        }
        return res;
    }
}w
     */
    /*
    class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            Integer last = set.isEmpty() ? null : set.last();
            if (last == null || last + 1 < i - k) {
                set.add(i - k);
            } else if (last + 1 <= i + k) {
                set.add(last + 1);
            }
        }
        return set.size();
    }
}
     */
/*
    public int buttonWithLongestTime(int[][] events) {
        int maxTime = events[0][1], maxIndex = events[0][0];
        for (int i=1; i<events.length; i++) {
            int prevTime = events[i-1][1], prevIndex = events[i-1][0];
            int currTime = events[i][1];
            int timeTook = currTime - prevTime;
            if (timeTook > maxTime) {
                maxIndex = events[i][0];
                maxTime = timeTook;
            }   else if (timeTook == maxTime)   {
                maxIndex = Math.min(events[i][0], maxIndex);
            }
        }
        return maxIndex;
    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;

        sum /= 2;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            Set<Integer> tempSet = new HashSet<>(set);
            for (var each: tempSet)
                set.add(each+num);

            set.add(num);
        }
        return set.contains(sum);
    }
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
 */

/* From WeeklyContest428: Graph Problem: 3387. Maximize Amount After Two Days of Conversions
class Solution
{
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2)
    {
        // Graph for Day 1
        Map<String, Map<String, Double>> graph1 = buildGraph(pairs1, rates1);
        // Graph for Day 2
        Map<String, Map<String, Double>> graph2 = buildGraph(pairs2, rates2);

        // BFS/DFS to calculate maximum values
        Map<String, Double> day1Amounts = getMaxAmounts(initialCurrency, graph1);
        Map<String, Double> day2Amounts = getMaxAmounts(initialCurrency, graph2, day1Amounts);

        // Return the maximum value for the initial currency after Day 2
        return day2Amounts.getOrDefault(initialCurrency, 0.0);
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates)
    {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++)
        {
            String start = pairs.get(i).get(0);
            String target = pairs.get(i).get(1);
            double rate = rates[i];

            graph.putIfAbsent(start, new HashMap<>());
            graph.putIfAbsent(target, new HashMap<>());
            graph.get(start).put(target, rate);
            graph.get(target).put(start, 1 / rate);
        }
        return graph;
    }

    private Map<String, Double> getMaxAmounts(String startCurrency, Map<String, Map<String, Double>> graph)
    {
        Map<String, Double> maxAmounts = new HashMap<>();
        maxAmounts.put(startCurrency, 1.0);

        Queue<String> queue = new LinkedList<>();
        queue.offer(startCurrency);

        while (!queue.isEmpty())
        {
            String current = queue.poll();
            double currentAmount = maxAmounts.get(current);

            for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet())
            {
                String neighbor = entry.getKey();
                double rate = entry.getValue();
                double newAmount = currentAmount * rate;

                if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0))
                {
                    maxAmounts.put(neighbor, newAmount);
                    queue.offer(neighbor);
                }
            }
        }

        return maxAmounts;
    }

    private Map<String, Double> getMaxAmounts(String startCurrency, Map<String, Map<String, Double>> graph, Map<String, Double> initialAmounts)
    {
        Map<String, Double> maxAmounts = new HashMap<>(initialAmounts);
        Queue<String> queue = new LinkedList<>(initialAmounts.keySet());

        while (!queue.isEmpty())
        {
            String current = queue.poll();
            double currentAmount = maxAmounts.get(current);

            for (Map.Entry<String, Double> entry : graph.getOrDefault(current, new HashMap<>()).entrySet())
            {
                String neighbor = entry.getKey();
                double rate = entry.getValue();
                double newAmount = currentAmount * rate;

                if (newAmount > maxAmounts.getOrDefault(neighbor, 0.0))
                {
                    maxAmounts.put(neighbor, newAmount);
                    queue.offer(neighbor);
                }
            }
        }

        return maxAmounts;
    }
}
 */











/*
public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length, dequeue[] = new int[len], res[] = new int[len-k+1];
        int first = 0, last = 0;

        for (int i=0; i<len; i++)   {
            while (first < last && nums[dequeue[last-1]]<=nums[i])
                last--;

            dequeue[last++] = i;

            if (dequeue[first] == i-k)
                first++;

            if (i >= k-1)
                res[i-k+1] = nums[dequeue[first]];
        }
        return res;
    }
 */
/*
public int[] maxSlidingWindow(final int[] nums, final int k) {
    final int n = nums.length;
    final int[] dequeue = new int[n];
    final int[] result = new int[n + 1 - k];

    int first = 0, last = 0;

    for(int i = 0; i < n; i++) {
        while(first < last && nums[dequeue[last - 1]] <= nums[i])
            last--;

        dequeue[last++] = i;

        if(dequeue[first] == i - k)
            first++;

        if(i >= k - 1)
            result[i - k + 1] = nums[dequeue[first]];
    }
    return result;
}
*/



/*
public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        char[] chars1 = num1.toCharArray(), chars2 = num2.toCharArray();
        int[] results = new int[len1+len2];
        for (int i=len2-1; i>=0; i--)   {
            for (int j=len1-1; j>=0; j--)   {
                int res = (chars2[i]-'0')*(chars1[j]-'0');
                int mulPos = i+j, modPos = i+j+1;
                int sum = res + results[modPos];
                results[mulPos] += sum/10;
                results[modPos] = sum%10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (var num: results)  {
            if (!stringBuilder.isEmpty())   {
                stringBuilder.append(num);
            }   else {
                if (num != 0)
                    stringBuilder.append(num);
            }
        }
        return stringBuilder.isEmpty() ? "0" : stringBuilder.toString();
    }
 */
/*
public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;
        for (var price: prices) {
            b1 = Math.max(b1, -price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;
    }
 */
/*
    public long findMaximumScore(List<Integer> nums) {
        long res = 0, prev = 0;
        for (int curr: nums)    {
            res += prev;
            prev = Math.max(curr, prev);
        }
        return res;
    }
 */
/*
    public long findMaximumScore2(List<Integer> nums) {
        long max = 0;
        int i = 0;
        boolean isEnd = false;
        while (i < nums.size()) {
            int current = nums.get(i);
            int nextIndex = findNextIndex(nums, current, i);
            if (nextIndex == nums.size()-1)
                isEnd = true;

            max += (long)(nextIndex-i)*current;
            i = nextIndex;
            if (isEnd)
                break;
        }
        return max;
    }

    private int findNextIndex(List<Integer> nums, int curr, int currIndex)  {
        while (currIndex < nums.size())    {
            currIndex++;
            if (currIndex < nums.size() && nums.get(currIndex) > curr) {
                return currIndex;
            }
        }
        return nums.size()-1;
    }
 */
/*
    private int len;
    private int findIndex(int[] arr, int val)   {
        int low = 0, high = len-1, index = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] <= val)   {
                low = mid+1;
                index = low;
            }
            else {
                high = mid-1;
            }
        }
        return index;
    }
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        this.len = obstacles.length;
        int[] dp = new int[len+1], res = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = Integer.MIN_VALUE;
        for (int i=0; i<len; i++)   {
            int index = findIndex(dp, obstacles[i]);
            res[i] = index;
            dp[index] = obstacles[i];
        }
        return res;
    }
 */
/*
    private int findIndex(int[] arr, int value) {
        int low = 0, high = len-1, index = 0;
        while (low <= high) {
            var mid = (low+high)/2;
            if (value <= arr[mid])   {
                high = mid-1;
                index = mid;
            }   else {
                low = mid+1;
                index = low;
            }
        }
        return index;
    }
    public int lengthOfLIS(int[] nums) {
        this.len = nums.length;
        if (len == 1)
            return 1;

        int max = -1;
        int[] arr = new int[len+1];
        Arrays.fill(arr, 1000000);
        arr[0] = Integer.MIN_VALUE;
        for (int i=0; i<len; i++)   {
            int index = findIndex(arr, nums[i]);
            arr[index] = nums[i];
            max = Math.max(index, max);
        }
        return max;
    }
    public int findInsertionIndex(int[] nums, int val) {
        // find the greatest index < nums.
        int l = 0;
        int r = nums.length - 1;
        int res = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < val) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res + 1;
    }
    public int lengthOfLIS2(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] seq = new int[n + 1];
        Arrays.fill(seq, Integer.MAX_VALUE);
        seq[0] = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            int insertIndex = findInsertionIndex(seq, cur);
            res = Math.max(res, insertIndex);

            if (seq[insertIndex] >= cur) {
                seq[insertIndex] = cur;
            }
        }
        return res;
    }
 */
/*
public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

//        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < len; i++) {
            int dpVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dpVal = Math.max(dp[j], dpVal);
                }
            }
            dp[i] = dpVal + 1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }
 */
/*

    private int rlen;
    private int clen;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rlen = heights.length;
        this.clen = heights[0].length;
        this.heights = heights;

        List<List<Integer>> res = new ArrayList<>();

        boolean[][] p = new boolean[rlen][clen];
        boolean[][] a = new boolean[rlen][clen];

        for (int i = 0; i < clen; i++) {
            dfs(0, i, -1, p);
            dfs(rlen-1, i, -1, a);
        }
        for (int i=0; i<rlen; i++)  {
            dfs(i, 0, -1, p);
            dfs(i, clen-1, -1, a);
        }
        for (int i=0; i<rlen; i++)  {
            for (int j=0; j<clen; j++)  {
                if (p[i][j] && a[i][j])
                    res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs(int i, int j, int prev, boolean[][] ocean)    {
        if (i < 0 || j < 0 || i == rlen || j == clen || prev > heights[i][j] || ocean[i][j])
            return;

        ocean[i][j] = true;

        dfs(i+1, j, heights[i][j], ocean);
        dfs(i, j+1, heights[i][j], ocean);
        dfs(i-1, j, heights[i][j], ocean);
        dfs(i, j-1, heights[i][j], ocean);
    }
 */
/*
public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for (int i=0; i<=len; i++)   {
            for (var temp: wordDict)    {
                int tempLen = temp.length();
                int index = i - tempLen;
                if (index >= 0 && dp[index] && s.substring(index, index+tempLen).equals(temp))    {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
 */
/*
public boolean wordBreak(String s, List<String> wordDict) {
    Trie trie = new Trie();
    for (var word: wordDict)
        trie.addWord(word);

    int len = s.length();
    char[] arr = s.toCharArray();
    boolean[] dp = new boolean[len+1];
    dp[0] = true;
    for (int i=0; i<len; i++)   {
        if (dp[i])  {
            int j = i;
            Trie temp = trie;
            while (j < len && temp.children[arr[j]-'a'] != null) {
                temp = temp.children[arr[j]-'a'];
                j++;
                if (temp.isWord)
                    dp[j] = true;
            }
        }
    }
    return dp[len];
}*/
/*
public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();

        if (len <= 2)   {
            if (len == 2)
                return arr[0] == arr[1] ? s : s.substring(0, 1);

            return s;
        }
        int low = 0, high  = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[len][len];

        for (int i=len-1; i>=0; i--)  {
            dp[i][i] = true;
            for (int j=i+1; j<len; j++) {
                if (arr[i] == arr[j] && (j-i < 3 || dp[i+1][j-1]))  {
                    dp[i][j] = true;
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        low = i;
                        high = j;
                    }
                }
            }
        }
        return s.substring(low, high+1);
    }
 */
/* Edit Distance:
public int minDistance(String word1, String word2) {
        int rowLen = word1.length(), columnLen = word2.length();
        int[][] dp = new int[rowLen+1][columnLen+1];
        char[] str1 = word1.toCharArray(), str2 = word2.toCharArray();

        for (int i=0, temp=0; i<=columnLen; i++, temp++)
            dp[0][i] = temp;
        for (int i=0, temp=0; i<=rowLen; i++)
            dp[i][0] = temp++;

        for (int i=0; i<rowLen; i++)   {
            for(int j=0; j<columnLen; j++) {
                if (str1[i] == str2[j])
                    dp[i+1][j+1] = dp[i][j];
                else
                    dp[i+1][j+1] = 1+Math.min(dp[i][j], Math.min(dp[i+1][j], dp[i][j+1]));
            }
        }
        return dp[rowLen][columnLen];
    }
 */
/*
    public int longestCommonSubsequence(String str1, String str2) {
        if (str1.length() < str2.length())
            return longestCommonSubsequence(str2, str1);

        int str1Len = str1.length(), str2Len = str2.length();
        char[] charArray1 = str1.toCharArray(), charArray2 = str2.toCharArray();

        int[] prev = new int[str1Len + 1];
        int[] curr = new int[str2Len + 1];

        for (int i=1; i<=str1Len; i++)  {
            for (int j=1; j<=str2Len; j++)   {
                if (charArray1[i-1] == charArray2[j-1])
                    curr[j] = prev[j-1] + 1;
                else
                    curr[j] = Math.max(curr[j-1], prev[j]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[str2Len];
    }
 */
/* Maximal Square:
public int maximalSquare(char[][] matrix) {
        maxSquare = Integer.MIN_VALUE;
        int rowLen = matrix.length, columnLen = matrix[0].length;
        int[][] dp = new int[rowLen][columnLen];

        for (int i=rowLen-1; i>=0; i--) {
            if (matrix[i][columnLen-1] == '1')  {
                dp[i][columnLen-1] = 1;
                maxSquare = Math.max(maxSquare, 1);
            }
        }
        for (int j=columnLen-1; j>=0; j--)  {
            if (matrix[rowLen-1][j] == '1') {
                dp[rowLen-1][j] = 1;
                maxSquare = Math.max(maxSquare, 1);
            }
        }

        for (int i=rowLen-2; i>=0; i--) {
            for (int j=columnLen-2; j>=0; j--)  {
                int current = matrix[i][j] - '0';
                if (current == 0)   {
                    dp[i][j] = 0;
                }   else if (current == 1)  {
                    dp[i][j] = 1;
                }
                if (dp[i][j] == 1 && j < columnLen-1)   {
                    int rightValue = dp[i][j+1], bottomValue = dp[i+1][j], diagValue = dp[i+1][j+1];
                    dp[i][j] = 1 + Math.min(rightValue, Math.min(bottomValue, diagValue));
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare*maxSquare;
    }
 */
/*
static int maxSquare;
    public int maximalSquare(char[][] matrix) {
        maxSquare = Integer.MIN_VALUE;
        int rowLen = matrix.length, columnLen = matrix[0].length;
        int[][] helper = new int[rowLen][columnLen];
        Integer[][] dp = new Integer[rowLen][columnLen];
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                helper[i][j] = matrix[i][j]-'0';
            }
        }
        helper(rowLen-2, columnLen-2, helper[rowLen-2][columnLen-2], rowLen, columnLen, dp, helper);
        return maxSquare*maxSquare;
    }
    private int helper(int i, int j, int currentValue, int rowLen, int columnLen, Integer[][] dp, int[][] helper)    {
        if (i >= rowLen || j >= columnLen)
            return 0;
        if (currentValue == 0)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];

        int current = 1 + Math.min(helper(i, j+1, helper[i][j],rowLen, columnLen, dp, helper),
                Math.min(helper(i+1, j+1, helper[i][j], rowLen, columnLen, dp, helper), helper(i, j+1, helper[i][j], rowLen, columnLen, dp, helper)));

        maxSquare = Math.max(current, maxSquare);
        dp[i][j] = current;
        return dp[i][j];
    }
 */
/*class Triangle1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        Integer[][] dp = new Integer[size][size];
        return helper(0, 0, size, dp, triangle);
    }
    private int helper(int i, int j, int n, Integer[][] dp, List<List<Integer>> list)   {
        if (i >= n)
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        return dp[i][j] = list.get(i).get(j) + Math.min(helper(i+1, j, n, dp, list), helper(i+1, j+1, n, dp, list));
    }
}
*/
/*
public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];

        for (int rowLevel=triangle.size()-1; rowLevel>=0; rowLevel--)  {
            for (int column=0; column<rowLevel+1; column++)
                dp[column] = triangle.get(rowLevel).get(column) + Math.min(dp[column], dp[column+1]);

        }

        return dp[0];
    }
 */
/*

    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();
        int columnLen = triangle.get(rowLen-1).size();
        if (triangle.size() == 1)
            return triangle.get(0).get(0);

        int[][] dp = new int[rowLen][columnLen];
        for (int temp = 0; temp < columnLen; temp++)    {
            dp[rowLen-1][temp] = triangle.get(rowLen-1).get(temp);
        }
        columnLen = triangle.get(rowLen-2).size();
        for (int rowLevel=rowLen-2; rowLevel>=0; rowLevel--)    {
            for (int column=0; column<columnLen; column++)  {
                int current = triangle.get(rowLevel).get(column);
                dp[rowLevel][column] = current + Math.min(dp[rowLevel+1][column], dp[rowLevel+1][column+1]);
            }
            columnLen -= 1;
        }
        return dp[0][0];
    }
 */