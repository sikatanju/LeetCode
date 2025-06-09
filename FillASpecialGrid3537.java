public class FillASpecialGrid3537 {
    private int val;
    public int[][] specialGrid(int n) {
        int size = 1 << n;

        int[][] grid = new int[size][size];
        this.val = (size*size)-1;
        solve(grid, 0, 0, size);
        return grid;
    }

    private void solve(int[][] grid, int r, int c, int size)    {
        if (size == 1)  {
            grid[r][c] = val--;
            return;
        }

        int ss = size/2;
        solve(grid, r, c, ss);
        solve(grid, r+ss, c, ss);
        solve(grid, r+ss, c+ss, ss);
        solve(grid, r, c+ss, ss);
    }
}