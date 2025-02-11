import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeeklyContest436 {
    private int rLen, cLen;
    boolean[][] sorted;
    private boolean reverse;
    public int[][] sortMatrix(int[][] grid) {
        rLen = grid.length;
        cLen = grid[0].length;
        sorted = new boolean[rLen][cLen];
        int cHalf = (int) Math.ceil((double)cLen/2);
        for (int i=0; i<rLen; i++)  {
            for (int j=0; j<cLen; j++)  {
                if (!sorted[i][j])  {
                    if (i==0 && j<=0 || (i>0))    {
                        reverse = true;
                    } else
                        reverse = false;
                    sort(grid, i, j);
                }
            }
        }
        return grid;
    }

    private void sort(int[][] grid, int i, int j)   {
        List<Integer> list = new ArrayList<>();
        int tempI = i, tempJ = j;
        while (i<rLen && j<cLen)    {
            list.add(grid[i][j]);
            i++;
            j++;
        }
        Collections.sort(list);
        if (reverse)
            Collections.reverse(list);

        while (tempI < rLen && tempJ < cLen)    {
            grid[tempI][tempJ] = list.getFirst();
            list.removeFirst();
            sorted[tempI][tempJ] = true;
            tempI++;
            tempJ++;
        }
    }
}