/*public class validAnargramReloaded {
    public boolean isAnargram(String s, String t)   {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
            count[ch - 'a']--;
        }

        for (int temp : count)   
            if (temp != 0)  return false;

        return true;
    }
}
*/