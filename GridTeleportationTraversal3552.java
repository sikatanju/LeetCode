//import java.util.*;

public class GridTeleportationTraversal3552 {
/*
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minMoves(String[] matrix) {
        Map<Character, List<int[]>> map = new HashMap<>();
        int n = matrix.length, m = matrix[0].length();
        char[][] grid = new char[n][m];

        for (int i=0; i<n; i++) {
            int j = 0;
            for (char ch: matrix[i].toCharArray())    {
                grid[i][j] = ch;
                if (Character.isLetter(ch))
                    map.computeIfAbsent(ch, k-> new ArrayList<>()).add(new int[]{i, j});

                j++;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        if (Character.isLetter(grid[0][0])) {
            for (int[] idx: map.get(grid[0][0]))    {
                queue.add(new int[]{idx[0], idx[1]});
                grid[idx[0]][idx[1]] = '-';
            }
        }
        else {
            queue.add(new int[]{0, 0});
            grid[0][0] = '-';
        }

        if (grid[n-1][m-1] == '-')
            return 0;

        int steps = 1;
        while (!queue.isEmpty())    {
            int size = queue.size();
            for (int i=0; i<size; i++)  {
                int[] idx = queue.remove();
                int r = idx[0], c = idx[1];
                for (int[] dir: DIRS)   {
                    int rr = r+dir[0], cc = c+dir[1];
                    if (isValid(rr, cc, n, m))  {
                        if (Character.isLetter(grid[rr][cc]))   {
                            for (int[] ll: map.get(grid[rr][cc]))   {
                                grid[ll[0]][ll[1]] = '-';
                                if (ll[0] == n-1 && ll[1] == m-1)
                                    return steps;

                                queue.add(new int[]{ll[0],ll[1]});
                            }
                        }   else {
                            if (grid[rr][cc] != '#' && grid[rr][cc] != '-')    {
                                queue.add(new int[]{rr, cc});
                                grid[rr][cc] = '-';
                                if (rr == n-1 && cc == m-1)
                                    return steps;
                            }
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int r, int c, int n, int m) {
        return r > -1 && r < n && c > -1 && c < m;
    }
*/
}

// Best runtime: 136ms:
/*
class Solution {
    public static final int[][] ADJACENT = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public int minMoves(String[] matrix) {
        //need to keep track of which portal letters have been used in state, whether using dp or a bfs,
        //can level order bfs with a bitmask in state to keep track of used portal letters, using bitmasks in dp would make too many states as 2^26 * rows * col
        //can cancel bfs once 26*m*n moves have been made as that would get all possible in worst case


        //wait, overcomplicating things... would never want to use same letter portal more than once in an optimal solution anyway.
        //as a same letter portal can go to ANY OTHER same letter portal, so if go through twice to reach an end letter portal, could've always gone to said portal first.
        //therefore, can ignore portals in state and just standard level order bfs but take portals as a "freebie" move to any of the places they can go
        int m = matrix.length, n = matrix[0].length();
        if((m == 1 && n == 1) || (matrix[0].charAt(0) != '.' && matrix[m-1].charAt(n-1) == matrix[0].charAt(0))) return 0; //if have portal directly to the end just take it

        List<int[]>[] portalsToPositions = new ArrayList[26];
        for(int i = 0; i < 26; i++) portalsToPositions[i] = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                char curr = matrix[i].charAt(j);
                if(curr >= 'A' && curr <= 'Z') portalsToPositions[curr - 'A'].add(new int[]{i, j});
            }
        }


        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        if(matrix[0].charAt(0) != '.') {
            int idx = matrix[0].charAt(0)-'A';
            for(int[] pos : portalsToPositions[idx]) {
                queue.offer(pos);
                visited[pos[0]][pos[1]] = true;
            }
        } else {
            queue.offer(new int[]{0, 0});
        }

        visited[0][0] = true;
        int moves = 0;

        while(!queue.isEmpty()) {
            int sz = queue.size();
            while(sz-- > 0) {
                int[] curr = queue.poll();
                for(int[] adj : ADJACENT) {
                    int r = adj[0] + curr[0], c = adj[1] + curr[1];
                    if(r < 0 || r == m || c < 0 || c == n || visited[r][c] || matrix[r].charAt(c) == '#') continue;
                    if(matrix[r].charAt(c) != '.') {
                        int idx = matrix[r].charAt(c) - 'A';
                        for(int[] pos : portalsToPositions[idx]) { //always queue pos as if one portal hasn't been visited then none have been, as all same letter portals are visited simultaneously
                            if(pos[0] == m-1 && pos[1] == n-1) return moves + 1;
                            queue.offer(pos);
                            visited[pos[0]][pos[1]] = true;
                        }
                    } else {
                        if(r == m-1 && c == n-1) return moves + 1;
                        queue.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
 */
