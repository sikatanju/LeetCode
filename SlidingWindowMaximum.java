import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        int tempMax = Integer.MIN_VALUE, i=0, currMaxIndex = 0;
        while (i < k)   {
            if (nums[i] > tempMax)  {
                currMaxIndex = i;
                tempMax = nums[i];
            }
            i++;
        }
        list.add(tempMax);
        for (; i<nums.length; i++)  {
            int num = nums[i];
            if (tempMax > num)  {
                if (currMaxIndex >= (i-k+1))   {
                    list.add(tempMax);
                    continue;
                }   else {
                    tempMax = Integer.MIN_VALUE;
                    int temp = i;
                    while (temp >= (i-k+1))  {
                        if (nums[temp] > tempMax)   {
                            tempMax = nums[temp];
                            currMaxIndex = temp;
                        }
                        temp--;
                    }
                    if (temp == i)  {
                        currMaxIndex = i;
                        list.add(num);
                        tempMax = num;
                        continue;
                    }   else {
                        list.add(tempMax);
                    }
                }
            }   else {
                currMaxIndex = i;
                tempMax = num;
                list.add(num);
            }
        }
        nums = list.stream().mapToInt(num->num).toArray();
        return nums;
    }
}

/* Best runtime: 4ms:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] re = new int[nums.length + 1 - k];

        int maxId = 0;
        int max = Integer.MIN_VALUE;

        for (int x = 0; x < k; x++) {
            if (nums[x] >= max) {
                max = nums[x];
                maxId = x;
            }
        }

        re[0] = max;

        for(int i=1, end; i<re.length; i++){
            end = i+k-1;

            if(i <= maxId){
                if(max <= nums[end]){
                    max = nums[end];
                    maxId = end;
                }
            }
            else{
                if(nums[end] >= max-1){
                    max = nums[end];
                    maxId = end;
                }
                else if(nums[i] == max-1 || nums[i] == max){
                    max = nums[i];
                    maxId = i;
                }
                else{
                    max = Integer.MIN_VALUE;
                    for(int x=i ; x<end+1 ; x++){
                        if(nums[x] >= max){
                            max = nums[x];
                            maxId = x;
                        }
                    }
                }
            }
            re[i] = max;
        }
        return re;
    }
}
 */

/* Second best: 10ms:
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] d = new int[100010];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int head = 0, tail = -1;
        for(int i = 0, j = 0; i < n; i++){
            if(head <= tail && i - d[head] + 1 > k) head++;
            while(head <= tail && nums[d[tail]] <= nums[i]) tail--;
            d[++tail] = i;
            if(i >= k - 1){
                res[j++] = nums[d[head]];
            }
        }
        return res;
    }
}
 */