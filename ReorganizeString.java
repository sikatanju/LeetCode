public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] ara = new int[26];
        for (char ch: s.toCharArray())
            ara[ch-'a']++;

        int lastChar = -1, index = 0, len = s.length();
        StringBuilder str = new StringBuilder();

        while (index<len)   {
            int tempIndex = getMaxIndex(lastChar, ara);
            if (tempIndex == -1)
                break;

            str.append((char)(tempIndex+'a'));
            ara[tempIndex]--;
            index++;
            lastChar = tempIndex;
        }

        return index == len ? str.toString() : "";
    }
    private int getMaxIndex(int lastIndex, int[] ara)   {
        int index = -1, maxCount = 0;
        for (int i=0; i<26; i++)    {
            if (ara[i] > maxCount && i != lastIndex)    {
                index = i;
                maxCount = ara[i];
            }
        }
        return index;
    }
}