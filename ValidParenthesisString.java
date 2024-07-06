import java.util.Stack;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;
        for (var ch: s.toCharArray())   {
            if (ch == '(')  {
                leftMin++;
                leftMax++;
            }
            else if (ch == ')') {
                leftMin = Math.max(0, leftMin-1);
                leftMax--;
            }
            else {
                leftMin = Math.max(0, leftMin-1);
                leftMax++;
            }
            if (leftMax < 0)
                return false;
        }
        return leftMin == 0;
    }
}
