import java.util.Stack;

public class BasicCalculator {
    public int calculate(String str) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, currentNum = 0, sign = 1;

        for (var ch: str.toCharArray())   {
            if (Character.isDigit(ch))
                currentNum = (currentNum * 10) + (int)(ch-'0');

            else if (ch == '+') {
                res += sign * currentNum;
                currentNum = 0;
                sign = 1;
            }
            else if (ch == '-') {
                res += sign * currentNum;
                currentNum = 0;
                sign = -1;
            }
            else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            }
            else if (ch == ')') {
                res += sign * currentNum;
                res *= stack.pop();
                res += stack.pop();
                currentNum = 0;
            }
        }
        return currentNum != 0 ? (res + (sign*currentNum)) : res;
    }
}

/* Recursive solution :

class Solution {
    int idx; // this index traverse the string in one pass, between different level of recursion
    public int calculate(String s) {
        idx = 0; // Initialization should be here
        return calc(s);
    }

    private int calc(String s) {
        int res = 0, num = 0, sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = calc(s); // ( is start of a new sub-problem, Let recursion solve the sub-problem
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') { // only when we meet a new sign, we know a while number has been read
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; // last number is not processed yet
    }
}

*/


/*
public int calculate(String s) {
    Stack<Integer> stack = new Stack<Integer>();
    int result = 0;
    int number = 0;
    int sign = 1;
    for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(Character.isDigit(c)){
            number = 10 * number + (int)(c - '0');
        }else if(c == '+'){
            result += sign * number;
            number = 0;
            sign = 1;
        }else if(c == '-'){
            result += sign * number;
            number = 0;
            sign = -1;
        }else if(c == '('){
            //we push the result first, then sign;
            stack.push(result);
            stack.push(sign);
            //reset the sign and result for the value in the parenthesis
            sign = 1;
            result = 0;
        }else if(c == ')'){
            result += sign * number;
            number = 0;
            result *= stack.pop();    //stack.pop() is the sign before the parenthesis
            result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis
        }
    }
    if(number != 0) result += sign * number;
    return result;
}
 */