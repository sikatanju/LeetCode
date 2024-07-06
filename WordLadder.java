import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int minStep = 1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            for (int i=queue.size(); i>0; i--)  {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return minStep;

                for (int j=0; j<wordList.size(); j++)   {
                    String str = wordList.get(j);
                    if (!visited.contains(str)) {
                        if (doesMatch(curr, str))   {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            minStep++;
        }
        return 0;
    }

    private boolean doesMatch(String start, String word)    {
        int count = 0;
        for (int i=0; i<start.length(); i++)    {
            if (start.charAt(i) != word.charAt(i))
                count++;

            if (count > 1)
                return false;
        }
        return count == 1;
    }
}


/* Best runtime : 32ms

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Set<String> beignWordSet = new HashSet<>();
        Set<String> endWordSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int count=1;
        beignWordSet.add(beginWord);
        endWordSet.add(endWord);

        while(!beignWordSet.isEmpty() && !endWordSet.isEmpty()){
            if(beignWordSet.size()>endWordSet.size()){
                Set<String> tmp = beignWordSet;
                beignWordSet = endWordSet;
                endWordSet = tmp;
            }
            Set<String> nextSet = new HashSet<>();
            for(String word: beignWordSet){
                char[] chArray = word.toCharArray();
                for(int i=0;i<chArray.length;i++){
                    char ch = chArray[i];
                    for(char c='a';c<='z';c++){
                        if(ch==c)
                            continue;
                        chArray[i] = c;
                        String newWord = new String(chArray);
                        if(endWordSet.contains(newWord))
                            return count+1;
                        if(!visited.contains(newWord) && wordSet.contains(newWord)){
                            visited.add(newWord);
                            nextSet.add(newWord);
                        }
                    }
                    chArray[i]=ch ;
                }

            }
            beignWordSet = nextSet;
            count++;
        }
        return 0;
    }
}
 */


/* 88ms runtime :

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord))
            return 0;

        char[] charset="abcdefghijklmnopqrstuvwxyz".toCharArray();
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited=new HashSet<>();

        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord))
                    return level;

                char[] currArr=curr.toCharArray();
                for(int i=0; i<currArr.length; i++){
                    char old=currArr[i];
                    for(char ch:charset){
                        currArr[i]=ch;
                        String str=new String(currArr);
                        if(wordSet.contains(str) && !visited.contains(str)){
                            visited.add(str);
                            queue.offer(str);
                        }
                    }
                    currArr[i]=old;
                }
            }
            level++;
        }

        return 0;
    }
}
 */