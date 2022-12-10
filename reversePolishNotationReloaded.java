/* Runs at 2 ms time : 
class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int index = -1;
        for(String token:tokens) {
            if(token.equals("+")) {
                stack[index-1] = stack[index-1] + stack[index];
                index--;
            } else if(token.equals("-")) {
                stack[index-1] = stack[index-1] - stack[index];                
                index--;
            } else if(token.equals("/")) {
                stack[index-1] = stack[index-1] / stack[index];                
                index--;
            } else if(token.equals("*")) {
                stack[index-1] = stack[index-1] * stack[index];                
                index--;
            } else {
                stack[++index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }
}
 */
