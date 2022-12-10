/*
import java.util.Stack;

public class reversePolishNotation {
    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] strs)   {
        if (strs.length == 1)
            return Integer.parseInt(strs[0]);

        for (int i=0; i<strs.length; i++)   {
            if ((strs[i].charAt(0)) >= '0' || (isOperator(strs[i].charAt(0)) && strs[i].length() != 1))    {
                stack.push(Integer.parseInt(strs[i]));
                continue;
            }

            else  {
                int first = stack.pop();
                int second = stack.pop();
                getNum(first, second, strs[i].charAt(0));
            }
        }
        return stack.pop();
    }

    private void getNum(int first, int second, char ch)  {
        switch(ch)  {
            case '+' : stack.push((first + second));
                        break;
        
            case '-' : stack.push((second - first));
                        break;

            case '*' : stack.push((second * first));
                        break;

            default  :  stack.push((second / first));
        }
    }

    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }
} */



/* 

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] strs)   {
        if (strs.length == 1)
            return Integer.parseInt(strs[0]);

        for (int i=0; i<strs.length; i++)   {
            if ((strs[i].charAt(0)) >= '0')    {
                stack.push(Integer.parseInt(strs[i]));
                continue;
            }

            if (isOperator(strs[i].charAt(0)) && strs[i].length() == 1)  {
                int first = stack.pop();
                int second = stack.pop();
                getNum(first, second, strs[i].charAt(0));
            }

            else    {
                stack.push(Integer.parseInt(strs[i]));
            }
        }
        return stack.pop();
    }

    private void getNum(int first, int second, char ch)  {
        switch(ch)  {
            case '+' : stack.push((first + second));
                        break;
        
            case '-' : stack.push((second - first));
                        break;

            case '*' : stack.push((second * first));
                        break;

            default  :  stack.push((second / first));
        }
    }

    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

 */
