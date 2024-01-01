import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int numOfPapersLeft = citations.length, maxPapers = Integer.MIN_VALUE;

        if (citations.length == 1)  {
            return citations[0] < 1 ? citations[0]: 1;
        }


        Arrays.sort(citations);
        for (int num: citations)    {
            if (num > numOfPapersLeft)  {
                maxPapers = Math.max(numOfPapersLeft, maxPapers);
            }

            if (numOfPapersLeft >= num)
                maxPapers = Math.max(num, maxPapers);

            if (numOfPapersLeft < num)
                break;

            numOfPapersLeft--;
        }
        return maxPapers;
    }
}


/* ################# 0ms runtime :
class Solution{
public int hIndex(int[] citations) {
    int n = citations.length;
    int[] buckets = new int[n+1];
    for(int c : citations) {
        if(c >= n) {
            buckets[n]++;
        } else {
            buckets[c]++;
        }
    }
    int count = 0;
    for(int i = n; i >= 0; i--) {
        count += buckets[i];
        if(count >= i) {
            return i;
        }
    }

return 0;
}
}


################# 1ms runtime:

class Solution {
    public int hIndex(int[] c) {
        int low=0 , high = c.length;
        while(low < high){
            int mid = (low+high+1)/2;
            int cnt=0;
            for(int i=0 ; i<c.length ; i++) if(c[i] >= mid) cnt++;
            if(cnt >= mid) low = mid;
            else high = high=mid-1;
        }
        return low;
    }
}

 */