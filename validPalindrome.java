import java.util.Stack;
public class validPalindrome {
    /*public boolean isPalindrome(String s)   {
        Stack<Character> stack = new Stack<>();
        s = s.toLowerCase();
        for (char ch: s.toCharArray())  {
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                stack.push(ch);
        }
        Stack<Character> stackThree = (Stack<Character>) stack.clone();
        
        Stack<Character> stackTwo = new Stack<>();
        while (!stack.empty())   {
            stackTwo.push(stack.pop());
        }
        if (stackThree.equals(stackTwo))
            return true;
        else
            return false;
    }*/
}
