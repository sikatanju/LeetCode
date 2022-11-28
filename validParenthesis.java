import java.util.Stack;
import java.util.Arrays;

public class validParenthesis {
    public boolean checkForBalance (String s)   {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);
            
            if (isRightBracket(ch)) {
                if (stack.isEmpty())
                    return false;

                var left = stack.pop();

                if (!balanceCheck(left, ch))
                   return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isLeftBracket(char ch)   {
        var ara = Arrays.asList('(', '{', '[');
        return ara.contains(ch);
    }

    public boolean isRightBracket(char ch)  {
        var ara = Arrays.asList(')', '}', ']');
        return ara.contains(ch);
    }

    public boolean balanceCheck(char left, char right)  {
        var leftt = Arrays.asList('[', '{', '(');
        var rightt = Arrays.asList(']', '}', ')');
        
        if (leftt.indexOf(left) == rightt.indexOf(right))
            return true;
        else
            return false;
    }
}
