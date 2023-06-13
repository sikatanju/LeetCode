
public class IsSubsequence {
    public boolean isSubsequence(String s, String t)    {
        int sLength = s.length();
        int tLength = t.length();


        if (sLength == 0 && tLength == 0)
            return true;
        if (sLength == 0)
            return true;
        if (tLength == 0)
            return false;

        int forS = 0;
        boolean[] bb = new boolean[sLength];
        for (int i=0; i<t.length(); i++)    {
            if (sLength != forS)    {
                if (s.charAt(forS) == t.charAt(i))
                    bb[forS++] = true;
            }

        }
        for (boolean check : bb)
            if (check == false)
                return false;

        return true;
    }
}
