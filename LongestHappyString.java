public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder str = new StringBuilder();

        int[] ara = new int[]{a, b, c};
        int repeatedChar = -1;

        while (true)    {
            int index = getMaxIndex(ara, repeatedChar);
            if (index == -1)
                break;

            str.append((char)(index + 'a'));
            ara[index]--;

            if (str.length() > 1 && (str.charAt(str.length()-1) == str.charAt(str.length()-2)))
                repeatedChar = index;
            else
                repeatedChar = -1;
        }
        return str.toString();
    }
    private int getMaxIndex(int[] ara, int repeatedChar)    {
        int maxCount = 0, index = -1;
        for (int i=0; i<3; i++) {
            if (i == repeatedChar)  {
                continue;
            }
            if (maxCount < ara[i])  {
                maxCount = ara[i];
                index = i;
            }
        }
        return index;
    }
}