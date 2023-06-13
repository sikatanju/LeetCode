public class ReverseWordsInAString {
    public String reverseWords(String s)    {
        String[] words = s.trim().replaceAll(" +", " ").split(" ");
        if (words.length == 1)
            return words[0];

        s = "";
        for (int i=words.length-1; i>= 0; i--)  {
            s += words[i];
            if (i != 0)
                s += " ";
        }
        return s;
    }
}


/* 1ms runtime example :

class Solution {
    public String reverseWords(String s) {
        int position = s.length() - 1;
        int left;
        int right;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        while ((right = getRight(position, chars)) != -1) {
            left = getLeft(right, chars);
            addReversedString(sb, left, right, chars);
            position = left - 1;

        }
        return sb.toString();
    }
    private void addReversedString(StringBuilder sb, int left, int right, char[] chars) {
        if (sb.length() > 0)
            sb.append(' ');

        while (left <= right) {
            sb.append(chars[left++]);
        }
    }

    private int getLeft(int right, char[] chars) {
        while (right >= 0) {
            if (chars[right] == ' ') {
                return right + 1;
            }
            right--;
        }
        return 0;
    }

    private int getRight(int position, char[] chars) {
        while (position >= 0) {
            if (chars[position] != ' ')
                return position;

            position--;
        }
        return -1;
    }
}
 */