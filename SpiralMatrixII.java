public class SpiralMatrixII {
    public int[][] generateMatrix(int n)    {
        int[][] ara = new int[n][n];
        int num = 1, row = 0, column = 0;
        int rowLimit = n, columnLimit = n, backRowLimit = 1, backColumnLimit = 0;
        int limit = n*n;
        while (true)    {
            while (column < columnLimit)
                ara[row][column++] = num++;

            if (num > limit)
                break;
            columnLimit--;
            column--;
            row++;

            while (row < rowLimit)
                ara[row++][column] = num++;

            if (num > limit)
                break;
            rowLimit--;
            row--;
            column--;

            while(column >= backColumnLimit)
                ara[row][column--] = num++;

            if (num > limit)
                break;

            backColumnLimit++;
            column++;
            row--;

            while (row >= backRowLimit)
                ara[row--][column] = num++;

            if (num > limit)
                break;


            backRowLimit++;
            row++;
            column++;
        }
        return ara;
    }
}
