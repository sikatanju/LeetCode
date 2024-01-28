public class NumberOfChangingKeys {
    public int countKeyChanges(String s) {
        if (s.length() == 1)
            return 0;

        int numOfKeys = 0;
        s = s.toLowerCase();
        for (int i=1; i<s.length(); i++)    {
            if (s.charAt(i) != s.charAt(i-1))
                numOfKeys++;
        }
        return numOfKeys;
    }
}
