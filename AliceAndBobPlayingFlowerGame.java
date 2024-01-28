public class AliceAndBobPlayingFlowerGame {
    public long flowerGame(int n, int m) {
        if (n == 1 && m == 1)
            return 0;

        long row = n, column = m;
        return (row*column)/2;
    }
}


/* Generated from Chatgpt:
/*
// To solve this problem efficiently, you can take advantage of the fact that the sum of two numbers is odd if and only if one number is even and the other is odd.
// Therefore, the number of pairs with an odd sum is given by the product of the counts of odd and even numbers within the specified range.


int startRow = 1;
int startCol = 1;
int endRow = n;
int endCol = m;

int countOddRows = (endRow - startRow + 1 + 1) / 2;  // Count of odd numbers in rows
int countOddCols = (endCol - startCol + 1 + 1) / 2;  // Count of odd numbers in columns

int countEvenRows = (endRow - startRow + 1) / 2;  // Count of even numbers in rows
int countEvenCols = (endCol - startCol + 1) / 2;  // Count of even numbers in columns

        return ((long) countOddRows * countEvenCols) + ((long) countEvenRows * countOddCols);
 */

/*
public long flowerGame(int n, int m) {
        if (n==1 && m == 1)
            return 0;

        long numOfSet = 0;
        int x = 1, y = 2;

        while (true)    {
            if (x > n && y > m)
                break;

            int temp = x;
            int temp2 = y;

            if (x < n && y < m) {
                x++;
                y++;
            }
            else if (x >= n)
                y++;
            else
                x++;

            if (temp <= n && temp2 <=m && ((temp + temp2) % 2 != 0))
                numOfSet += 2;
            else    {
                if (temp2 <= n && ((temp + temp2) % 2 != 0))
                    numOfSet++;
                else if (temp <= m && ((temp + temp2) % 2 != 0))
                    numOfSet++;
            }
        }

        return numOfSet;
    }
 */