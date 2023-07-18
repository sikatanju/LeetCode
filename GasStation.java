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
}

/*

        int len = gas.length;
        if (len == 1) {
            if (gas[0] >= cost[0])
                return 0;
            else
                return -1;
        }

        int gasTank = 0, startStation = 0, currentStation = Integer.MIN_VALUE, check = 0;
        boolean canComplete = false;

        for (int i=0; i<len; i++)    {
            if (gas[i] >= cost[i])  {
                if (gas[i]-cost[i] > currentStation)    {
                    startStation = i;
                    currentStation = gas[i] - cost[i];
                }
            }
        }

        currentStation = startStation;
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

        if (canComplete)
            return startStation;
        else
            return -1;
    }

 */