public class MaxAreaOfIsland {
    private int rowLen;
    private int columnLen;
    private int count;
    public int maxAreaOfIsland(int[][] grid) {
        int maxSoFar = 0;
        rowLen = grid.length;
        columnLen = grid[0].length;

        for (int i=0; i<grid.length; i++)   {
            for (int j=0; j<grid[0].length; j++)    {
                if (grid[i][j] == 1)    {
                    this.count = 0;
                    markLand(grid, i, j);
                    if (count > maxSoFar)
                        maxSoFar = count;
                }
            }
        }
        return maxSoFar;
    }

    private void markLand(int[][] grid, int i, int j)  {
        if (i<0 || j<0 || i==rowLen || j==columnLen || grid[i][j] != 1)
            return;

        grid[i][j] = 0;
        count++;
        markLand(grid, i+1, j);
        markLand(grid, i, j+1);
        markLand(grid, i-1, j);
        markLand(grid, i, j-1);
    }
}
