
// import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JustForPractice    {
    public int count(int[] nums)    {
        Set<Integer> hashSet = new HashSet<Integer>();
        
        for (int i=0; i<nums.length; i++)   {
            hashSet.add(nums[i]);
            hashSet.add(reverse(nums[i]));
        }

        return hashSet.size();
    }

    public int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            rev *= 10;
            rev += (num % 10);
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args)  {
        int[] ara = {1, 1, 1};
        // int[] stu = {1, 2, 3, 6};

        JustForPractice obj = new JustForPractice();
        System.out.println(obj.count(ara));
        
    }
}