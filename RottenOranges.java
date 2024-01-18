public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0)
            return -1;

        int time = 2;
        for (int i=0; i<grid.length; i++)   {
            for (int j=0; j<grid[0].length; j++)    {
                if (grid[i][j] == 2)
                    bfs(grid, i, j, time);

            }
        }
        for (int i=0; i<grid.length; i++)   {
            for (int j=0; j<grid[0].length; j++)    {
                if (grid[i][j] == 1)
                    return -1;

                time = Math.max(time, grid[i][j]);
            }
        }
        return time-2;
    }

    private void bfs(int[][] grid, int i, int j, int time)  {
        if (i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < time))
            return;
        else {
            grid[i][j] = time;
            bfs(grid, i+1, j, time+1);
            bfs(grid, i-1, j, time+1);
            bfs(grid, i, j-1, time+1);
            bfs(grid, i, j+1, time+1);
        }
    }
}


/* Runtime: 2ms :
class pair{
    int row;
    int col;
    int tm;
    pair(int row,int col,int tm)
    {
        this.row=row;
        this.col=col;
        this.tm=tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]= new int[n][m];
        Queue<pair> q= new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }
        int tm=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow= r+drow[i];
                int ncol=c+ dcol[i];
                if(ncol>=0 && ncol<m && nrow>=0 && nrow<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1)
                {
                    q.add(new pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]!=2 && grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return tm;
    }
}

 */



/*
    public int orangesRotting(int[][] grid) {
        int count = 0, plant = 2, rowLen = grid.length, columnLen = grid[0].length;
        int totalFreshOrange = 0, totalRottenOrange = 0;
        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (grid[i][j] == 1)
                    totalFreshOrange++;
                if (grid[i][j] == 2)
                    totalRottenOrange++;
            }
        }
        if (totalFreshOrange == 0)
            return 0;
        if (totalRottenOrange == 0)
            return -1;

        if (isAnyLonelyOrange(grid))
            return -1;

        if (rowLen == 1 || columnLen == 1)  {
            if (rowLen==1)  {
                for (int i=0; i<columnLen; i++) {
                    if (grid[0][0] == 2)    {
                        if (i-1 >= 0 && grid[0][i-1] == 1)  {
                            grid[0][i-1] = 2;
                            totalFreshOrange--;
                            count++;
                        }
                        if (i+1 < columnLen && grid[0][i+1] == 1)   {
                            grid[0][i+1] = 2;
                            totalFreshOrange--;
                            count++;
                        }
                    }
                }
                if (totalFreshOrange == 0)
                    return count;
                else
                    return -1;
            }
            else {
                for (int i=0; i<rowLen; i++)    {
                    if (grid[i][0] == 2)    {
                        if (i-1 >= 0 && grid[i-1][0] == 1)  {
                            grid[i-1][0] = 2;
                            totalFreshOrange--;
                            count++;
                        }
                        if (i+1 < rowLen && grid[i+1][0] == 1)  {
                            grid[i+1][0] = 2;
                            totalFreshOrange--;
                            count++;
                        }
                    }
                }
                if (totalFreshOrange == 0)
                    return count;
                else
                    return -1;
            }
        }

        while (totalFreshOrange > 0)    {
            for (int i=0; i<rowLen; i++)    {
                for (int j=0; j<columnLen; j++) {
                    if (grid[i][j] == 0)
                        continue;
                    if (grid[i][j] == plant)    {
                        if (i-1 >= 0 && grid[i-1][j] == 1)  {
                            grid[i-1][j] = plant+1;
                            totalFreshOrange--;
                        }
                        if (i+1 < rowLen && grid[i+1][j] == 1) {
                            grid[i+1][j] = plant+1;
                            totalFreshOrange--;
                        }
                        if (j-1 >= 0 && grid[i][j-1] == 1) {
                            grid[i][j-1] = plant+1;
                            totalFreshOrange--;
                        }
                        if (j+1 < columnLen && grid[i][j+1] == 1)  {
                            grid[i][j+1] = plant+1;
                            totalFreshOrange--;
                        }
                    }
                }
            }
            count++;
            plant++;
        }
        return count;
    }
    private boolean isAnyLonelyOrange(int[][] grid)  {
        int rowLen = grid.length, columnLen = grid[0].length;
        for (int i=0; i<rowLen; i++)    {

            for (int j=0; j<columnLen; j++) {
                boolean up = false, down = false, right = false, left = false;
                int orange = grid[i][j];
                if (grid[i][j] == 2 || grid[i][j] == 0)
                    continue;
                else {
                    if (i-1 < 0)
                        up = true;
                    else if (grid[i-1][j] == 0)
                        up = true;

                    if (i+1 == rowLen)
                        down = true;
                    else if (i+1 < rowLen && grid[i+1][j] == 0)
                        down = true;

                    if (j-1 < 0)
                        left = true;
                    else if (grid[i][j-1] == 0)
                        left = true;

                    if (j+1 == columnLen)
                        right = true;
                    else if (j+1 < columnLen && grid[i][j+1] == 0)
                        right = true;

                    if (up && down && left && right)
                        return true;
                }
            }
        }
        return false;
    }
 */