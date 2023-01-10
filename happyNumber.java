import java.util.Set;
import java.util.HashSet;

public class happyNumber {
    public boolean isHappy(int n)   {
        if (n<1)
            return false;

        Set<Integer> set = new HashSet<>();
        int result = 0;
        while (result != 1) {
            int temp = 0;
            while (n != 0)  {
                temp += Math.pow((n%10), 2);
                n /= 10;
            }
            if (set.contains(temp))
                return false;
            else
                set.add(temp);

            result = temp;
            n = temp;
        }
        return true;
    }
}
