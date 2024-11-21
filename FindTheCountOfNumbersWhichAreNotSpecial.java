// From Leetcode Contest -- 408
public class FindTheCountOfNumbersWhichAreNotSpecial {
    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r);
        boolean[] isNotPrime = new boolean[limit+1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i=2; i<=limit; i++)    {
            if (!isNotPrime[i])    {
                for (int j=i*i; j<=limit; j += i)
                    isNotPrime[j] = true;
            }
        }
        int speacialCount = 0;
        for (int i=2; i<=limit; i++)    {
            if (!isNotPrime[i])    {
                if (i*i >= l && i*i <= r)
                    speacialCount++;
            }
        }
        return r-l+1-speacialCount;
    }
}

/* From Best solution :
private static HashSet<Integer> set = new HashSet<>() {
        {
            boolean[] flag = new boolean[31608];
            for (int i = 2; i < 31608; i++) {
                if (!flag[i]) {
                    add(i);
                    for (int j = 2 * i; j < 31608; j += i) {
                        flag[j] = true;
                    }
                }
            }
        }
    };

    public int nonSpecialCount(int l, int r) {
        int count = r - l + 1;
        for (int i : set) {
            count -= i * i < l || i * i > r ? 0 : 1;
        }
        return count;
    }
 */

/*

    private static HashSet<Integer> set = new HashSet<>() {
        {
            boolean[] flag = new boolean[31608];
            for (int i = 2; i < 31608; i++) {
                if (!flag[i]) {
                    add(i);
                    for (int j = 2 * i; j < 31608; j += i) {
                        flag[j] = true;
                    }
                }
            }
        }
    };

    public int nonSpecialCount(int l, int r) {
        int count = r - l + 1;
        for (int i : set) {
            count -= i * i < l || i * i > r ? 0 : 1;
        }
        return count;
    }
}
// Explanation Link: https://leetcode.com/problems/find-the-count-of-numbers-which-are-not-special/description/
class SolutionFF {
    public int nonSpecialCount(int l, int r) {
        // Calculate the limit up to which we need to find prime numbers
        int lim = (int) Math.sqrt(r);

        // Create an array to mark primes up to lim using Sieve of Eratosthenes
        boolean[] isPrime = new boolean[lim + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime numbers

        // Sieve of Eratosthenes to mark non-prime numbers
        for (int i = 2; i * i <= lim; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= lim; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count special numbers in the range [l, r]
        int specialCount = 0;
        for (int i = 2; i <= lim; i++) {
            if (isPrime[i]) {
                int square = i * i;
                if (square >= l && square <= r) {
                    specialCount++;
                }
            }
        }

        // Total numbers in the range [l, r]
        int totalCount = r - l + 1;

        // Calculate non-special numbers
        return totalCount - specialCount;
    }
 */