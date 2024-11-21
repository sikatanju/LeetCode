import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WeeklyContest406 {
    public String getSmallestString(String s) {
        String str = "";
        int i=0;
        for (; i<s.length()-1; i++)    {
            String temp = "", temp2 = "";
            temp += s.charAt(i);
            temp2 += s.charAt(i+1);
            int first = Integer.parseInt(temp);
            int second = Integer.parseInt(temp2);
            if (first % 2 == 0 && second % 2 == 0 && first > second)  {
                str += temp2;
                str += temp;
                i += 2;
                break;
            }
            else if (first % 2 != 0 && second % 2 != 0 && first > second)   {
                str += temp2;
                str += temp;
                i += 2;
                break;
            }
            else {
                str += temp;
            }
        }
        for (; i<s.length(); i++)   {
            str += s.charAt(i);
        }
        return str;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (var temp: nums)    {
            set.add(temp);
        }
        while(set.contains(head.val))   {
            head = head.next;
        }
        ListNode temp = head;
        ListNode tail = head.next;
        while (tail != null)   {
            if (set.contains(tail.val)) {
                temp.next = tail.next;
                tail = temp.next;
            }   else {
                tail = tail.next;
                temp = temp.next;
            }
        }
        return head;
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int rowCount = 1, columnCount = 1, res = 0;
        m -= 2;
        n -= 2;
        while (m >= 0 && n >= 0)    {
            if (horizontalCut[m] > verticalCut[n])  {
                res += horizontalCut[m] * columnCount;
                rowCount++;
                m--;
            }
            else {
                res += verticalCut[n] * rowCount;
                columnCount++;
                n--;
            }
        }
        while (n >= 0)  {
            res += verticalCut[n] * rowCount;
            columnCount++;
            n--;
        }
        while (m >= 0)  {
            res += horizontalCut[m] * columnCount;
//            rowCount++;
            m--;
        }
        return res;
    }
}


/* Simplest solution : Very intuitive
 public int minimumCost(int m, int n, int[] h, int[] v) {
        int res = Arrays.stream(h).sum() + Arrays.stream(v).sum();
        for (int a : h)
            for (int b : v)
                res += Math.min(a, b);
        return res;
    }
 */