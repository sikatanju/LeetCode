import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> currStack = new Stack<>();
        int n = asteroids.length, index = 0;
        while (index < n && asteroids[index] < 0)
            tempStack.push(asteroids[index++]);

        if (index < n)
            currStack.push(asteroids[index++]);

        for (int i=index; i<n; i++) {
            int curr = asteroids[i];
            if (!currStack.isEmpty() && curr < 0)   {
                int absCurr = Math.abs(curr);
                int top = currStack.peek();
                if (top > absCurr)
                    continue;
                else if (top == absCurr)
                    currStack.pop();
                else {
                    do  {
                        currStack.pop();
                    } while (!currStack.isEmpty() && currStack.peek() < absCurr);
                    if (currStack.isEmpty())
                        currStack.push(curr);
                    else if (currStack.peek() == absCurr)
                        currStack.pop();
                }
            }   else    {
                currStack.push(curr);
            }
            while (!currStack.isEmpty() && currStack.peek() < 0)
                tempStack.push(currStack.pop());
        }
        n = currStack.size()+tempStack.size();
        int[] res = new int[n];
        index = n-1;
        while (!currStack.isEmpty())
            res[index--] = currStack.pop();
        while (!tempStack.isEmpty())
            res[index--] = tempStack.pop();

        return res;
    }
}
/* Best runtime: 1ms:
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack<Integer> stack = new Stack<>();

        // for(int roid : asteroids){
        //     boolean exploded = false;
        //     //check if both are moving in different direction, if yes then we keep collliding tilll only 1 direction remains
        //     //
        //     while(!stack.isEmpty() && roid<0 && stack.peek()>0){
        //         //collision happens
        //         if(Math.abs(roid)>stack.peek()){
        //             //it destroys the smaller boulder in stack
        //             stack.pop();
        //         }else if(Math.abs(roid)==stack.peek()){
        //             //both destroy each other;
        //             stack.pop();
        //             exploded=true;
        //             break;
        //         }else{
        //             exploded=true;
        //             break;
        //         }
        //     }

        //     if(!exploded){
        //         stack.push(roid);
        //     }
        // }

        // int[] result = stack.stream().mapToInt(i -> i).toArray();


        int n = asteroids.length;
        int[] result = new int[n];
        int index = 0;

        for(int roid : asteroids){
            boolean exploded = false;
            while(index>0 && roid<0 && result[index-1]>0){
                if(Math.abs(roid)>result[index-1]){
                    index--;
                }else if(Math.abs(roid)==result[index-1]){
                    index--;
                    exploded=true;
                    break;
                }else{
                    exploded=true;
                    break;
                }
            }
            if(!exploded){
                result[index]=roid;
                index++;
            }
        }
        return Arrays.copyOf(result, index);
    }
}
 */