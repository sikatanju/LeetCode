public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder strBuilder = new StringBuilder();
        int aLen = a.length()-1, bLen = b.length()-1;
        int sum = 0, carry = 0;

        while (aLen >= 0 || bLen >= 0)  {
            sum = carry;

            if (aLen >= 0)
                sum += getInt(a.charAt(aLen--));
            if (bLen >= 0)
                sum += getInt(b.charAt(bLen--));

            strBuilder.append(sum%2);
            carry = sum / 2;
        }
        if (carry == 1)
            strBuilder.append(1);

        return strBuilder.reverse().toString();
    }
    private int getInt(int asciiValue)  {
        return asciiValue%48;
    }
}


/*

        StringBuilder stringBuilder = new StringBuilder();
        int aLen = a.length(), bLen = b.length();
        int aIndex = aLen-1, bIndex = bLen-1, carry = 0;
        if (aLen > bLen)    {
            while (bIndex >= 0)  {
                int tempA = getInt(a.charAt(bIndex));
                int tempB = getInt(b.charAt(bIndex--));
                aIndex--;
                if ((tempA == 0 && tempB == 1) || (tempA == 1 && tempB == 0))   {
                    if (carry == 0) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else    {
                        stringBuilder.append(0);
                        carry = 1;
                    }
                }
                else if (tempA == 0 && tempB == 0)  {
                    if (carry == 1) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else
                        stringBuilder.append(0);
                }
                else {
                    if (carry == 0) {
                        stringBuilder.append(0);
                        carry = 1;
                    }
                    else
                        stringBuilder.append(1);
                }
            }
            while (aIndex >= 0) {
                int tempA = getInt(a.charAt(aIndex--));
                if (carry == 1) {
                    if (tempA == 0) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else    {
                        stringBuilder.append(0);
                    }
                }
                else {
                    stringBuilder.append(tempA);
                }
            }
        }
        else {
            while (aIndex >= 0)  {
                int tempA = getInt(a.charAt(aIndex));
                int tempB = getInt(b.charAt(aIndex--));
                bIndex--;
                if ((tempA == 0 && tempB == 1) || (tempA == 1 && tempB == 0))   {
                    if (carry == 0) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else    {
                        stringBuilder.append(0);
                        carry = 1;
                    }
                }
                else if (tempA == 0 && tempB == 0)  {
                    if (carry == 1) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else
                        stringBuilder.append(0);
                }
                else {
                    if (carry == 0) {
                        stringBuilder.append(0);
                        carry = 1;
                    }
                    else
                        stringBuilder.append(1);
                }
            }
            while (bIndex >= 0) {
                int tempA = getInt(a.charAt(bIndex--));
                if (carry == 1) {
                    if (tempA == 0) {
                        stringBuilder.append(1);
                        carry = 0;
                    }
                    else
                        stringBuilder.append(0);
                }
                else
                    stringBuilder.append(tempA);
            }
        }
        if (carry != Integer.MAX_VALUE)
            stringBuilder.append(carry);

        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    private int getInt(int asciiValue)  {
        return asciiValue%48;
    }
 */
