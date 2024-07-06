public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return new String();

        int[] map = new int[128];
        for (char ch: t.toCharArray())
            map[ch]++;

        int count = t.length();
        int left = 0, right = 0, startIndex = 0, minLen = Integer.MAX_VALUE;
        char[] strs = s.toCharArray();

        while (right < strs.length)   {
            if (map[strs[right++]]-- > 0)
                count--;

            while (count == 0)  {
                if (right - left < minLen)  {
                    startIndex = left;
                    minLen = right-left;
                }
                if (map[strs[left++]]++ == 0)
                    count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? new String(): new String(strs, startIndex, minLen);
    }
}

/*

 */