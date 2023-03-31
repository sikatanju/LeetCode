public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] ara, int target)    {
        if (ara == null || ara.length == 0 || ara[0].length == 0)
            return false;

        int row = 0;
        int column = ara[0].length-1;

        while (column >= 0 && row < ara.length) {
            int pivot = ara[row][column];
            if (pivot == target)
                return true;

            else if (target < pivot)
                column--;
            else
                row++;
        }
        return false;
    }
}


    /*public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
/*public boolean searchMatrix (int[][] ara, int target)   {
        if (ara == null && ara.length == 0)
            return false;
        return searchMatrix(ara, target, 0, 0, ara[0].length, ara.length);
    }
    public boolean searchMatrix(int[][] ara, int target, int left, int top, int right, int bottom)  {
        if (left > right || top > bottom)
            return false;

        if (left == right && top == bottom)
            return ara[top][left] == target;

        int gX = (left+right)/2;
        int gY = (top+bottom)/2;
        int pivot = ara[gY][gX];

        if (pivot < target) {
            boolean firstCheck = searchMatrix(ara, target, gX+1, top, right, gY);
            boolean secondCheck = searchMatrix(ara, target, left, gY+1, gX, bottom);
            boolean thirdCheck = searchMatrix(ara, target, gX+1, gY+1, right, bottom);
            return firstCheck || secondCheck || thirdCheck;
        }
        else if (pivot > target)    {
            boolean firstCheck = searchMatrix(ara, target, left, top, gX, gY);
            boolean secondCheck = searchMatrix(ara, target, gX+1, top, right, gY);
            boolean thirdCheck = searchMatrix(ara, target, left, gY+1, gX, bottom);
            return firstCheck || secondCheck || thirdCheck;
        }
        return true;
    }
    */


    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;

        return searchMatrix(matrix, target, 0,0, matrix[0].length-1, matrix.length-1);
    }

     */
