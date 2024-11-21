import java.util.Arrays;

public class RussianDollEnvelopes {
    private int len;
    public int maxEnvelopes(int[][] envelopes) {
        this.len = envelopes.length;
        int max = -1;
        int[] arr = new int[len+1];
        Arrays.sort(envelopes, (a,b) -> a[0] == b[0] ? b[1]-a[1]: a[0]-b[0]);
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = Integer.MIN_VALUE;
        for (int i=0; i<len; i++)   {
            int curr = envelopes[i][1];
            int index = getIndex(arr, curr);
            arr[index] = curr;
            max = Math.max(index, max);
        }
        return max == -1? 1: max;
    }

    private int getIndex(int[] arr, int curr) {
        int low = 0, high = len-1, index = 1;
        while (low <= high) {
            int mid = (low+high)/2;
//            if (arr[mid] < curr)    {
            if (arr[mid] < curr)    {
                low = mid+1;
                index = low;
            }   else {
                high = mid-1;
            }
        }
        return index;
    }
}
