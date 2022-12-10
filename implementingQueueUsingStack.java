/*import java.util.*;

public class implementingQueueUsingStack    {
    private Stack<Integer> stack;
    private Stack<Integer> returnStack;
    private int count;

    public implementingQueueUsingStack()   {
        stack = new Stack<>();
        returnStack = new Stack<>();
        this.count = 0;
    }

    public void push(int x) {
        stack.push(x);
        count++;
    }

    public int pop()    {
        if (returnStack.empty())
            reload();
        
        count--;
        return returnStack.pop();
    }

    public int peek()   {
        if (returnStack.empty())
            reload();

        return returnStack.peek();
    }

    public boolean empty()  {
        return count == 0;
    }


    public void reload()    {
        while (!stack.empty())  {
            returnStack.push(stack.pop());
        }
    }

}*/