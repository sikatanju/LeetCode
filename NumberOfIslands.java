public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int rowLen = grid.length;
        int columnLen = grid[0].length;

        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (grid[i][j] == '1')  {
                    dfs(grid, i, j, rowLen, columnLen);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    private void dfs(char[][] ara, int rowIndex, int columnIndex, int rowLen, int columnLen)    {
        if (rowIndex<0 || columnIndex < 0 || rowIndex == rowLen || columnIndex == columnLen || ara[rowIndex][columnIndex] != '1')
            return;

        ara[rowIndex][columnIndex] = '7';
        dfs(ara, rowIndex+1, columnIndex, rowLen, columnLen);
        dfs(ara, rowIndex, columnIndex+1, rowLen, columnLen);
        dfs(ara, rowIndex, columnIndex-1, rowLen, columnLen);
        dfs(ara, rowIndex-1, columnIndex, rowLen, columnLen);
    }
}
