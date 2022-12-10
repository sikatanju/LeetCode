/*import java.util.*;

public class minStack   {
    private List<Integer> stack;
    private int index;
    private int minValue;
    
    public minStack()   {
        minValue = Integer.MAX_VALUE;
        index = -1;
        stack = new ArrayList<Integer>();
    }

    public void push(int v) {
        stack.add(v);
        index++;
        if (minValue > v)
            minValue = v;
    }

    public void pop()   {
        stack.remove(index--);
        if (index == -1)    {
            minValue = Integer.MAX_VALUE;
            return;
        }
        minValue = stack.get(index);
        int i = -1;
        if (index > 0)  {
            while (i++ < index)    {
                if (minValue > stack.get(i))
                    minValue = stack.get(i);
            }
        }
    }

    public int top()    {
        return stack.get(index);
    }
    
    public int getMin() {
        return minValue;
    }
}*/