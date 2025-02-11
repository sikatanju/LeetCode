public class WeeklyContest435 {
    public int maxDifference(String s) {
        int maxOdd = Integer.MIN_VALUE;
        int[] ara = new int[26];
        for (var ch: s.toCharArray())   {
            ara[ch-'a']++;
        }
        for (int i=0; i<26; i++)    {
            if (ara[i] == 0 || ara[i] % 2 == 0)
                continue;

            int tempOdd = ara[i];
            for (int j=0; j<26; j++)  {
                if (ara[j] == 0 || ara[j] % 2 != 0)
                    continue;
                if (i!=j && ara[j] % 2 == 0)    {
                    int temp = tempOdd-ara[j];
                    maxOdd = Math.max(temp, maxOdd);
                }
            }
        }

        return maxOdd;
    }
}
