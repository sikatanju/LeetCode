public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 1)
            return;

        int leftRow = len-1, rightRow = 0, upColumn = 0, downColumn = len-1;
        int leftBorder = 0, rightBorder = len-1, upBorder = len-1, downBorder = 0;
        int leftColumn = 0, rightColumn = len-1, upRow = 0, downRow = len-1;

        while (true)    {
            int tempLeftRow = leftRow, tempRightRow = rightRow, tempUpColumn = upColumn, tempDownColumn =downColumn;
            while (tempLeftRow > leftBorder)    {
                int leftTemp = matrix[tempLeftRow][leftColumn];
                int upTemp = matrix[upRow][tempUpColumn];
                int rightTemp = matrix[tempRightRow][rightColumn];
                int downTemp = matrix[downRow][tempDownColumn];
                matrix[tempLeftRow--][leftColumn] = downTemp;
                matrix[upRow][tempUpColumn++] = leftTemp;
                matrix[tempRightRow++][rightColumn] = upTemp;
                matrix[downRow][tempDownColumn--] = rightTemp;
            }
            leftRow -= 1;
            leftColumn += 1;

            rightRow += 1;
            rightColumn -= 1;

            upColumn += 1;
            upRow += 1;

            downColumn -= 1;
            downRow -= 1;

            leftBorder++;

            if (leftBorder == rightBorder)
                break;
        }
    }
}
