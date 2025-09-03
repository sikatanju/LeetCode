public class happyNumber {
    /* 0ms solution:
    class Solution {
        public boolean isHappy(int n) {
            int low = n, high = n;
            do {
                low = getSum(low);
                high = getSum(getSum(high));
                if (low == 1 || high == 1)
                    return true;
            }   while (low != high);
            return false;
        }
        private int getSum (int n)  {
            int sum = 0;
            while (n > 0)   {
                sum += (int)Math.pow((n % 10), 2);
                n /= 10;
            }
            return sum;
        }
    } 

     */
}


// import java.util.Set;
// import java.util.HashSet;

// public class happyNumber {
//     public boolean isHappy(int n)   {
//         if (n<1)
//             return false;

//         Set<Integer> set = new HashSet<>();
//         int result = 0;
//         while (result != 1) {
//             int temp = 0;
//             while (n != 0)  {
//                 temp += Math.pow((n%10), 2);
//                 n /= 10;
//             }
//             if (set.contains(temp))
//                 return false;
//             else
//                 set.add(temp);

//             result = temp;
//             n = temp;
//         }
//         return true;
//     }
// }
