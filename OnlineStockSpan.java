import java.util.ArrayDeque;

public class OnlineStockSpan {
    private ArrayDeque<Integer> queue;
    public OnlineStockSpan() {
        this.queue = new ArrayDeque<>();
    }

    public int next(int price) {
        queue.addLast(price);
        var temp = queue.clone();
        int count = 0;
        while (!temp.isEmpty() && temp.peekLast() <= price) {
            count++;
            temp.pollLast();
        }
        return count;
    }
}

/* 2nd Best runtime: 37ms:
public class OnlineStockSpan {
    class Pair{
        int val,count;
        Pair(int val,int count){
            this.val=val;
            this.count=count;
        }
    }
    Stack<Pair> s;
    int ind=-1;
    public OnlineStockSpan() {
        s = new Stack();
    }

    public int next(int price) {
        ind += 1;
        while(!s.isEmpty() && s.peek().val<=price){
            s.pop();
        }
        int ans=ind-(s.isEmpty()?-1:s.peek().count);
        s.push(new Pair(price,ind));
        return ans;
    }
}
 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
