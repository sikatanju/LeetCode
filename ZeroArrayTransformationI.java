public class ZeroArrayTransformationI {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] imos = new int[n+1];
        for(int[] q : queries){
            imos[q[0]]++;
            imos[q[1]+1]--;
        }
        for(int i = 0;i < n;i++){
            imos[i+1] += imos[i];
        }
        for(int i = 0;i < n;i++){
            if(nums[i] <= imos[i]){

            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] arr = new int[len];
        for (int[] q: queries)  {
            arr[q[0]]++;
            arr[q[1]]++;
        }
        for (int i=0; i<len; i++)   {

        }
        return false;
    }

}

/*
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] imos = new int[n+1];
        for(int[] q : queries){
            imos[q[0]]++;
            imos[q[1]+1]--;
        }
        for(int i = 0;i < n;i++){
            imos[i+1] += imos[i];
        }
        for(int i = 0;i < n;i++){
            if(nums[i] <= imos[i]){

            }else{
                return false;
            }
        }
        return true;
    }
}
 */

/*
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++) pre[i+1] = pre[i]+nums[i];
        int cnt = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] != 0) continue;
            int t1 = pre[i]-pre[0];
            int t2 = pre[n]-pre[i+1];
            if(t1 ==t2) {
                cnt += 2;
            } else if(Math.abs(t1-t2) == 1) {
                cnt += 1;
            }
        }
        return cnt;
    }
}

################################################


class Solution {
    public int countValidSelections(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int cur = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (nums[i] == 0) {
                if (cur == sum - cur) {
                    ans += 2;
                }
                else if (Math.abs(cur - (sum - cur)) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

*/

/*
	class Solution {
		public int countValidSelections(int[] nums) {
			int n = nums.length;
			int ans = 0;
			for(int i = 0;i < n;i++){
				if(nums[i] == 0){
					for(int j = -1;j <= 1;j+=2){
						int[] a = Arrays.copyOf(nums, n);
						int cur = i, dir = j;
						while(cur >= 0 && cur < n){
							if(a[cur] == 0){
								cur += dir;
							}else{
								a[cur]--;
								dir = -dir;
								cur += dir;
							}
						}
						boolean az = true;
						for(int k = 0;k < n;k++){
							if(a[k] != 0){
								az = false;
								break;
							}
						}
						if(az)ans++;
					}
				}
			}
			return ans;
		}
	}
	//
 */