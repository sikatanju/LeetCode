/*

public class WeeklyContest408 {
    class SolutionW {

        public boolean canAliceWin(int[] nums) {
            int count = 0;
            for (int num : nums) {
                count += num > 9 ? num : -num;
            }
            return count != 0;
        }
    }

    public boolean canAliceWin(int[] nums) {
        int sumSingle = 0, sumDouble = 0;

        for (int num: nums) {
            if (num / 10 > 0)
                sumDouble += num;
            else
                sumSingle += num;
        }
        return (sumSingle > sumDouble) || (sumDouble > sumSingle);
    }

    public int nonSpecialCount(int l, int r) {
        int notProperDivisor = 0;
        for (int i=l; i<=r; i++)    {
            if (isPrime(i) || moreThanTwoDivisor(i))
                notProperDivisor++;
        }
        return notProperDivisor;
    }

    private boolean moreThanTwoDivisor(int num) {
        int count = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            if (count > 2)
                return true;
        }
        if (count < 2)
            return true;

        return false;
    }
    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int numberOfSubstrings(String s) {
        int numOfSubstring = 0;
        for (int i=0; i<s.length(); i++)    {
            for (int j=i; j<s.length(); j++)  {
                if (checkIfDominant(s.substring(i, j+1)))  {
                    numOfSubstring++;
                }
            }
        }
        return numOfSubstring;
    }

    private boolean checkIfDominant(String substring) {
        int numOfOne = 0, numOfZero = 0;
        for (int i=0; i<substring.length(); i++)    {
            String str = "";
            str += substring.charAt(i);
            int num = Integer.parseInt(str);
            if (num == 0)
                numOfZero++;
            else
                numOfOne++;
        }
        numOfZero = (int) Math.pow(numOfZero, 2);
        return numOfOne >= numOfZero;
    }
}

*/