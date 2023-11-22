import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(0, 0, n, new StringBuilder(), list);
        return list;
    }

    private void generateParenthesis (int open, int close, int n, StringBuilder str, List<String> list) {
        if (open == n && close == n)    {
            list.add(str.toString());
            return;
        }

        if (open < n)   {
            str.append("(");
            generateParenthesis(open+1, close, n, str, list);
            str.deleteCharAt(str.length()-1);
        }
        if (close < open)  {
            str.append(")");
            generateParenthesis(open, close+1, n, str, list);
            str.deleteCharAt(str.length()-1);
        }
    }
}
