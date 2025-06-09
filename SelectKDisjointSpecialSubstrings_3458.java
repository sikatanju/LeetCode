import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SelectKDisjointSpecialSubstrings_3458 {
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();

        List<int[]> validSubstrings = new ArrayList<>();
        int[] first = new int[26], last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i=0; i<n; i++)    {
            int idx = str[i]-'a';
            first[idx] = Math.min(i, first[idx]);
            last[idx] = Math.max(i, last[idx]);
        }

        for (int i=0; i<n; i++) {
            if (i != first[str[i]-'a'])
                continue;

            int low = i, high = last[str[i]-'a'];
            boolean isValid = true;
            while (low <= high) {
                int idx = str[low]-'a';
                if (first[idx] < i)    {
                    isValid = false;
                    break;
                }
                high = Math.max(last[str[low]-'a'], high);
                low++;
            }
            if (isValid && !(i == 0 && high == n-1))
                validSubstrings.add(new int[]{i, high});
        }

        validSubstrings.sort(Comparator.comparingInt(a -> a[1]));
        int cnt = 0, lastIdx = -1;
        for (var temp: validSubstrings) {
            if (temp[0] > lastIdx)  {
                cnt++;
                lastIdx = temp[1];
            }
        }
        return cnt >= k;
    }
}
