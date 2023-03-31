import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // private int matrixSize;
    public List<Integer> spiralOrder(int[][] matrix)    {
        if (matrix.length == 0)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        int rowLen = matrix.length, columnLen = matrix[0].length;
        int matrixSize = rowLen*columnLen;
        int row = 0, column = 0, rowCount = 0, columnCount = 0, rowSub = 0, columnSub = -1;
        while (matrixSize > 0)  {
            int temp = columnLen - columnCount;
            for (;column < temp; column++)    {
                list.add(matrix[row][column]);
                matrixSize--;
            }
            if (matrixSize <= 0)
                break;
            columnCount++;
            row++;
            column--;
            temp = rowLen - rowCount;
            for (;row < temp; row++)    {
                list.add(matrix[row][column]);
                matrixSize--;
            }
            if (matrixSize <= 0)
                break;
            rowCount++;
            column--;
            row--;
            for (;column > columnSub; column--) {
                list.add(matrix[row][column]);
                matrixSize--;
            }
            if (matrixSize <= 0)
                break;
            columnSub++;
            column++;
            row--;
            for (;row>rowSub;row--) {
                list.add(matrix[row][column]);
                matrixSize--;
            }
            if (matrixSize <= 0)
                break;
            rowSub++;
            column++;
            row++;
        }
        return list;
    }
//    private boolean isAllThere(int num) {
//        return num == matrixSize;
//    }
}

