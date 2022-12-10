/*import java.util.Stack;

public class basicCalculatorII  {
    public int calculate(String str)    {
        Stack<Integer> stack = new Stack<>();
        int num = 0, len = str.length();
        char sign = '+';

        for (int i=0; i<len; i++)  {
            char ch = str.charAt(i);
            if (Character.isDigit(ch))  
                num = num * 10 + ch - '0';
            
            if ((!Character.isDigit(ch) && ch != ' ') || i == len-1)    {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(-num);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else if (sign == '/')
                    stack.push(stack.pop() / num);
                
                sign = ch;
                num = 0;
            }
        }
        for (int temp : stack)
            num += temp;

        return num;
    }
}*/