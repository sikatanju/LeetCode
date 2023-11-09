public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] ara)  {
        int len = ara.length;
        if (len == 1)
            return ara[0];

        int low = 0, high = len-1;

        while (true)    {
            int mid = (low+high)/2;

            if (low == high)
                return ara[low];

            if (low == high-1)  {
                if (ara[low] < ara[high])
                    return ara[low];
                else
                    return ara[high];
            }

            if (ara[mid] < ara[low] && ara[mid] < ara[high])    {
                if (mid + 1 != len && mid - 1 != -1)    {
                    if (ara[mid] < ara[mid-1] && ara[mid] < ara[mid+1])
                        return ara[mid];
                }
                high = mid;
                continue;
            }
            if (ara[mid] > ara[low] && ara[mid] > ara[high])    {
                low = mid+1;
                continue;
            }

            if (ara[mid] > ara[low] && ara[mid] < ara[high])    {
                high = mid;
                continue;
            }
            if (ara[mid] < ara[low] && ara[mid] < ara[high])    {
                high = mid;
                continue;
            }
            if (low > high)
                break;
        }
        return -1;
    }
}
