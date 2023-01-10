import java.util.Map;
import java.util.HashMap;

public class longPalidromicString {
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0, end = 0;

        boolean[][] bool = new boolean[len][len];

        for (int i = len; i>=0; i--)    {
            for (int j=i; j < len; j++) {
                bool[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i < 3 || bool[i+1][j-1]);

                if (bool[i][j] && (j-i+1 > end))    {
                    start = i;
                    end = j-i+1;
                }
            }
        }
        return len == 0 ? "" : s.substring(start, start+end);
    }
}
