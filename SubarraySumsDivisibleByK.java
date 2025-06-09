public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0, n = nums.length;
        int[] pref = new int[n+1];
        for (int i=0; i<n; i++) {
            var temp = (pref[i]+nums[i]) % k;
            if (temp < 0)
                pref[i+1] = temp+k;
            else
                pref[i+1] = temp;
        }

        int[] freq = new int[k];
        for (int i=0; i<=n; i++) {
            if (freq[pref[i]] == 0)
                freq[pref[i]] = 1;
            else    {
                cnt += freq[pref[i]];
                freq[pref[i]]++;
            }
        }
        return cnt;
    }
}

/* 3ms runtime:
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] sums = new int[k];
        sums[0] = 1;
        int answer = 0, prefix = 0;
        for (int num : nums) {
            prefix = (prefix + num % k + k) % k;
            answer += sums[prefix]++;
        }
        return answer;
    }
}
 */