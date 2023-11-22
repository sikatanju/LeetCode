public class WordSearch {
    private int rowLen;
    private int columnLen;
    private int wordLen;

    public boolean exist(char[][] board, String word) {
        this.rowLen = board.length;
        this.columnLen = board[0].length;
        this.wordLen = word.length();
        boolean[][] visited = new boolean[rowLen][columnLen];

        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (board[i][j] == word.charAt(0) && exist(i, j, 0, board, word, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean exist(int i, int j, int charAt, char[][] board, String str, boolean[][] visited) {
        if (charAt == wordLen)
            return true;

        if (i<0 || j<0 || i==rowLen || j==columnLen || board[i][j] != str.charAt(charAt) || visited[i][j])
            return false;

        visited[i][j] = true;
        if (exist(i+1, j, charAt+1, board, str, visited) || exist(i, j+1, charAt+1, board, str, visited) ||
                exist(i-1, j, charAt+1, board, str, visited) || exist(i, j-1, charAt+1, board, str, visited))
            return true;

        visited[i][j] = false;
        return false;
    }
}

/* Runtime 6ms : Mine 145ms (still better than 60% though):
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if (m*n < word.length())
            return false;
        char[] wrd = word.toCharArray();
        int[] boardf = new int[128];
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                ++boardf[board[i][j]];
            }
        }
        for (char ch : wrd)
        {
            if (--boardf[ch] < 0)
            {
                return false;
            }
        }
        if (boardf[wrd[0]] > boardf[wrd[wrd.length - 1]])
            reverse(wrd);
        for (int i = 0; i < m; ++i)
        {
            for (int j = 0; j < n; ++j)
            {
                if (wrd[0] == board[i][j]
                    && found(board, i, j, wrd, new boolean[m][n], 0))
                    return true;
            }
        }
        return false;
    }

    private void reverse(char[] word)
    {
        int n = word.length;
        for (int i = 0; i < n/2; ++i)
        {
            char temp = word[i];
            word[i] = word[n - i - 1];
            word[n - i - 1] = temp;
        }
    }
    private static final int[] dirs = {0, -1, 0, 1, 0};
    private boolean found(char[][] board, int row, int col, char[] word,
                        boolean[][] visited, int index)
    {
        if (index == word.length)
            return true;
        if (row < 0 || col < 0 || row == board.length || col == board[0].length
            || board[row][col] != word[index] || visited[row][col])
            return false;
        visited[row][col] = true;
        for (int i = 0; i < 4; ++i)
        {
            if (found(board, row + dirs[i], col + dirs[i + 1],
                word, visited, index + 1))
                return true;
        }
        visited[row][col] = false;
        return false;
    }
}



################ Runtime 19ms :

import java.util.*;

class Solution {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        if(word.length() > m * n) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char curr = board[i][j];
                Integer val = map.get(curr);
                if(val != null) {
                    map.put(curr, val++);
                } else {
                    map.put(curr, 1);
                }
            }
        }

        for(char c : word.toCharArray()) {
            Integer val = map.get(c);
                if(val != null && val >= 1) {
                    map.put(c, val--);
                } else {
                    return false;
                }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean found = dfs(board, word, i, j, 0);

                if(found) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int charPos) {

        char curr = board[x][y];

        if(word.charAt(charPos) == curr) {

            board[x][y] = '.';

            if(charPos == word.length() - 1) {
                return true;
            }

            if(y > 0 && board[x][y-1] != '.') {
                if(dfs(board, word, x, y-1, charPos+1)) {
                    return true;
                }
            }
            if(y < board[0].length-1 && board[x][y+1] != '.') {
                if(dfs(board, word, x, y+1, charPos+1)) {
                        return true;

                }
            }

            if(x > 0 && board[x-1][y] != '.') {
                if(dfs(board, word, x-1, y, charPos+1)) {
                    return true;
                }
            }
            if(x < board.length-1 && board[x+1][y] != '.') {
                if(dfs(board, word, x+1, y, charPos+1)) {
                    return true;
                }
            }
        }

        board[x][y] = curr;
        return false;
    }
}
 */



















/*
class Solution {

    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length())
            return true;

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j])
            return false;


        visited[i][j] = true;

        if(search(board, word, i-1, j, index+1) || search(board, word, i+1, j, index+1)
                || search(board, word, i, j-1, index+1) || search(board, word, i, j+1, index+1))
            return true;

        visited[i][j] = false;
        return false;
    }
}
 */






//import java.util.HashSet;
//import java.util.Set;
//
//public class WordSearch {
//    private int rowLen;
//    private int columnLen;
//    private int strLen;
//    private boolean firstTime;
//    private boolean isFound;
//    boolean[][] trueFalse;
//    private int lastVisited;
//    public boolean exist(char[][] board, String word) {
//        this.rowLen = board.length;
//        this.columnLen = board[0].length;
//        this.strLen = word.length();
//        this.isFound = false;
//        this.trueFalse = new boolean[rowLen][columnLen];
//        if (rowLen*columnLen < strLen)
//            return false;
//
//        for (int i=0; i<rowLen; i++)    {
//            for (int j=0; j<columnLen; j++) {
//                if (board[i][j] == word.charAt(0))  {
//                    if (strLen == 1)
//                        return true;
//
//                    dfs(i, j, 0, board, word);
//                }
//                else
//                    continue;
//
//                this.trueFalse = new boolean[rowLen][columnLen];
//                this.firstTime = true;
//            }
//        }
//        return isFound;
//    }
//    private void dfs(int rowIndex, int columnIndex, int charAt, char[][] board, String str) {
//        if (!firstTime && charAt == strLen-1 && rowIndex >= 0 && columnIndex >= 0 && rowIndex < rowLen && columnIndex < columnLen && board[rowIndex][columnIndex] == str.charAt(charAt))  {
//            if (!this.trueFalse[rowIndex][columnIndex])
//                this.isFound = true;
//
//            return;
//        }
//        else if (rowIndex < 0 || columnIndex < 0 || rowIndex == rowLen || columnIndex == columnLen || str.charAt(charAt) != board[rowIndex][columnIndex])
//            return;
//        else if (this.lastVisited < charAt)
//            return;
//
//        this.lastVisited = charAt;
//        this.trueFalse[rowIndex][columnIndex] = true;
//        firstTime = false;
//        dfs(rowIndex+1, columnIndex, charAt+1, board, str);
//        dfs(rowIndex-1, columnIndex, charAt+1, board, str);
//        dfs(rowIndex, columnIndex+1, charAt+1, board, str);
//        dfs(rowIndex, columnIndex-1, charAt+1, board, str);
//    }
//}
