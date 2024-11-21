import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class WallsAndGates {
    private int rowLen;
    private int columnLen;

    public void islandsAndTreasure(int[][] grid) {
        this.rowLen = grid.length;
        this.columnLen = grid[0].length;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();


        for (int i=0; i<rowLen; i++)  {
            for (int j=0; j<columnLen; j++) {
                if (grid[i][j] == 0)    {
                    String str = getString(i, j);
                    queue.add(str);
                    visited.add(str);
                }
            }
        }
        int distant = 0;
        while (!queue.isEmpty())    {
            int len = queue.size();
            for (int i=0; i<len; i++)  {
                String str = queue.poll();
                int row = getRow(str);
                int column = getColumn(str);
                grid[row][column] = distant;
                addIndex(visited, queue, row+1, column, grid);
                addIndex(visited, queue, row-1, column, grid);
                addIndex(visited, queue, row, column+1, grid);
                addIndex(visited, queue, row, column-1, grid);
            }
            distant++;
        }
    }

    private void addIndex(Set<String> visited, Queue<String> queue, int i, int j, int[][] grid)  {
        String str = getString(i, j);
        if (i < 0 || i >= this.rowLen || j<0 || j>=this.columnLen || visited.contains(str) || grid[i][j] == -1)
            return;

        visited.add(str);
        queue.add(str);
    }
    private String getString(int i, int j)  {
        return Integer.toString(i) + 'q' + Integer.toString(j);
    }
    private int getRow(String str)  {
        StringBuilder row = new StringBuilder();
        for (char ch: str.toCharArray())    {
            if (ch == 'q')
                return Integer.parseInt(row.toString());

            row.append(ch);
        }
        return Integer.parseInt(row.toString());
    }
    private int getColumn(String str)   {
        StringBuilder column = new StringBuilder();
        int i=0;
        while (str.charAt(i) != 'q') {
            i++;
        }
        i++;
        for (; i<str.length(); i++) {
            column.append(str.charAt(i));
        }
        return Integer.parseInt(column.toString());
    }
}
