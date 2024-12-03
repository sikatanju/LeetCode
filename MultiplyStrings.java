public class MultiplyStrings    {
    public String multiply(String num1, String num2)    {
        int num1Len = num1.length(), num2Len = num2.length();
        int[] result = new int[num1Len+num2Len];

        for (int i=num1Len-1; i>=0; i--)    {
            for (int j=num2Len-1; j>=0; j--)    {
                int multiply = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int position1 = i+j, position2 = i+j+1;
                int sum = multiply+result[position2];

                result[position1] += sum/10;
                result[position2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result)
            if (!(sb.length() == 0 && num == 0))
                sb.append(num);

        return sb.length() == 0 ? "0" : sb.toString();
    }
}

/* Best runtime: 1ms:

 */