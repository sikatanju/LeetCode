import java.nio.channels.Pipe;
import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> returnList = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((ara1, ara2) -> (ara1[0]+ara1[1]) - (ara2[0] + ara2[1]));

        for (int i=0; i<nums2.length && i<k; i++)
            heap.add(new int[]{nums1[0], nums2[i], 0});

        for (int i=0; i<k && !heap.isEmpty(); i++)  {
            int[] temp = heap.poll();
            returnList.add(List.of(temp[0], temp[1]));
            int nums1Index = temp[2];
            if (nums1Index < nums1.length -1)
                heap.add(new int[] {nums1[nums1Index+1], temp[1], nums1Index+1});
        }

        return  returnList;
    }
}


/* best runtime : 12ms :

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

    int len1 = nums1.length, len2 = nums2.length;

    int left = nums1[0] + nums2[0];
    int right = nums1[len1 - 1] + nums2[len2 - 1];
    while (left <= right) {
      int middle = left + (right-left)/2;

      long cnt = getSmallerGreaterCnt(nums1, nums2, middle, k);
      if (cnt < k) {
        left = middle + 1;
      } else if (cnt > k) {
        right = middle - 1;
      } else {
        left = middle;
        break;
      }
    }
    return getPairs(nums1, nums2, left, k);
  }

  int getSmallerGreaterCnt(int[] nums1, int[] nums2, int target, int k) {
    int previousRight = nums2.length - 1;
    int cnt = 0;
    for (int i = 0; i < nums1.length && nums1[i] + nums2[0] <= target; i++) {
      int left = 0, right = previousRight;
      int pos = -1;
      while (left <= right) {
        int middle = (left + right) / 2;
        int sum = nums1[i] + nums2[middle];
        if (sum <= target) {
          pos = middle;
          left = middle + 1;
        } else {
          right = middle - 1;
        }
      }
      if (pos >= 0) {
        cnt += pos + 1;
        previousRight = pos;
      }
      if (cnt > k) {
        return cnt;
      }
    }
    return cnt;
  }

  List<List<Integer>> getPairs(int[] nums1, int[] nums2, int targetSum, int k) {
    List<List<Integer>> pairs = new ArrayList();
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length && nums1[i] + nums2[j] < targetSum; j++) {
        pairs.add(Arrays.asList(nums1[i], nums2[j]));
      }
    }
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length && nums1[i] + nums2[j] <= targetSum
          && pairs.size() < k; j++) {
        if (nums1[i] + nums2[j] == targetSum) {
          pairs.add(Arrays.asList(nums1[i], nums2[j]));
        }
      }
    }
    return pairs;
  }
}

######################## 18ms runtime :

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>(k);
        int arr[] = new int[nums1.length];
        long g = (long)nums1.length * (long)nums2.length;
        int minIter = k;
        if( g < k) minIter = (int)g;
        for(int j=0; j<minIter; j++){
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            int ind = 0;
            while(i < nums1.length && (i == 0 || arr[i-1] != 0)){
                if(arr[i] >= nums2.length) {
                    i++;
                    continue;
                }
                if( min > nums1[i] + nums2[arr[i]]) {
                    min = nums1[i] + nums2[arr[i]];
                    ind = i;
                }
                i++;
            }
            arr[ind]++;
            tmp.add(nums1[ind]);
            tmp.add(nums2[arr[ind] - 1] );
            ans.add(tmp);
        }
        return ans;
    }
}


#########################################



        List<List<Integer>> returnList = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        for (int i=0; i<nums1.length && i<k; i++)   {
            var temp = new int[]{nums1[i], nums2[0], 0};
            heap.add(temp);
        }

        for (int i=0; i<k && !heap.isEmpty(); i++)  {
            int[] temp = heap.poll();
            returnList.add(List.of(temp[0], temp[1]));
            int nums2Index = temp[2];
            if (nums2Index < nums2.length-1)
                heap.add(new int[]{temp[0], nums2[nums2Index+1], nums2Index+1});
        }
        return  returnList;
######################## My non working code :


        List<List<Integer>> returnList = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> tempList = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i=0; i<nums1.length; i++)  {
            for (int j=0; j<nums2.length; j++)  {
                var sum = nums1[i] + nums2[j];
                tempList.add(nums1[i]);
                tempList.add(nums2[j]);

                if (map.containsKey(sum))   {
                    while (k>0) {
                        if (heap.isEmpty())
                            break;

                        var temp = heap.remove();
                        if (sum < temp) {
                            returnList.add(tempList);
                            tempList = new ArrayList<>();
                            k--;
                            break;
                        }
                        if (temp > sum) {
                            heap.add(temp);
                            break;
                        }
                        returnList.add(map.get(temp));
                        map.remove(temp);
                        k--;
                    }
                    map.put(sum, tempList);
                }
                else
                    map.put(sum, tempList);

                tempList = new ArrayList<>();
                heap.add(sum);
            }
        }

        while (k>0) {
            if (heap.isEmpty())
                break;

            var temp = heap.remove();
            returnList.add(map.get(temp));
            k--;
        }

        return returnList;
 */