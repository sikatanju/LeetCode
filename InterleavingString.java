import java.util.ArrayList;
import java.util.List;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i=s1.length(), j=s2.length();
        if (i+j != s3.length())
            return false;

        boolean[][] dp = new boolean[i+1][j+1];
        dp[i][j] = true;
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();

        for (int k=i; k>=0; k--)    {
            for (int l=j; l>=0; l--)    {
                if (k < i && str1[k] == str3[k+l] && dp[k+1][l])
                    dp[k][l] = true;

                if (l < j && str2[l] == str3[k+l] && dp[k][l+1])
                    dp[k][l] = true;
            }
        }
        return dp[0][0];
    }
}

/*############### 0ms runtime :

class Solution {
    public static boolean dfs(char c1[], char c2[], char c3[], int i, int j, int k, boolean dp[][]) {
        if (dp[i][j]) {
            return false;
        }
        if (k == c3.length) {
            return true;
        }
        boolean valid = i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, dp)
                || j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, dp);
        if (!valid) {
            dp[i][j] = true;
        }
        return valid;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray(), c3[] = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        boolean dp[][] = new boolean[m + 1][n + 1];
        return dfs(c1, c2, c3, 0, 0, 0, dp);
    }
}

################   1ms runtime :       ######################################

class Solution {
    private boolean check(String s1, String s2, String s3, int i, int j, int k, int[][] dp){
        int l1=s1.length(), l2=s2.length(), l3=s3.length();
        if(k==l3) return true;
        if(dp[i][j]!=0) return (dp[i][j]==1?true:false);
        if(i<l1 && s3.charAt(k)==s1.charAt(i) && j<l2 && s3.charAt(k)==s2.charAt(j)){
            boolean ans=(check(s1,s2,s3, i+1, j, k+1, dp) || check(s1,s2,s3, i, j+1, k+1, dp));
            dp[i][j]=ans?1:-1;
            return ans;
    }
        if(i<l1 && s3.charAt(k)==s1.charAt(i)) {
            boolean ans=(check(s1,s2,s3, i+1, j, k+1, dp));
             dp[i][j]=ans?1:-1;
            return ans;
        }
        if(j<l2 && s3.charAt(k)==s2.charAt(j)){
            boolean ans=(check(s1,s2,s3, i, j+1, k+1, dp));
             dp[i][j]=ans?1:-1;
            return ans;
        }
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {

        int l1=s1.length(), l2=s2.length(), l3=s3.length();
        int[][] dp= new int[101][101];
        // int n=0, m=0, prev=0;
        if(l1+l2!=l3) return false;
        return check(s1,s2,s3, 0,0,0, dp);
        // while(k<l3){
        //     if(i<l1 && s3.charAt(k)==s1.charAt(i)){
        //         i++;
        //         k++;
        //         if(prev==2 || prev==0){
        //             n++;
        //             prev=1;
        //         }
        //     } else if(j<l2 && s3.charAt(k)==s2.charAt(j)){
        //         j++;
        //         k++;
        //         if(prev==1 || prev==0){
        //             m++;
        //             prev=2;
        //         }
        //     } else {
        //         return false;
        //     }
        // }
        // return Math.abs(n-m)<=1;
    }
}


######################################


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; ++j) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[n];
    }
}
 */


/*

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] str3 = s3.toCharArray();

        int countOfStr1 = 0, countOfStr2 = 0;
        int i=s1.length()-1, j=s2.length()-1, k=s3.length()-1;
        if (i==-1)
            return s3.equals(s2);
        if (j==-1)
            return s3.equals(s1);

        while (k >= 0)   {
            boolean check1 = false, check2 = false;
            if (j>=0 && str3[k] == str2[j]) {
                check1 = true;
                while (str3[k] == str2[j])  {
                    k--;
                    j--;
                    if (k<0 || j<0)
                        break;
                }
                countOfStr2++;
            }
            if (i>=0 && str3[k] == str1[i]) {
                check1 = true;
                while (str3[k] == str1[i])  {
                    k--;
                    i--;
                    if (k<0 || i<0)
                        break;
                }
                countOfStr1++;
            }
            if (!check1 && !check2)
                break;

            if (k<0 && j<0 && i<0)
                break;
        }
        if (Math.abs(countOfStr1-countOfStr2) > 1)
            return false;

        return i == -1 && j == -1 && k == -1;
    }
 */