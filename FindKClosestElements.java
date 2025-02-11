import java.util.*;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>(k);
        int n = arr.length, minIndex = Integer.MAX_VALUE;
        if (k==n)   {
            for (int num: arr)
                res.add(num);

            return res;
        }
        if (x < arr[0]) {
            int i=0;
            while (i<k) {
                res.add(arr[i++]);
            }
            return res;
        }
        if (x > arr[n-1])   {
            int i=n-k;
            while (k-- > 0)   {
                res.add(arr[i++]);
            }
            return res;
        }
        int index = getIndex(arr, x);
        int low = index-1, high = index+1;
        res.add(arr[index]);
        k--;
        while (high < n && low >= 0 && k > 0) {
            int diff1 = Math.abs(arr[low]-x);
            int diff2 = Math.abs(arr[high]-x);
            if (diff1 <= diff2) {
                res.add(arr[low--]);
            }   else {
                res.add(arr[high++]);
            }
            k--;
        }
        while (k > 0 && high < n) {
            res.add(arr[high++]);
            k--;
        }
        while (k > 0 && low >= 0) {
            res.add(arr[low--]);
            k--;
        }
        Collections.sort(res);
        return res;
    }
    private int getIndex(int[] arr, int target) {
        int low = 0, high = arr.length-1;
        while (low <= high) {
            int mid = (low+high)/2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        int minIndex = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++)    {
            int diff = Math.abs(arr[i]-target);
            if (diff < minDiff) {
                minIndex = i;
                minDiff = diff;
            }
        }
        return minIndex;
    }
}
/* Best runtime: 0ms:
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int first = bsearch(arr, x, k);
        return new java.util.AbstractList<>() {
            @Override
            public Integer get(int i) {
                return arr[first + i];
            }
            @Override
            public int size() {
                return k;
            }
        };
    }
    private int bsearch(int[] arr, int x, int k) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
// [1,3,5,6,7]
 */


/* 4th best runtime: 4ms:
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int l = 0;
        int r = n-1;
        while(r-l>=k){
            int abs_l = Math.abs(arr[l]-x);
            int abs_r = Math.abs(arr[r]-x);
            if(abs_l>abs_r) l++;
            else r--;
        }
        for(int i=l;i<=r;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}
 */