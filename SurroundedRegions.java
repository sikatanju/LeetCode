public class SurroundedRegions {
    private int rowLen;
    private int columnLen;

    public void solve(char[][] board) {
        this.rowLen = board.length;
        if (rowLen == 0 || rowLen == 1 || rowLen == 2)
            return;

        this.columnLen = board[0].length;

        for (int i=0; i<columnLen; i++)    {
            DFS(board, 0, i);
            DFS(board, rowLen-1, i);
        }

        for (int i=0; i<rowLen; i++) {
            DFS(board, i, 0);
            DFS(board, i, columnLen-1);
        }

        for (int i=0; i<rowLen; i++)    {
            for (int j=0; j<columnLen; j++) {
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void DFS(char[][] board, int rowIndex, int columnIndex) {
        if (rowIndex < 0 || columnIndex < 0 || rowIndex == rowLen || columnIndex == columnLen || board[rowIndex][columnIndex] != 'O')
            return;

        board[rowIndex][columnIndex] = 'Y';
        DFS(board, rowIndex+1, columnIndex);
        DFS(board, rowIndex-1, columnIndex);
        DFS(board, rowIndex, columnIndex+1);
        DFS(board, rowIndex, columnIndex-1);
    }
/*
    private int rowLen;
    private int columnLen;

    private List<int[]> list;

    public void solve(char[][] board) {
        rowLen = board.length;
        if (rowLen == 1 || rowLen == 2)
            return;

        columnLen = board[0].length;

        boolean upTrue = false;
        boolean downTrue = false;
        boolean leftTrue = false;
        boolean rightTrue = false;

        List<int[]> upDownList = new ArrayList<>();
        List<int[]> leftRightList = new ArrayList<>();
        list = new ArrayList<>();

        for (int i=1; i<rowLen-1; i++)  {
            for (int j=1; j<columnLen-1; j++)   {
                if (board[i][j] == 'O') {
                    if (j-1 > -1 && board[i][j-1] == 'X' && i-1 > -1 && board[i-1][j] == 'X' && i+1 < rowLen &&  board[i+1][j] == 'X' && j+1 < columnLen && board[i][j+1] == 'X')
                        board[i][j] = 'X';
                    else {
                        list.add(new int[]{i, j});
                        int copy = j+1;
                        while (copy < columnLen && board[i][copy] != 'X')   {
                            list.add(new int[]{i, copy});
                            leftRightList.add(new int[]{i, copy++});
                        }
                        if (copy < columnLen && board[i][copy] == 'X')
                            rightTrue = true;

                        copy = j-1;
                        while (copy > -1 && board[i][copy] != 'X')  {
                            list.add(new int[]{i, copy});
                            leftRightList.add(new int[]{i, copy--});
                        }

                        if (copy >= 0 && board[i][copy] == 'X')
                            leftTrue = true;

                        copy = i-1;
                        while (copy > -1 && board[copy][j] != 'X')  {
                            list.add(new int[]{copy, j});
                            upDownList.add(new int[]{copy--, j});
                        }

                        if (copy > -1 && board[copy][j] == 'X')
                            upTrue = true;

                        copy = i+1;
                        while (copy < rowLen && board[copy][j] != 'X')  {
                            list.add(new int[]{copy, j});
                            upDownList.add(new int[]{copy++, j});
                        }
                        if (copy < rowLen && board[copy][j] == 'X')
                            downTrue = true;

                        boolean ifAnyFalse = false;
                        for (var temp : upDownList)   {
                            if(!checkLeftRight(board, temp[0], temp[1]))
                                ifAnyFalse = true;
                        }
                        for (var temp: leftRightList)   {
                            if (!checkUpDown(board, temp[0], temp[1]))
                                ifAnyFalse = true;
                        }
                        if (!ifAnyFalse && upTrue && downTrue && leftTrue && rightTrue) {
                            for (var temp: list)
                                board[temp[0]][temp[1]] = 'X';
                        }
                    }
                }
                leftRightList = new ArrayList<>();
                upDownList = new ArrayList<>();
                list = new ArrayList<>();
            }
        }
    }
    private boolean checkLeftRight(char[][] board, int i, int j) {
        boolean leftTrue = false;
        boolean rightTrue = false;

        for (; i < rowLen; i++) {
            for (; j < columnLen; j++) {
                if (board[i][j] == 'O') {
                    if (j-1 > -1 && board[i][j-1] == 'X' && i-1 > -1 && board[i-1][j] == 'X' && i+1 < rowLen &&  board[i+1][j] == 'X' && j+1 < columnLen && board[i][j+1] == 'X')
                        board[i][j] = 'X';
                    else {
                        int copy = j + 1;
                        while (copy < columnLen && board[i][copy] != 'X')
                            list.add(new int[]{i, copy++});
                        if (copy < columnLen && board[i][copy] == 'X')
                            rightTrue = true;

                        copy = j - 1;
                        while (copy > -1 && board[i][copy] != 'X')
                            list.add(new int[]{i, copy--});
                        if (copy >= 0 && board[i][copy] == 'X')
                            leftTrue = true;

                        return (leftTrue && rightTrue);
                    }
                }
            }
        }
        return true;
    }
    private boolean checkUpDown(char[][] board, int i, int j)    {
        boolean upTrue = false;
        boolean downTrue = false;

        for(; i<rowLen; i++)  {
            for (; j<columnLen; j++)   {
                if (board[i][j] == 'O') {
                    if (j-1 > -1 && board[i][j-1] == 'X' && i-1 > -1 && board[i-1][j] == 'X' && i+1 < rowLen &&  board[i+1][j] == 'X' && j+1 < columnLen && board[i][j+1] == 'X')
                        board[i][j] = 'X';
                    else {
                        int copy = i-1;
                        while (copy > -1 && board[copy][j] != 'X')
                            list.add(new int[]{copy--, j});
                        if (copy > -1 && board[copy][j] == 'X')
                            upTrue = true;

                        copy = i+1;
                        while (copy < rowLen && board[copy][j] != 'X')
                            list.add(new int[]{copy++, j});
                        if (copy < rowLen && board[copy][j] == 'X')
                            downTrue = true;

                        return (downTrue && upTrue);
                    }
                }
            }
        }
        return true;
    }*/
}


/* Best Runtime 0ms :

class Solution {
    public void solve(char[][] grid) {
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]!='X')
            DFS(i,0,grid);
            if(grid[i][grid[0].length-1]!='X')
            DFS(i,grid[0].length-1,grid);
        }
        for(int i=0;i<grid[0].length-1;i++){
            if(grid[0][i]!='X')
            DFS(0,i,grid);
            if(grid[grid.length-1][i]!='X')
            DFS(grid.length-1,i,grid);
        }
        swap(grid,'O','X');
        swap(grid,'p','O');
    }

    void swap(char[][] grid,char p, char q){
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                    if(grid[i][j]==p) grid[i][j]=q;
    }

    void DFS(int i,int j, char[][] grid){
        if(!(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='O')) return ;
        grid[i][j]='p';
        DFS(i+1,j,grid);
        DFS(i,j+1,grid);
        DFS(i-1,j,grid);
        DFS(i,j-1,grid);
    }
}

########################## Second best 1ms :

class Solution {

    public void solve(char[][] board) {
        int nRows = board.length;
        int nCols = board[0].length;

        // 1a) Capture unsurrounded regions - top and bottom row (O -> T)
        for (int i = 0; i < nCols; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[nRows - 1][i] == 'O') dfs(board, nRows - 1, i);
        }

        // 1b) Capture unsurrounded regions - Left and right columns (O -> T)
        for (int i = 0; i < nRows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][nCols - 1] == 'O') dfs(board, i, nCols - 1);
        }

        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nCols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X'; // 2) Capture surrounded regions (O -> X)
                if (board[r][c] == 'T') board[r][c] = 'O'; // 3) Uncapture unsurrounded regions (T -> O)
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int nRows = board.length;
        int nCols = board[0].length;
        if (
            r < 0 || c < 0 || r >= nRows || c >= nCols || board[r][c] != 'O'
        ) return;

        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}


###########################














Solution :

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //Any 'O' connected to a boundary can't be turned to 'X', so ...
        //Start from first and last column, turn 'O' to '*'.
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        //Start from first and last row, turn '0' to '*'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
//Use DFS algo to turn internal however boundary-connected 'O' to '*';
private void boundaryDFS(char[][] board, int i, int j) {
	if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
		return;
	if (board[i][j] == 'O')
		board[i][j] = '*';
	if (i > 1 && board[i-1][j] == 'O')
		boundaryDFS(board, i-1, j);
	if (i < board.length - 2 && board[i+1][j] == 'O')
		boundaryDFS(board, i+1, j);
	if (j > 1 && board[i][j-1] == 'O')
		boundaryDFS(board, i, j-1);
	if (j < board[i].length - 2 && board[i][j+1] == 'O' )
		boundaryDFS(board, i, j+1);
}


############ Another one : public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;

        int rowN = board.length;
        int colN = board[0].length;
        Queue<Point> queue = new LinkedList<Point>();

       //get all 'O's on the edge first
        for (int r = 0; r< rowN; r++){
        	if (board[r][0] == 'O') {
        		board[r][0] = '+';
                queue.add(new Point(r, 0));
        	}
        	if (board[r][colN-1] == 'O') {
        		board[r][colN-1] = '+';
                queue.add(new Point(r, colN-1));
        	}
        	}

        for (int c = 0; c< colN; c++){
        	if (board[0][c] == 'O') {
        		board[0][c] = '+';
                queue.add(new Point(0, c));
        	}
        	if (board[rowN-1][c] == 'O') {
        		board[rowN-1][c] = '+';
                queue.add(new Point(rowN-1, c));
        	}
        	}


        //BFS for the 'O's, and mark it as '+'
        while (!queue.isEmpty()){
        	Point p = queue.poll();
        	int row = p.x;
        	int col = p.y;
        	if (row - 1 >= 0 && board[row-1][col] == 'O') {board[row-1][col] = '+'; queue.add(new Point(row-1, col));}
        	if (row + 1 < rowN && board[row+1][col] == 'O') {board[row+1][col] = '+'; queue.add(new Point(row+1, col));}
        	if (col - 1 >= 0 && board[row][col - 1] == 'O') {board[row][col-1] = '+'; queue.add(new Point(row, col-1));}
            if (col + 1 < colN && board[row][col + 1] == 'O') {board[row][col+1] = '+'; queue.add(new Point(row, col+1));}
        }


        //turn all '+' to 'O', and 'O' to 'X'
        for (int i = 0; i<rowN; i++){
        	for (int j=0; j<colN; j++){
        		if (board[i][j] == 'O') board[i][j] = 'X';
        		if (board[i][j] == '+') board[i][j] = 'O';
        	}
        }


    }
}

######### Another one : class Solution {
    public void solve(char[][] board) {
        // Base condition
        if(board.length == 0) return;
        // 1st Loop : Traversing over top column & bottom column, to find any 'O' present by the boundary
        for(int i = 0; i < board[0].length; i++){
            if(board[0][i] == 'O'){
                DFS(board, 0, i);
            }
            if(board[board.length - 1][i] == 'O'){
                DFS(board, board.length - 1, i);
            }
        }
        // 2nd Loop : Traversing over left row & right row, to find any 'O' present by the boundary
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O'){
                DFS(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O'){
                DFS(board, i, board[0].length - 1);
            }
        }
        // 3rd Loop : Now in this we will traverse on each n every node & check if they are 'O' convert into 'X', if they are '@' convert into 'O'
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '@'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    // This calls helps in convert the 'O' node present near by the boundary convert them into '@'
    public void DFS(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '@';
        DFS(board, i + 1, j);
        DFS(board, i - 1, j);
        DFS(board, i, j + 1);
        DFS(board, i, j - 1);
    }
}
 */