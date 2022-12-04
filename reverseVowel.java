// import java.util.ArrayList;
/*
public class reverseVowel   {
    public String reverseVowels(String str) {
        // String reverse = "";
        // ArrayList<Character> araList = new ArrayList<>();
        int left = 0, right = str.length()-1;
        char[] ch = str.toCharArray();

        while (left < right)    {
            left = findLeft(str, left, right);
            right = findRight(str, left, right);
            if (left < right)   {
                char temp = ch[left];
                ch[left++] = ch[right];
                ch[right--] = temp;
            }
        }
        return new String(ch);
    }

    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }

    public int findLeft(String str, int left, int right)   {
        while (left < right)    {
            if (isVowel(str.charAt(left)))   {
                return left;
            }
            else
                left++;
        }
        return left;
    }

    public int findRight(String str, int left, int right)   {
        while (left < right)    {
            if (isVowel(str.charAt(right)))   {
                return right;
            }
            else
                right--;
        }
        return right;
    }
} */