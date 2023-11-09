import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String str, int k) {
        int len = str.length();
        if (len == 1)
            return 1;

        char lastChar = str.charAt(0), currentChar = ' ';
        int count = 0, currentIndex = 0, repeatStartingIndex = 0;
        int max = 0, copyK = k, check = 0;

        while (currentIndex < len) {
            if (str.charAt(currentIndex) == lastChar)   {
                count++;
                currentIndex++;
            }

            else if (str.charAt(currentIndex) != lastChar)  {
                if (check == 0) {
                    repeatStartingIndex = currentIndex;
                    check++;
                }

                if (copyK > 0)  {
                    count++;
                    currentIndex++;
                    copyK--;
                    if (currentIndex == len)    {
                        while (copyK > 0)   {
                            if (count + 1 <= len)
                                count++;

                            copyK--;
                        }

                        if (count > max)
                            max = count;

                        currentIndex = repeatStartingIndex;
                        lastChar = str.charAt(currentIndex);
                        check = 0;
                        count = 0;
                        copyK = k;
                    }
                }

                else {
                    if (count > max)
                        max = count;

                    currentIndex = repeatStartingIndex;
                    lastChar = str.charAt(currentIndex);
                    check = 0;
                    count = 0;
                    copyK = k;
                }
            }
        }

        while (copyK > 0)   {
            if (count + 1 <= len)
                count++;

            copyK--;
        }

        if (count > max && count <= len)
            return count;

        return max;
    }
}

/* 3ms runtime solution :
class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        int[] counter = new int[91];
        int left = 0, maxi = 0;
        for(int right = 0; right < arr.length; right++) {
            if(++counter[arr[right]] > maxi) {
                maxi = counter[arr[right]];
            }
            if(right-left >= maxi + k) {
                counter[arr[left]]--;
                left++;
            }
        }
        return Math.min(maxi + k, arr.length);
    }
}


4ms runtime :

class Solution {
    public int characterReplacement(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int i=0,j=0,max=0,maxR=0;
        int[] freq = new int[128];
        while(j<n){
            freq[cs[j]]++;
            maxR=Math.max(maxR,freq[cs[j]]);
            while(j-i+1-maxR>k){
                freq[cs[i]]--;
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}


*** Detailed Solution :
// Time Complexity :  O(n)
// Space Complexity : O(1)
class Solution {
    public int characterReplacement(String s, int k) {
        // Make an array of size 26...
        int[] arr = new int[26];
        // Initialize largestCount, maxlen & beg pointer...
        int largestCount = 0, beg = 0, maxlen = 0;
        // Traverse all characters through the loop...
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k charactres. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            if(end - beg + 1 - largestCount > k){     // The main equation is: end - beg + 1 - largestCount...
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            // Get the maximum length of repeating character...
            maxlen = Math.max(maxlen, end - beg + 1);     // end - beg + 1 = size of the current window...
        }
        return maxlen;      // Return the maximum length of repeating character...
    }
}

*** Detailed Solution another :
   public int characterReplacement(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();

	   int left = 0, maxRepeat = 0, maxWindow = 0;

		for(int right = 0; right < s.length(); right++) {
			char ch = s.charAt(right);
			if(!map.containsKey(ch)) {
				map.put(ch, 0);
			}
			map.put(ch, map.get(ch) + 1);

			// IMPORTANT: maxRepeat is not the accurate number of dominant character, It is the historical maximum count
			// We do not care about it because unless it gets greater, it won't affect our final max window size.
			maxRepeat = Math.max(maxRepeat, map.get(ch));

			if(right - left + 1 - maxRepeat > k) {
				char remove = s.charAt(left);
				map.put(remove, map.get(remove) - 1);
				left++;
			}

        maxWindow = Math.max(maxWindow, right - left + 1);
    }

    return maxWindow;
}
 */
