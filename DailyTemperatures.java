public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int currentDay = 0, warmerDay = 0, count = 0;
        int len = temperatures.length;
        int[] answer = new int[temperatures.length];

        int lastDayTemperature = 0;
        while (currentDay < len-1)    {
            count = 0;
            int currentDayTemperature = temperatures[currentDay];
            warmerDay = currentDay + 1;

            if (lastDayTemperature == currentDayTemperature)    {
                if (answer[currentDay-1]-1 < 0)
                    answer[currentDay] = 0;
                else
                    answer[currentDay] = answer[currentDay-1]-1;

                lastDayTemperature = currentDayTemperature;
                currentDay++;
                continue;
            }

            while (warmerDay < len) {
                count++;
                if (temperatures[warmerDay] > currentDayTemperature)
                    break;

                warmerDay++;
            }
            if (warmerDay == len)
                answer[currentDay++] = 0;
            else
                answer[currentDay++] = count;

            lastDayTemperature = currentDayTemperature;
        }
        return answer;
    }
}


/********* 7ms runtime.
 * 
// Jump using prev res idx. Version 2: Refined.
// Use res idx computed previously to get to ans temp for idx. If neigh less, jump to neigh resIdx
// since by extension it cannot be any ones skipped. Handle maxTemp for 0 ans.
// TC: O(N). Worst case will go through 2 lens. O(2N).
// SC: O(1) if res not considered. No aux.
// Idea: https://www.youtube.com/watch?v=7MIXlgBfr_U
// https://leetcode.com/problems/daily-temperatures/discuss/121787/C++-Clean-code-with-explanation:-O(n)-time-and-O(1)-space-(beats-99.13)/343954

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int len = temperatures.length, maxTemp = -1, resIdxAccumulator = 0, nextIdx = 0;

        for(int idx = len - 1; idx >= 0; --idx) {
            if(temperatures[idx] >= maxTemp) {
                maxTemp = temperatures[idx];
                continue;
            }

            nextIdx = idx + 1;
            // No need for boundary check cuz above check.
            while(temperatures[nextIdx] <= temperatures[idx]) {
                nextIdx += res[nextIdx];
            }
            res[idx] = nextIdx - idx;
        }
        return res;
    }
}

************ 9ms runtime :

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        // 第i天后，第一次比第i天更热的是哪一天
        int[] warmer = new int[n];
        Arrays.fill(warmer, -1);
        // 用数组模拟栈，栈顶放小值
        int[] stack = new int[n];
        int border = 0;             // 下标小于border的是栈内有效元素
        for (int i = 0; i < n; i++) {
            if (border == 0) {
                stack[border++] = i;
            } else {
                int left = stack[border - 1];
                while (temperatures[left] < temperatures[i]) {
                    warmer[left] = i;
                    border--;
                    if (border > 0)
                        left = stack[border - 1];
                    else
                        break;
                }
                stack[border++] = i;
            }
        }   // 栈内剩余元素右侧没有比自己大的值，不作处理
        // 处理温度相同的情况
        for (int i = n - 2; i >= 0; i--) {
            int cur = warmer[i];
            if (cur != -1 && temperatures[i] == temperatures[cur])
                warmer[i] = warmer[cur];
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (warmer[i] != -1) {   // 未来有比当天更热的天
                answer[i] = warmer[i] - i;
            }
        }
        return answer;
    }
}

 */