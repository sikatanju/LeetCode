public class MinimumTimeToRevertWordToInitialStateI {
    public int minimumTimeToInitialState(String word, int k) {
        char[] str = word.toCharArray();
        int len = str.length;

        int[] ara = numAra(str);
        int num = 0;
        for (int i=k; i<len; i += k)   {
            num++;
            if (ara[i] == len-i)
                return num;
        }
        return num+1;
    }

    private int[] numAra(char[] str) {
        int len = str.length;
        int[] ara = new int[len];
        if (len == 0)
            return ara;

        ara[0] = len;
        int low = 0, high = 0;
        for (int i=1; i<len; i++)   {
            if (i > high)   {
                low = high = i;
                while (high < len && str[high-low] == str[high])
                    high++;

                ara[i] = high-low;
                high--;
            }   else {
                if (ara[i-low] < high - i + 1)  {
                    ara[i] = ara[i-low];
                }   else {
                    low = i;
                    while (high < len && str[high-low] == str[high])
                        high++;

                    ara[i] = high-low;
                    high--;
                }
            }
        }
        return ara;
    }
}

/* Best Runtime : 0ms

class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int n = word.length();
        int ans = 0;

        for(int i = 1; i <= n; i++){
            int d = i * k;
            if(d >= n) return i;

            boolean ok = true;

            for(int j = d; j < n; j++){
                if(word.charAt(j) != word.charAt(j-d)){
                    ok = false;
                    break;
                }
            }
            if(ok) return i;
        }
        return 0;
    }
}
*/

/*

    public int minimumTimeToInitialState(String word, int k) {
        char[] s = word.toCharArray();
        int n = s.length;
        int[] z = Z(s);
        int ct = 0;

        for (int i = k; i < n; i += k) {
            ct++;
            if (z[i] == n - i) {
                return ct;
            }
        }
        return ct + 1;
    }

    public int[] Z(char[] str) {
        int n = str.length;
        int[] z = new int[n];
        if (n == 0) return z;
        z[0] = n;
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && str[r - l] == str[r])
                    r++;

                z[i] = r - l;
                r--;
            } else {
                if (z[i - l] < r - i + 1) {
                    z[i] = z[i - l];
                } else {
                    l = i;
                    while (r < n && str[r - l] == str[r])
                        r++;

                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }
 */


/* Alternate approach :

class Solution {
    public int minimumTimeToInitialState(String str, int k) {
        int n = str.length();
        int[] zArray = calculateZArray(str);
        for (int i = 1; i < n; i++)
            if (i + zArray[i] == n && i%k == 0) return i/k;
        return (n-1)/k+1;
    }
    private int[] calculateZArray(String str) {
        int n = str.length();
        int[] zArray = new int[n];
        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                zArray[i] = Math.min(right - i + 1, zArray[i - left]);
            }
            while (i + zArray[i] < n && str.charAt(zArray[i]) == str.charAt(i + zArray[i])) {
                zArray[i]++;
            }
            if (i + zArray[i] - 1 > right) {
                left = i;
                right = i + zArray[i] - 1;
            }
        }
        return zArray;
    }
}

 */