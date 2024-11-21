import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private int rlen;
    private int clen;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rlen = heights.length;
        this.clen = heights[0].length;
        this.heights = heights;

        List<List<Integer>> res = new ArrayList<>();

        boolean[][] p = new boolean[rlen][clen];
        boolean[][] a = new boolean[rlen][clen];

        for (int i = 0; i < clen; i++) {
            dfs(0, i, -1, p);
            dfs(rlen-1, i, -1, a);
        }
        for (int i=0; i<rlen; i++)  {
            dfs(i, 0, -1, p);
            dfs(i, clen-1, -1, a);
        }
        for (int i=0; i<rlen; i++)  {
            for (int j=0; j<clen; j++)  {
                if (p[i][j] && a[i][j])
                    res.add(List.of(i, j));
            }
        }
        return res;
    }

    private void dfs(int i, int j, int prev, boolean[][] ocean)    {
        if (i < 0 || j < 0 || i == rlen || j == clen || prev > heights[i][j] || ocean[i][j])
            return;

        ocean[i][j] = true;

        dfs(i+1, j, heights[i][j], ocean);
        dfs(i, j+1, heights[i][j], ocean);
        dfs(i-1, j, heights[i][j], ocean);
        dfs(i, j-1, heights[i][j], ocean);
    }
}
/*

private int rowLen, columnLen;
private int[][] heights;
private boolean[][] bool;

public List<List<Integer>> pacificAtlantic(int[][] heights) {
    this.rowLen = heights.length;
    this.columnLen = heights[0].length;
    this.heights = heights;
    this.bool = new boolean[rowLen][columnLen];

    List<List<Integer>> res = new ArrayList<>();

    for (int i=0; i<rowLen; i++)    {
        for (int j=0; j<columnLen; j++) {
            if (canReachAtlantic(i, j) && canReachPacific(i,j)) {
                this.bool[i][j] = true;
                res.add(List.of(i,j));
            }
        }
    }
    return res;
}

private boolean canReachPacific(int r, int c)   {
    if (canReachTop(r,c) || canReachFarLeft(r,c))
        return true;

    return false;
}
private boolean canReachAtlantic(int r, int c)  {
    if (canReachBottom(r, c) || canReachFarRight(r, c))
        return true;

    return false;
}

private boolean canReachFarRight(int r, int c)  {
    int currentValue = heights[r][c];
    for (int col=c; col<columnLen; col++)   {
        if (heights[r][col] < currentValue)
            return false;

        currentValue = heights[r][c];
    }
    return true;
}
private boolean canReachFarLeft(int r, int c)   {
    int currentValue = heights[r][c];
    for (int col=c; col>=0; col--)   {
        if (heights[r][col] < currentValue)
            return false;

        currentValue = heights[r][c];
    }
    return true;
}
private boolean canReachBottom(int r, int c)    {
    int currentValue = heights[r][c];
    for (int row=r; row<rowLen; row++)  {
        if (heights[row][c] < currentValue)
            return false;

        currentValue = heights[row][c];
    }
    return true;
}
private boolean canReachTop(int r, int c)    {
    int currentValue = heights[r][c];
    for (int row=r; row>=0; row--)    {
        if (heights[row][c] < currentValue)
            return false;

        currentValue = heights[row][c];
    }
    return true;
}
*/