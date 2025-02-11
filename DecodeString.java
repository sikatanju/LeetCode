import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++)    {
            char ch = s.charAt(i);
            if (ch == '[' || Character.isDigit(ch) || (ch >= 'a' && ch <= 'z'))  {
                stack.push(ch);
            }   else if (ch == ']') {
                StringBuilder str = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[')
                    str.append(stack.pop());

                stack.pop();
                str.reverse();

                if (!stack.isEmpty() && Character.isDigit(stack.peek()))    {
                    StringBuilder num = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek()))    {
                        num.append(stack.pop());
                    }
                    num.reverse();
                    int n = Integer.parseInt(num.toString());
                    while (n > 0) {
                        for (char c: str.toString().toCharArray())
                            stack.push(c);

                        n--;
                    }
                }   else    {
                    String tempString = str.toString();
                    for (char c: tempString.toCharArray())
                        stack.push(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());

        return res.reverse().toString();
    }
}

/* Best runtime: 0ms:
class Solution {
    public String decodeString(String s) {
        Stack<Integer> st = new Stack<>();
        Stack<StringBuilder> st1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = 0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                n = n*10 + (c-'0');

            }
            else if(c == '['){
                st.push(n);
                n = 0;
                st1.push(sb);
                sb = new StringBuilder();
            }
            else if(c==']'){
                int k = st.pop();
                StringBuilder temp = sb;
                sb = st1.pop();
                while(k-- > 0){
                    sb.append(temp);
                }
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
 */