public class UncrossedLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length)
            return maxUncrossedLines(nums2, nums1);

        int len1 = nums1.length, len2 = nums2.length;
        int[] dp = new int[len1+1];

        for (int i=1; i<=len1; i++)	{
            int[] temp = new int[len2+1];
            for (int j=1; j<=len2; j++)	{
                if (nums1[i-1] == nums2[j-1])
                    temp[j] = dp[j-1]+1;
                else
                    temp[j] = Math.max(dp[j], temp[j-1]);
            }
            dp = temp;
        }
        return dp[len2];
    }
}
