import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeeklyContest_386 {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int totalRequiredTime = 0, n=nums.length, m = changeIndices.length, totalMarked = 0, minTime = 0;
        boolean[] numsMark = new boolean[nums.length];

        Set<Integer> alreadyMarked = new HashSet<>();
        Map<Integer, Integer> mapIndices = new HashMap<>();
        Map<Integer, Integer> mapNums = new HashMap<>();

        for (int i=0; i<n; i++) {
            int num = nums[i];
            mapNums.put(i+1, num+1);
            totalRequiredTime += (num+1);
        }
        if (totalRequiredTime > m)
            return -1;

        for (int i=0; i<m; i++) {
            int num = changeIndices[i];
            if (mapIndices.containsKey(num))
                mapIndices.put(num, mapIndices.get(num)+1);
            else
                mapIndices.put(num, 1);
        }

        if (mapIndices.size() < mapNums.size())
            return -1;

        for (int i=0; i<m; i++) {
            if (alreadyMarked.size() == n)
                break;
            if (i<n)    {
                if (!mapIndices.containsKey(i+1))
                    return -1;
            }

            minTime++;
            int num = changeIndices[i];
            if (alreadyMarked.contains(num))
                continue;
            else    {
                int min = mapNums.get(num);
                if (i+1 >= min)
                    alreadyMarked.add(num);
            }
        }
        if (alreadyMarked.size() < mapNums.size())
            return -1;

        return (minTime < totalRequiredTime) ? totalRequiredTime : minTime;
    }
}
/*
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long ans = 0;
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int ilx = bottomLeft[i][0];
                int ily = bottomLeft[i][1];
                int irx = topRight[i][0];
                int iry = topRight[i][1];

                int jlx = bottomLeft[j][0];
                int jly = bottomLeft[j][1];
                int jrx = topRight[j][0];
                int jry = topRight[j][1];

                int lx = Math.max(ilx, jlx);
                int ly = Math.max(ily, jly);
                int rx = Math.min(irx, jrx);
                int ry = Math.min(iry, jry);
                if(lx < rx && ly < ry){
                    long s = Math.min(rx-lx, ry-ly);
                    ans = Math.max(ans, s*s);
                }
            }
        }
        return ans;
    }
}


[3,0,5,2,0,2]
[3,3,1,5,6,2,4,2,4,4,4,1,3,6,5,1,5,5,1,2,5]
public boolean isPossibleToSplit(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        int maxNum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num))   {
                var total = map.get(num);
                if (total + 1 > 2)
                    return false;
                else
                    map.put(num, total+1);
            }
            else {
                map.put(num, 1);
            }
        }
        return true;
    }
 */