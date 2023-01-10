public class findTheIndexOfTheFirstOccurrence {
    public int strStr (String haystack, String needle)  {
        int i = 0, len = haystack.length();
        for (; i<len; i++)  {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (doesMatch(haystack, needle, i))
                    return i;
            }
        }
        return -1;
    }

    public boolean doesMatch(String haystack, String needle, int index) {
        int len = needle.length(), j = 0, hayLen = haystack.length();
        if ((hayLen - index) < len)
            return false;

        while (j < len) {
            if (index < hayLen) {
                if (haystack.charAt(index++) != needle.charAt(j++)) {
                    return false;
                }
            }
            else
                return false;
        }
        return true;
    }
}
