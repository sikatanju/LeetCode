public class RangeSumQuery2DImmutable {
//    public NumMatrix(int[][] matrix) {
    private int[][] matrix;
    private int[][] prefixSumCol;
    private int[][] prefixSumRow;
    private int rowLen, columnLen;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        this.matrix = matrix;
        rowLen = matrix.length;
        columnLen = matrix[0].length;
        this.prefixSumCol = new int[rowLen][columnLen+1];
        this.prefixSumRow = new int[rowLen+1][columnLen];

        for (int i=0; i<rowLen; i++)   {
            for (int j=1; j<=columnLen; j++)
                prefixSumCol[i][j] = prefixSumCol[i][j-1] + matrix[i][j-1];
        }
        for (int j=0; j<columnLen; j++) {
            for (int i=1; i<=rowLen; i++)
                prefixSumRow[i][j] = prefixSumRow[i-1][j] + matrix[i-1][j];
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if (row1 == row2 && col1 == col2)
            return matrix[row1][col1];
        if (row1 == row2)   {
            return prefixSumCol[row1][col2+1]-prefixSumCol[row2][col1];
        }   else if (col1 == col2)  {
            return prefixSumRow[row2+1][col1]-prefixSumRow[row1][col2];
        }   else {
            int tempRow = row1;
            while (tempRow <= row2) {
                sum += ( prefixSumCol[tempRow][col2+1] - prefixSumCol[tempRow][col1]);
                tempRow++;
            }
        }
        return sum;
    }
}

/* Best runtime: 101ms:
class NumMatrix {
    int[][] matSum;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix[0].length == 0) return;
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        matSum = new int[ROWS + 1][ COLS + 1];
        for(int i = 0 ; i < ROWS ; i++){
            int prefix = 0;
            for(int j = 0 ; j < COLS ; j++){
                prefix += matrix[i][j];
                matSum[i+1][j+1] = matSum[i][j+1]  //above
                                    + prefix; //current
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int allInclusive = matSum[row2][col2];
        int above = matSum[row1-1][col2];
        int left = matSum[row2][col1-1];
        int subtractedTwice = matSum[row1-1][col1-1];

        return allInclusive - above - left + subtractedTwice;
    }
}

/* Best Memory:
class NumMatrix {
    int[][] matrix;
    int[][] prefixsum; //matrix index + 1

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        prefixsum = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i < matrix.length+1; i++){
            for(int j = 1; j < matrix[0].length+1; j++){
                prefixsum[i][j] = prefixsum[i-1][j] + prefixsum[i][j-1] - prefixsum[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        System.out.println();
        System.out.println(prefixsum[row2+1][col2+1]);
        System.out.println(prefixsum[row2 - row1][col2+1]);
        System.out.println(prefixsum[row2+1][col2-col1]);
        System.out.println(prefixsum[row1][col1]);

        return prefixsum[row2+1][col2+1]
        - prefixsum[row1][col2+1]
        - prefixsum[row2+1][col1]
        + prefixsum[row1][col1];
    }
}

*/
