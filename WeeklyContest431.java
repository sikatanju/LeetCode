import java.util.HashMap;

import java.util.*;

public class WeeklyContest431 {
    private char[] charMap;
    public long calculateScore(String s) {
        buildCharMap();
        long sum = 0;
        int i=0, len = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Stack<Integer>> map = new HashMap<>();
        while (i<len)   {
            char mirror = getMirrorChar(chars[i]);
            if (map.containsKey(mirror) && !map.get(mirror).isEmpty())   {
                var tempStack = map.get(mirror);
                int j = tempStack.pop();
                sum += i-j;
            }   else
                map.computeIfAbsent(chars[i], k -> new Stack<>()).push(i);
            i++;
        }
        return sum;
    }
    private void buildCharMap() {
        this.charMap = new char[26];
        charMap[0] = 'z';
        charMap[1] = 'y';
        charMap[2] = 'x';
        charMap[3] = 'w';
        charMap[4] = 'v';
        charMap[5] = 'u';
        charMap[6] = 't';
        charMap[7] = 's';
        charMap[8] = 'r';
        charMap[9] = 'q';
        charMap[10] = 'p';
        charMap[11] = 'o';
        charMap[12] = 'n';
        charMap[13] = 'm';
        charMap[14] = 'l';
        charMap[15] = 'k';
        charMap[16] = 'j';
        charMap[17] = 'i';
        charMap[18] = 'h';
        charMap[19] = 'g';
        charMap[20] = 'f';
        charMap[21] = 'e';
        charMap[22] = 'd';
        charMap[23] = 'c';
        charMap[24] = 'b';
        charMap[25] = 'a';
    }

    private char getMirrorChar(char ch) {
        return charMap[ch-'a'];
    }
}

/*
    public int maxLength(int[] nums) {
        int len = nums.length, maxLen = -1;
        for (int i=0; i<len; i++)   {
            for (int j=i; j<len; j++)   {
                int product = prod(i, j, nums);
                int tempI = i;
                int lcm = nums[tempI++];
                while (tempI <= j)    {
                    lcm = getLCM(lcm, nums[tempI++]);
                }
                tempI = i;
                int gcd = nums[tempI++];
                while (tempI <= j)   {
                    gcd = getGCD(nums[tempI], gcd);
                    tempI++;
                }
                if (product == lcm*gcd) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }

    private int prod(int i, int j, int[] nums)  {
        int prod = 1;
        while (i<=j)    {
            prod *= nums[i];
            i++;
        }
        return prod;
    }

    private int getGCD(int num1, int num2)  {
        if (num2 == 0)
            return num1;
        return getGCD(num2, num1%num2);
    }

    private int getLCM(int num1, int num2)    {
        int temp, i=2, res;
        if (num1 > num2)
            res = num1;
        else
            res = num2;

        temp = res;

        while(res % num1 != 0 || res % num2 != 0)    {
            res = temp * i;
            i++;
        }
        return res;
    }
 */

/*
private void buildMap() {
        map.put('a', 'z');
        map.put('z', 'a');
        map.put('y', 'b');
        map.put('b', 'y');
        map.put('x', 'c');
        map.put('c', 'x');
        map.put('d', 'w');
        map.put('w', 'd');
        map.put('v', 'e');
        map.put('e', 'v');
        map.put('u', 'f');
        map.put('f', 'u');
        map.put('t', 'g');
        map.put('g', 't');
        map.put('s', 'h');
        map.put('h', 's');
        map.put('r', 'i');
        map.put('i', 'r');
        map.put('q', 'j');
        map.put('j', 'q');
        map.put('p', 'k');
        map.put('k', 'p');
        map.put('o', 'l');
        map.put('l', 'o');
        map.put('n', 'm');
        map.put('m', 'n');
    }
 */