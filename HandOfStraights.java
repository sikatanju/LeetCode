import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int tempGroupSize = groupSize, index = 0;

        for (int num: hand) {
            if (hashMap.containsKey(num))
                hashMap.replace(num, hashMap.get(num)+1);
            else    {
                hashMap.put(num, 1);
                priorityQueue.add(num);
            }
        }
        hand = new int[priorityQueue.size()];
        for (int i=0; i<hand.length; i++)
            hand[i] = priorityQueue.poll();

        while (index < hand.length)    {
            int temp = hand[index];
            if (hashMap.containsKey(temp))  {
                while (tempGroupSize > 0)   {
                    if (!hashMap.containsKey(temp))
                        return false;

                    int tempCount = hashMap.get(temp);
                    if (tempCount == 1)
                        hashMap.remove(temp);
                    else
                        hashMap.replace(temp, tempCount-1);
                    temp++;
                    tempGroupSize--;
                }
                tempGroupSize = groupSize;
            }   else {
                index++;
            }
        }
        return true;
    }
}


/* Best runtime : 9ms :

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
       Arrays.sort(hand);
       int len = hand.length;
       boolean[] visited = new boolean[len];
       for(int i = 0;i < len;i++){
           if(visited[i]) continue;
           visited[i] = true;
           int j = i + 1;
           int count = 1;
           int num = hand[i] + 1;
           for(count = 1;j < len && count < groupSize;j++){
               if(visited[j]) continue;
               if(hand[j] > num) break;
               if(hand[j] == num ) {
                   num++;
                   visited[j] = true;
                   count++;
               }
           }
           if(count < groupSize) return false;
       }
       return true;
    }
}


############################ 11ms runtime :

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        boolean[] visited = new boolean[hand.length];
        int nv = 0;
        for(int i=0; i< hand.length/groupSize; i++){
            int start = hand[nv];
            int p = nv;
            for(int j=start; j<start+groupSize; j++){
                while(p<hand.length && (visited[p] == true || hand[p]!=j)){
                    p++;
                }
                if(p==hand.length) return false;
                visited[p] = true;
            }
            while(nv<hand.length && visited[nv] == true){
                nv++;
            }
        }
        return nv == hand.length;
    }
}
*/