import java.util.Arrays;

public class WeeklyContest430 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;

        String res = "";
        int len = word.length(), split = numFriends-1;
        for (int i=0; i<len; i++)   {
            String temp = word.substring(i, Math.min(i+(len-numFriends+1), len));
            if (temp.compareTo(res) > 0)
                res = temp;
        }
        return res;
    }
}

/*
    public int minimumOperations(int[][] grid) {
        int count = 0;
        int rowLen = grid.length, columnLen = grid[0].length;
        for (int i=0; i<columnLen; i++) {
            for (int j=0; j<rowLen; j++)    {
                if (j == 0)
                    continue;
                else {
                    int prev = grid[j-1][i], curr = grid[j][i];
                    if (curr > prev)    {
                        continue;
                    }   else {
                        int tempCount = 0;
                        count += prev-curr+1;
                        grid[j][i] = prev+1;

                    }
                }
            }
        }
        return count;
    }
 */