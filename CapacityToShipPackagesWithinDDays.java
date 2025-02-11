public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int maxNum = -1, sum = 0;
        for (int wei: weights)  {
            sum += wei;
            if (wei > maxNum)
                maxNum = wei;
        }
        if (weights.length == days)
            return maxNum;
        if (days == 1)
            return sum;
        int low = 1, high = sum;
        while (low <= high) {
            int mid = (low+high)/2;
            if (canShipAll(mid, weights, days))   {
                high = mid-1;
            }   else    {
                low = mid+1;
            }
        }
        return low;
    }

    private boolean canShipAll(int perDay, int[] weights, int days) {
        int totalDays = 0, i = 0, len = weights.length;
        while (i < len)  {
            totalDays++;
            if (totalDays > days)
                return false;

            int temp = 0;
            while (i < len)   {
                if (temp + weights[i] <= perDay)
                    temp += weights[i++];
                else
                    break;
            }
        }
        return true;
    }
}
