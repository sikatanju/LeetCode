import java.util.HashSet;
import java.util.List;

public class WordBreak {

    /*
    public boolean wordBreak(String s, List<String> wordDict) {
        JustForPractice.Trie trie = new JustForPractice.Trie();
        for (var word: wordDict)
            trie.addWord(word);

        int len = s.length();
        char[] arr = s.toCharArray();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i=0; i<len; i++)   {
            if (dp[i])  {
                int j = i;
                JustForPractice.Trie temp = trie;
                while (j < len && temp.children[arr[j]-'a'] != null) {
                    temp = temp.children[arr[j]-'a'];
                    j++;
                    if (temp.isWord)
                        dp[j] = true;
                }
            }
        }
        return dp[len];
    }
    class Trie  {
        public Trie[] children;
        public boolean isWord;
        Trie()  {
            this.children = new Trie[26];
            this.isWord = false;
        }
        public void addWord(String str)   {
            Trie temp = this;
            for (char ch: str.toCharArray())    {
                if (temp.children[ch-'a'] == null)
                    temp.children[ch-'a'] = new Trie();

                temp = temp.children[ch-'a'];
            }
            temp.isWord = true;
        }
    }*/
}


/* Previous 4ms solution:
    public boolean wordBreak2(String s, List<String> wordDict) {
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
 */
/* 1ms solution with Trie:

class SolutionTrie {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for(String word:wordDict){
            trie.add(word);
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0]=true;
        for(int i=0; i<len; i++){
            if(dp[i]==true){
                int j=i;
                Trie tmp = trie;
                // must have j less than len
                // otherwise it would exceed the length of string
                while(j < len && tmp.children[s.charAt(j)-'a'] != null){
                    tmp = tmp.children[s.charAt(j)-'a'];
                    j++;
                    if(tmp.isWord){
                        dp[j]=true;
                    }
                }

            }
        }
        // for(boolean b:dp){
        //     System.out.println(b);
        // }
        return dp[len];
    }

    class Trie{
        public Trie[] children;
        public boolean isWord;
        Trie(){
            children = new Trie[26];
            isWord = false;
        }

        public void add(String s){
            Trie t = this;
            for(char c:s.toCharArray()){
                if(t.children[c-'a']==null){
                    t.children[c-'a']=new Trie();
                }
                t=t.children[c-'a'];
            }
            t.isWord=true;
        }
    }
}
 */
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