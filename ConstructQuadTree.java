public class ConstructQuadTree {
    // In the problem, it's Node instead of QuadNode
    public QuadNode construct(int[][] grid) {
        return constructQuadTree(grid, 0, 0, grid.length);
    }

    private QuadNode constructQuadTree(int[][] grid, int i, int j, int len) {
        if (isAllSame(grid, i, j, len))
            return new QuadNode(grid[i][j] == 1 ? true : false, true);

        QuadNode node = new QuadNode(true, false);
        node.topLeft = constructQuadTree(grid, i, j, len/2);
        node.topRight = constructQuadTree(grid, i, j+len/2, len/2);
        node.bottomLeft = constructQuadTree(grid, i+len/2, j, len/2);
        node.bottomRight = constructQuadTree(grid, i+len/2, j+len/2, len/2);
        return node;
    }

    private boolean isAllSame(int[][]grid, int i, int j, int len)   {
        for (int k=i; k<i+len; k++) {
            for (int l=j; l<j+len; l++) {
                if (grid[k][l] != grid[i][j])
                    return false;
            }
        }
        return true;
    }
}


/* 0ms runtime :

class Solution {
    public Node construct(int[][] grid) {
        return buildQuadTree(grid,0,0,grid.length,grid[0].length);
    }
    public Node buildQuadTree(int[][] grid,int row,int col,int m,int n) {
        if(row>=m || row <0 || col>=n || col<0) {
            return null;
        }
        boolean isLeaf = true;
        int val = grid[row][col];
        for(int i = row; i < m && isLeaf; i++) {
            for(int j = col; j < n ; j++) {
                if(val != grid[i][j]) {
                    isLeaf = false;
                    break;
                }
            }
        }

        Node node = new Node(val == 1,isLeaf);
        if(!isLeaf) {
            int colMid = (col + n)/2;
            int rowMid = (row + m)/2;

            node.topLeft = buildQuadTree(grid,row,col,rowMid,colMid);
            node.topRight = buildQuadTree(grid,row,colMid,rowMid,n);
            node.bottomLeft = buildQuadTree(grid,rowMid,col,m,colMid);
            node.bottomRight = buildQuadTree(grid,rowMid,colMid,m,n);
        }

        return node;
    }
}
*/