import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int minMoves = 0, len = board.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[len][len];
        visited[len-1][0] = true;
        q.add(1);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                int current = q.poll();
                if (current == len*len)
                    return minMoves;

                for (int j=1; j<=6; j++)    {
                    if (current + j > len*len)
                        break;

                    int[] position = findPosition(current+j, len);
                    int row = position[0];
                    int column = position[1];
                    if (visited[row][column] == false)  {
                        visited[row][column] = true;
                        if (board[row][column] == -1)
                            q.add(current+j);
                        else
                            q.add(board[row][column]);
                    }
                }
            }
            minMoves++;
        }
        return -1;
    }

    private int[] findPosition(int i, int len) {
        int row = len - (i-1) / len -1;
        int column = (i-1) % len;
        if (row % 2 == len % 2)
            return new int[]{row, len - 1 - column};

        return new int[] {row, column};
    }
}
