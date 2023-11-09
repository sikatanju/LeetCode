import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        if (len == 1) {
            if (gas[0] >= cost[0])
                return 0;
            else
                return -1;
        }

        for (int i=0; i<len; i++)    {
            if (gas[i] > cost[i])  {
                if (couldComplete(gas, cost, i))
                    return i;
            }
        }
        return -1;
    }
    private boolean couldComplete(int[] gas, int[] cost, int i)  {
        int len = gas.length;
        int gasTank = 0, startStation = 0, currentStation = 0, check = 0;
        boolean canComplete = false;

        gasTank = 0;
        startStation = i;
        currentStation = startStation;
        check = 0;
        while (true)    {
            if (currentStation == len)
                currentStation = 0;

            if (currentStation == startStation && check != 0) {
                canComplete = true;
                break;
            }

            gasTank += gas[currentStation];
            gasTank -= cost[currentStation++];
            check++;

            if (gasTank < 0)
                break;
        }
        return canComplete;
    }
}

/*   0ms runtime solution :

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curr_petrol = 0,prev_petrol = 0, start = 0;

        for(int i = 0; i < cost.length ; i++){
            curr_petrol += (gas[i] - cost[i]);

            if(curr_petrol < 0){
                prev_petrol += curr_petrol;
                curr_petrol = 0;
                start = i + 1;
            }
        }

        return ((curr_petrol + prev_petrol >= 0) ? start : -1);

    }
}



*********** 1ms solution :

class Solution {
    public int canCompleteCircuit(int[] petrol, int[] distance) {
      int balance = 0, lastbalance = 0;
        int index = 0;
        for(int i = 0; i<petrol.length; i++) {
            balance += petrol[i]-distance[i];
            if(balance<0) {
                index = i+1;
                lastbalance += balance;
                balance = 0;
            }
        }
        if(balance<-lastbalance) return -1;
        return index;
    }
}









      Previous Accepted Solution :

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 1) {
            if (gas[0] >= cost[0])
                return 0;
            else
                return -1;
        }

        List<Integer> list = new ArrayList<>();
        int gasTank = 0, startStation = 0, currentStation = 0, check = 0;
        boolean canComplete = false;

        for (int i=0; i<len; i++)    {
            if (gas[i] >= cost[i])  {
                list.add(i);
            }
        }

        for (int num : list)    {
            if (canComplete)
                break;

            gasTank = 0;
            startStation = num;
            currentStation = startStation;
            check = 0;
            while (true)    {
                if (currentStation == len)
                    currentStation = 0;

                if (currentStation == startStation && check != 0) {
                    canComplete = true;
                    break;
                }

                gasTank += gas[currentStation];
                gasTank -= cost[currentStation++];
                check++;

                if (gasTank < 0)
                    break;
            }
        }
        if (canComplete)
            return startStation;
        else
            return -1;
    }



 */