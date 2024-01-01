import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;

        for (int i = len - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= len && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}


/* 0ms runtime :

class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
       return backtrack(s, wordDict, 0, new boolean[s.length()+1]);
    }

    public boolean backtrack(String s, List<String> wordDict, int index, boolean [] visited) {

        if(index == s.length()) {
            return true;
        }

        for(int i=0; i<wordDict.size(); i++ ){
            if(s.startsWith(wordDict.get(i), index)) {
                int nextIndex =  index + wordDict.get(i).length();
                if(visited[nextIndex]) continue;
                visited[nextIndex] = true;
                if(backtrack(s, wordDict, nextIndex,visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}

########## 1ms runtime :

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        // initalize linear dp array
        boolean[] dp = new boolean[s.length()+1];

        // set first value to true
        dp[0] = true;

        // start max word length at 0
        int max = 0;

        // get the longest word in the list
        for(String word : wordDict){
            max = Math.max(max, word.length());
        }

        // loop for each letter in the string
        for(int i = 1; i <= s.length(); i++){

            //get all the substrings from j-i
            for(int j = i-1; j >= Math.max(i-max-1,0); j--){

                // if a word is found with the current index
                if(dp[j] && wordDict.contains(s.substring(j,i))){

                    // set i index to true
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
 */