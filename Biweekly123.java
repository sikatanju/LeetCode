import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biweekly123 {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = Long.MIN_VALUE;

        List<Long> list = new ArrayList<>();
        list.add((long)nums[0]);
        long first = nums[0], second = 0;
        long tempSum = first;

        for (int i=1; i<nums.length; i++)   {
            second = nums[i];
            list.add((long)second);
            tempSum += second;
            if (Math.abs((first-second)) == k)
                maxSum = Math.max(maxSum, tempSum);
        }

        int index = nums.length-1;

        while (true)    {
            if (list.size() == 2)
                break;

            tempSum -= list.getFirst();
            list.removeFirst();
            if (Math.abs((list.getFirst() - list.get(--index))) == k)
                maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum == Long.MIN_VALUE ? 0 : maxSum;
    }
}
/*

// Problem 1 : 
class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if(nums[0] + nums[1] <= nums[2]){
            return "none";
        }
        if(nums[0] == nums[1] && nums[1] == nums[2]){
            return "equilateral";
        }else if(nums[0] == nums[1] || nums[1] == nums[2]){
            return "isosceles";
        }else{
            return "scalene";
        }
    }
}

##################################

// Problem 2: https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i/description/

class Solution {
		public int numberOfPairs(int[][] points) {
			int n = points.length;
			int[] xs = new int[n];
			for(int i = 0;i < n;i++){
				xs[i] = points[i][0] + 1000000000;
			}
			xs = shrink(xs);
			int[] ys = new int[n];
			for(int i = 0;i < n;i++){
				ys[i] = points[i][1] + 1000000000;
			}
			ys = shrink(ys);
			int[][] ps = new int[n][n];
			for(int i = 0;i < n;i++){
				ps[xs[i]][ys[i]]++;
			}
			int[][] cum = new int[n+2][n+2];
			for(int i = 0;i < n;i++){
				for(int j = 0;j < n;j++){
					cum[i+1][j+1] = cum[i+1][j] + cum[i][j+1] - cum[i][j] + ps[i][j];
				}
			}
			int ans = 0;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < n;j++){
					if(i == j)continue;
					if(xs[i] <= xs[j] && ys[i] >= ys[j]){
						int num = cum[xs[j]+1][ys[i]+1] - cum[xs[j]+1][ys[j]] - cum[xs[i]][ys[i]+1] + cum[xs[i]][ys[j]];
						if(num == 2)ans++;
					}
				}
			}
			return ans;
		}

		public int[] shrink(int[] a) {
			int n = a.length;
			long[] b = new long[n];
			for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
			Arrays.sort(b);
			int[] ret = new int[n];
			int p = 0;
			for (int i = 0; i < n; i++) {
				if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0) p++;
				ret[(int) b[i]] = p;
			}
			return ret;
		}
	}

##################################

// Problem 3: https://leetcode.com/problems/maximum-good-subarray-sum/description/

	class Solution {
		public long maximumSubarraySum(int[] nums, int k) {
			Map<Integer, Long> cums = new HashMap<>();
			long cm = 0;
			long ans = Long.MIN_VALUE;
			for(int v : nums){
				if(cums.containsKey(v-k)){
					long min = cums.get(v-k);
					ans = Math.max(ans, cm + v - min);
				}
				if(cums.containsKey(v+k)){
					long min = cums.get(v+k);
					ans = Math.max(ans, cm + v - min);
				}
				cums.merge(v, cm, Math::min);
				cm += v;
			}
			if(ans == Long.MIN_VALUE)ans = 0;
			return ans;
		}
	}
 

// #############################

// Problem 4 : https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii/description/

	class Solution {
		public int numberOfPairs(int[][] points) {
			int n = points.length;
			int[] xs = new int[n];
			for(int i = 0;i < n;i++){
				xs[i] = points[i][0] + 1000000000;
			}
			xs = shrink(xs);
			int[] ys = new int[n];
			for(int i = 0;i < n;i++){
				ys[i] = points[i][1] + 1000000000;
			}
			ys = shrink(ys);
			int[][] ps = new int[n][n];
			for(int i = 0;i < n;i++){
				ps[xs[i]][ys[i]]++;
			}
			int[][] cum = new int[n+2][n+2];
			for(int i = 0;i < n;i++){
				for(int j = 0;j < n;j++){
					cum[i+1][j+1] = cum[i+1][j] + cum[i][j+1] - cum[i][j] + ps[i][j];
				}
			}
			int ans = 0;
			for(int i = 0;i < n;i++){
				for(int j = 0;j < n;j++){
					if(i == j)continue;
					if(xs[i] <= xs[j] && ys[i] >= ys[j]){
						int num = cum[xs[j]+1][ys[i]+1] - cum[xs[j]+1][ys[j]] - cum[xs[i]][ys[i]+1] + cum[xs[i]][ys[j]];
						if(num == 2)ans++;
					}
				}
			}
			return ans;
		}

		public int[] shrink(int[] a) {
			int n = a.length;
			long[] b = new long[n];
			for (int i = 0; i < n; i++) b[i] = (long) a[i] << 32 | i;
			Arrays.sort(b);
			int[] ret = new int[n];
			int p = 0;
			for (int i = 0; i < n; i++) {
				if (i > 0 && (b[i] ^ b[i - 1]) >> 32 != 0) p++;
				ret[(int) b[i]] = p;
			}
			return ret;
		}
	}
*/

// Problem 1 :
/*
public String triangleType(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int one = 0, two = 0, three = 0;
        for (int i=0; i<3; i++) {
            int num = nums[i];

            set.add(num);
            if (i==0)
                one = num;
            if (i==1)
                two = num;
            if (i==2)
                three = num;
        }

        if (
                ((one + two) <= three) || ((two+three) <= one) || ((one+three) <= two)
            )  {
            return "none";
        }



        if (set.size() == 1)
            return "equilateral";
        else if (set.size() == 2)
            return "isosceles";

        return "scalene";
    }
 */
