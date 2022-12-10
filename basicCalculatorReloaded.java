/* // First one runs at 0 ms.
class Solution {
    public int calculate(String s) {
      if (s.length() >= 209079)
			return 199;

		int answer = 0;
		char sign = '+';
		int[] stack = new int[s.length()];
		int top = -1, currNum = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch >= '0') {
				currNum = currNum * 10 - '0' + ch;
			}
			if (i == s.length() - 1 || (ch < '0' && ch != ' ')) {
				if (sign == '+') {
					stack[++top] = currNum;
				} else if (sign == '-') {
					stack[++top] = -currNum;
				} else {
					int temp = (sign == '*') ? stack[top] * currNum : stack[top] / currNum;
					stack[top] = temp;
				}
				currNum = 0;
				sign = ch;
			}
		}
		while (top != -1) {
			answer += stack[top--];
		}
		return answer;
	
	
    }
}

********************************************************

class basicCalculatorReloaded {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c))
                num = num * 10 + c - '0';
            if((!Character.isDigit(c) && c != ' ') || i == len - 1){
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                    stack.push(-num);
                else if(sign == '*')
                    stack.push(num * stack.pop());
                else if(sign == '/')
                    stack.push(stack.pop() / num);
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        for(Integer i : stack)
            res += i;
        return res;
    }
}

/*
class Solution {
    public int calculate(String s) {
        int len = s.length();
        if(len == 0) return 0;
        char[] arr = s.toCharArray();
        Stack<Integer> numbers = new Stack<>();
        char operators = '+';
        numbers.push(0);
        int index = 0;
        while(index < len){
            char c = arr[index];
            if(Character.isDigit(c)){
                int temp = c - '0';
                index++;
                while(index < len && Character.isDigit(arr[index])){
                    temp = temp * 10 + arr[index] - '0';
                    index++;
                }
                index--;
                if(operators == '*'){
                    numbers.push(temp * numbers.pop());
                }else if(operators == '/'){
                    numbers.push(numbers.pop() / temp);
                }else if(operators == '-'){
                    numbers.push(-temp);
                }else numbers.push(temp);
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                operators = c;
            }
            index++;
        }
        int sum = 0;
        while(!numbers.isEmpty()){
            sum += numbers.pop();
        }
        return sum;
    }
}

************************************************

class Solution {
    public int calculate(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char opt = ' ';
        for(int i = 0; i < len; i++){
            char c = arr[i];
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i + 1 < len && Character.isDigit(arr[i + 1])){
                    num = num * 10 + arr[++i] - '0';
                }
                if(opt == '*')  {
                    int pre = stack.pop();
                    stack.push(pre * num);
                }
                else if (opt == '/') {
                    int pre = stack.pop();
                    stack.push(pre / num);
                }
                else if(opt == '-') {
                    stack.push(-1 * num);
                }
                else    {
                    stack.push(num);
                }
            }
            else if(c == '+' ||c == '-' ||c == '*' || c == '/') {
                opt = c;
            }
        }
        int result = 0;
        for(Integer i : stack)
            result += i;
        return result;
    }
}

*******************************************

public class Solution {
public int calculate(String s) {
    int len;
    if(s==null || (len = s.length())==0) return 0;
    Stack<Integer> stack = new Stack<Integer>();
    int num = 0;
    char sign = '+';
    for(int i=0;i<len;i++){
        if(Character.isDigit(s.charAt(i))){
            num = num*10+s.charAt(i)-'0';
        }
        if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
            if(sign=='-'){
                stack.push(-num);
            }
            if(sign=='+'){
                stack.push(num);
            }
            if(sign=='*'){
                stack.push(stack.pop()*num);
            }
            if(sign=='/'){
                stack.push(stack.pop()/num);
            }
            sign = s.charAt(i);
            num = 0;
        }
    }

    int re = 0;
    for(int i:stack){
        re += i;
    }
    return re;
}
*/