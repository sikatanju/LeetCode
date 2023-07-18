import java.util.ArrayList;
import java.util.List;


public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
//        if (matrix[0].length == 1)  {
//
//        }

        List<int[]> zero = new ArrayList<>();
        int rowSize = matrix.length, columnSize = matrix[0].length;

        for (int i=0; i<rowSize; i++) {
            for (int j=0; j<columnSize; j++)  {
                if (matrix[i][j] == 0)  {
                    zero.add(new int[]{i, j});
                }
            }
        }
        for (int[] temp : zero) {
            int rowNo = temp[0];
            int columnNo = temp[1];
            int rowIterate = 0, columnIterate = 0;

            do {
                if (columnIterate < columnSize)
                    matrix[rowNo][columnIterate++] = 0;

                if (rowIterate < rowSize)
                    matrix[rowIterate++][columnNo] = 0;

            }   while ((columnIterate != columnSize || rowIterate != rowSize));
        }
        for (int[] ara : matrix) {
            for (int num : ara) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
