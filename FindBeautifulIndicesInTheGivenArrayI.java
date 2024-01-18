import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindBeautifulIndicesInTheGivenArrayI {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        char[] str = s.toCharArray();
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        for (int i=0; i<s.length(); i++)    {
            if (str[i] == aa[0])  {
                if (checkIfMatch(str, aa, i))   {
                    int tempIndex = i, tempIndex2 = i;
                    boolean bMatched = false;
                    while (tempIndex >= 0)    {
                        if (str[tempIndex] == bb[0])    {
                            if (checkIfMatch(str, bb, tempIndex))   {
                                bMatched = true;
                                break;
                            }
                        }

                        tempIndex--;
                    }
                    if (!bMatched || !(Math.abs(tempIndex-i) <= k)) {
                        bMatched = false;
                        tempIndex2 = i;
                        while (tempIndex2 <= str.length-bb.length)    {
                            if (str[tempIndex2] == bb[0])    {
                                if (checkIfMatch(str, bb, tempIndex2))   {
                                    bMatched = true;
                                    break;
                                }
                            }
                            tempIndex2++;
                        }
                    }
                    if (bMatched)   {
                        if (tempIndex >= 0 && Math.abs(tempIndex-i) <= k)
                            queue.add(i);
                        else if (tempIndex2 >= 0 && Math.abs(tempIndex2-i) <= k)
                            queue.add(i);
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty())
            list.add(queue.poll());

        return list;
    }
    private boolean checkIfMatch(char[] s, char[] ab, int start) {
        int i=0;
        if (start+ab.length-1 >= s.length)
            return false;

        while (i<ab.length)  {
            if (s[start++] != ab[i++])
                return false;
        }
        return true;
    }
}


/*
"klxtee"
"e"
"klx"
2
Output:
[4,5]
 */
