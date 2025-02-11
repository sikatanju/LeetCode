import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (var str: operations)   {
            var ch = str.charAt(0);
            if (ch == '+' || ch == 'C' || ch == 'D')    {
                if (ch == '+')  {
                    int num1 = stack.pop();
                    int newNum = num1+stack.peek();
                    stack.push(num1);
                    stack.push(newNum);
                }
                else if (ch == 'C')
                    stack.pop();
                else
                    stack.push(stack.peek()*2);
            }
            else
                stack.push(Integer.parseInt(str));
        }
        int res = 0;
        while (!stack.isEmpty())
            res += stack.pop();

        return res;
    }
}

/* Best runtime: 1ms :
class Solution {
    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        int i = 0;

        for (String a : operations) {
            switch (a) {
                case "C":
                    i--;
                    break;
                case "D":
                    scores[i] = scores[i - 1] * 2;
                    i++;
                    break;
                case "+":
                    scores[i] = scores[i - 1] + scores[i - 2];
                    i++;
                    break;
                default:
                    scores[i] = Integer.parseInt(a);
                    i++;
                    break;
            }
        }

        int sum = 0;
        for (int j = 0; j < i; j++) sum += scores[j];

        return sum;
    }
}
 */
