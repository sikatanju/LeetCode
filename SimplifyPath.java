import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String str = "";
        int strLen = path.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<strLen; i++)    {
            char ch = path.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '/' && ch == '/')
                continue;

            if (!stack.isEmpty() && stack.peek() == '.' && ch == '.' && i+1 <strLen && path.charAt(i+1) != '.' && path.charAt(i+1) != '_' && path.charAt(i+1) != '/') {
                stack.push(ch);
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == '.' && ch == '.' && i+1 <strLen && path.charAt(i+1) == '.') {
                stack.push(ch);
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '.' && i-2 >= 0 && path.charAt(i-2) != '.' && path.charAt(i-2) == '/' && (i+1 >= strLen || (i+1 <strLen && path.charAt(i+1) != '.')))    {
                int count = 2;
                while (count > 0 && !stack.isEmpty())   {
                    if (stack.pop() == '/')
                        count--;
                }
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '/' && i-2 >= 0 && path.charAt(i-2) == '/')   {
                stack.pop();
                continue;
            }
            if (i == strLen-1 && !stack.isEmpty() && stack.peek() == '/' && (ch=='_' || ch=='.'))
                continue;

            stack.push(ch);
        }
        if (stack.isEmpty())
            return "/";

        if (stack.peek() == '/' && stack.size() != 1)
            stack.pop();

        while (!stack.isEmpty())
            str += stack.pollLast();

        return str;
    }
}

/* Accepted Solution from :

    public String simplifyPath(String path) {
        var strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (var str : strs)    {
            if (str.equals(".") || str.isEmpty())
                continue;
            if (str.equals(".."))   {
                if (!stack.isEmpty())
                    stack.pop();
            }
            else
                stack.push(str);
        }
        return "/" + String.join("/", stack);
    }
 */


/* Best runtime : 1ms :

class Solution {
    public String simplifyPath(String path) {
		char[] p = path.toCharArray();
		int length = p.length;
		for (int i = 0; i < p.length - 1; i++) {
			if (p[i] == '/') {
				if (p[i + 1] == '/') {
					p[i] = '!';
				}
			} else if (p[i] == '.') {
				if (p[i + 1] == '.' && (i+2 >= p.length || p[i+2] == '/') && (i-1 < 0 || p[i-1]=='/' || p[i-1]=='!')) {
					int j = i-1;
					p[j--] = '!';
					while (j > 0 && p[j] != '/') {
						p[j--] = '!';
					}
					if (j >= 0)
						p[j] = '!';
					p[i] = '!';
					p[i + 1] = '!';
				} else if (p[i+1] == '/' && (i -1 < 0 || p[i-1] == '!' || p[i-1] == '/')) {
					p[i - 1] = '!';
					p[i] = '!';
				}
			}
		}
		if (p[p.length - 1] == '/')
			p[p.length - 1] = '!';

		if (p[p.length-1] == '.' && (p.length-2 < 0 || p[p.length-2] == '/' || p[p.length-1] == '!')) {
			p[p.length-1] = '!';
			p[p.length-2] = '!';
		}
		for (int i = 0; i < p.length; i++) {
			if (p[i] == '!')
				length--;
		}

		if (length == 0)
			return "/";

		char[] res = new char[length];
		for (int i = 0, j = 0; i < p.length; i++) {
			if (p[i] != '!')
				res[j++] = p[i];
		}
		return new String(res);
	}
}

 */
/* My NOt accepted solution : '/..' -- was defeated by this testcase :)


        String str = "";
        int strLen = path.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i=0; i<strLen; i++)    {
            char ch = path.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '/' && ch == '/')
                continue;
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '.' && i+1 <strLen && path.charAt(i+1) == '.') {
                stack.push(ch);
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '.' && i-2 >= 0 && path.charAt(i-2) != '.' && (i+1 >= strLen || (i+1 <strLen && path.charAt(i+1) != '.')))    {
                int count = 2;
                while (count > 0 && !stack.isEmpty())   {
                    if (stack.pop() == '/')
                        count--;
                }
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == '.' && ch == '/' && i-2 >= 0 && path.charAt(i-2) == '/')   {
                stack.pop();
                continue;
            }
            if (i == strLen-1 && !stack.isEmpty() && stack.peek() == '/' && (ch=='_' || ch=='.'))
                continue;

            stack.push(ch);
        }
        if (stack.isEmpty())
            return "/";
        if (stack.peek() == '/' && stack.size() != 1)
            stack.pop();

        while (!stack.isEmpty())
            str += stack.pollLast();

        return str;
 */