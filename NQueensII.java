import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    private int numOfSolution;
    public int totalNQueens(int n) {
        this.numOfSolution = 0;
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        backtrack(0, n, col, posDiag, negDiag);
        return this.numOfSolution;
    }

    private void backtrack(int row, int n, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag)    {
        if (row == n)   {
            this.numOfSolution++;
            return;
        }
        for (int i=0; i<n; i++) {
            if (col.contains(i) || posDiag.contains(row+i) || negDiag.contains(row-i))
                continue;

            col.add(i);
            posDiag.add(row+i);
            negDiag.add(row-i);

            backtrack(row+1, n, col, posDiag, negDiag);

            col.remove(i);
            posDiag.remove(row+i);
            negDiag.remove(row-i);
        }
    }
}
