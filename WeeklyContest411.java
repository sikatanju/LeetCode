public class WeeklyContest411 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long sumA = 0, sumB = 0;

        for (int i=0; i<energyDrinkA.length; i++)   {
            long aa = Math.max(sumA+energyDrinkA[i], sumB);
            long bb = Math.max(sumB+energyDrinkB[i], sumA);
            sumA = aa;
            sumB = bb;
        }
        return Math.max(sumA, sumB);
    }
}

/*
public int countKConstraintSubstrings(String s, int k) {
        int count = 0, len=s.length();
        char[] arr = s.toCharArray();

        for (int i=0; i<len; i++)   {
            for (int j=i+1; j<=len; j++)  {
                if (check(s.substring(i, j), k))
                    count++;
            }
        }
        return count;
    }

    private boolean check(String str, int k)    {
        int one = 0, zero = 0;
        for (char ch: str.toCharArray())    {
            if (ch == '1')
                one++;
            else if (ch == '0')
                zero++;

            if (one > k && zero > k)
                return false;
        }
        return true;
    }
 */

/*
    public long maxEnergyBoost(int[] a, int[] b) {
        int len = a.length;
        long one = a[0], two = b[0];
        int oneArr = 1, twoArr = 2;

        for (int i=1; i<a.length; i++)  {
            if (a[i] > b[i])    {
                if (oneArr == 2)    {
                    long temp = one - b[i-1];
                    if (temp+a[i] > one+b[i])   {
                        oneArr = 1;
                        one = temp + a[i];
                    }   else {
                        one += b[i];
                    }
                }
                else {
                    one += a[i];
                }
                if (twoArr == 2)    {
                    long temp = two - b[i-1];
                    if (temp+a[i] > two+b[i])   {
                        twoArr = 1;
                        two = temp + a[i];
                    }   else {
                        two += b[i];
                    }
                }   else {
                    two += a[i];
                }
            }
            else if (b[i] > a[i])   {
                if (oneArr == 1)    {
                    long temp = one - a[i-1];
                    if (temp+b[i] > one+a[i])  {
                        oneArr = 2;
                        one = temp + b[i];
                    }   else {
                        one += a[i];
                    }
                }   else {
                    one += b[i];
                }
                if (twoArr == 1)    {
                    long temp = two - a[i-1];
                    if (temp+b[i] > two+a[i])   {
                        twoArr = 2;
                        two = temp + b[i];
                    }   else {
                        two += a[i];
                    }
                }   else {
                    two = two + b[i];
                }
            }
            else {
                one += a[i];
                two += b[i];
            }
        }

        return Math.max(one, two);
    }
 */