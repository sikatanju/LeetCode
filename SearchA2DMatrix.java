public class SearchA2DMatrix {
    private int target;
    private int row;
    private int column;
    public boolean searchMatrix (int[][] ara, int target)   {
        if (ara.length == 1 && ara[0].length == 1)
            return ara[0][0] == target;

        if (ara.length < 1 || ara == null)
            return false;

        this.target = target;
        this.row = ara.length-1;
        this.column = ara[0].length-1;
        if (this.row == 0)
            return findColumn(ara, 0, column);

        int targetRow = findRow(ara, row, column);
        return findColumn(ara, targetRow, column);
    }

    private int findRow (int[][] ara, int row, int column)  {
        while (row <= this.row && row >= 0)    {
            if (row == 0 && ara[row][column] >= target)
                return row;
            else if (ara[row][column] >= target && ara[row-1][column] < target)
                return row;

            if (ara[row][column] < target)
                row++;
            else
                row--;
        }
        return this.row;
    }
    private boolean findColumn(int[][]ara, int row, int column) {
        int left = 0;
        int right = column;
        while (left <= right)   {
            int middle = (left+right)/2;
            if (ara[row][middle] == target)
                return true;

            if (ara[row][middle] < target)
                left = middle+1;
            else
                right = middle-1;
        }
        return false;
    }
}
