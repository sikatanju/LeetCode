import java.nio.charset.StandardCharsets;

public class CountAlmostEqualPairsI {
    private int cnt;
    public int countPairs(int[] nums) {
        this.cnt = 0;
        for (int i=0; i<nums.length; i++)   {
            for (int j=i+1; j<nums.length; j++) {
                int num1 = nums[i], num2 = nums[j];
                if (doesMatch(num1, num2))
                    this.cnt++;
            }
        }
        return this.cnt;
    }

    private boolean doesMatch(int num1, int num2) {
        String str1 = Integer.toString(num1), str2 = Integer.toString(num2);
        while (str1.length() < str2.length())
            str1 = "0" + str1;

        while (str2.length() < str1.length())
            str2 = "0" + str2;

        int[] ara = new int[2];
        int index = 0;

        for (int i=0; i<str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))   {
                if (index > 1)
                    return false;

                ara[index++] = i;
            }
        }
        if (index == 0)
            return true;
        else {
            char[] str = str1.toCharArray();

            int index1 = ara[0];
            int index2 = ara[1];

            char temp = str[index1];
            str[index1] = str[index2];
            str[index2] = temp;
            return String.valueOf(str).equals(str2);
        }
    }
}
