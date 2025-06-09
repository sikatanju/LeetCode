//import java.util.*;

public class CodeRunner {
    public static void main(String[] args) {

        System.out.println(new Solution());
        System.out.println(new Solution());
    }

    public static int[][] convertToArray(String input) {
        input = input.replaceAll("[\\[\\]]", ""); // Remove brackets
        String[] pairs = input.split(","); // Split by commas
        int[][] result = new int[pairs.length / 2][2];

        for (int i = 0, index = 0; i < pairs.length; i += 2, index++) {
            result[index][0] = Integer.parseInt(pairs[i]);
            result[index][1] = Integer.parseInt(pairs[i + 1]);
        }

        return result;
    }

}

/*
import java.util.Arrays;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2)
            return node1;
        int n = edges.length;
        int[] dis1 = new int[n], dis2 = new int[n];
        Arrays.fill(dis1, -1);
        Arrays.fill(dis2, -1);
        int n1 = node1, n2 = node2, cnt = 1;
        dis1[n1] = 0;
        dis2[n2] = 0;
        while (n1 != -1)    {
            int nn1 = edges[n1];
            if (nn1 == -1)  {
                dis1[n1] = cnt-1;
                break;
            }
            else if(n1 == edges[n1])   {
                dis1[n1] = cnt-1;
                break;
            }
            else if (dis1[nn1] == -1)
                dis1[nn1] = cnt++;
            else
                break;
            n1 = nn1;
        }
        cnt = 1;
        while (n2 != -1) {
            int nn2 = edges[n2];
            if (nn2 == -1)  {
                dis2[n2] = cnt-1;
                break;
            }
            else if (n2 == edges[n2])   {
                dis2[n2] = cnt-1;
                break;
            }
            else if (dis2[nn2] ==  -1)
                dis2[nn2] = cnt++;
            else
                break;
            n2 = nn2;
        }
        int min = Integer.MAX_VALUE, idx = -1;
        for (int i=n-1; i>=0; i--)  {
            if (dis1[i] != -1 && dis2[i] != -1 && ((dis1[i] + dis2[i]) <= min)) {
                min = dis1[i] + dis2[i];
                idx = i;
            }
        }
        return idx;
    }
}
 */

/*
0, 1, -1
1, -2, 3
2, -3, 4
 */
//int[] ara = {5};
//        int[] ara = {10};
//        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(ara));
//        System.out.println(new CoinChangeII().change(10, ara));
//        int[][] ara = {{1,1}, {1,1}};
//        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(ara));
/*
        int[][] ara = {
                {0,1},
                {0,2},
                {1,3},
                {1,4},
                {2,5},
                {2,6}
        };
        int[][] ara1
                = {
                {0,1}, {1,2}, {1,3}, {1,4}, {0,5},
                {5,6}, {6,7}, {7,8}, {0,9}, {9,10},
                {9,12}, {10,11}
        };
        int[][] ara2
                = {
                {6,0}, {1,0}, {5,1}, {2,5}, {3,1},
                {4,3}
        };
        int[][] ara3
                = {
                {4,0}, {3,4}, {1,3}, {2,3}
        };*/
/*
        [0,0],[1,0],[1,1],[0,1],[1,1],[1,1]
        [4,0],[3,4],[1,3],[2,3]

//        [0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]
//          [0,1],[0,2],[1,3],[1,4],[2,5],[2,6]
//        [[0,2],[0,4]]

//        System.out.println(new WeeklyContest410().finalPositionOfSnake(3, List.of("DOWN","RIGHT","UP")));

//        System.out.println(new JustForPractice().longestPalindrome("abcba"));
//        System.out.println(new JustForPractice().wordBreak("catsdogsandandcat", List.of("cats","dog","sand","and","cat")));

//        System.out.println(new MinimumASCIIDeleteSumForTwoStrings().minimumDeleteSum("sea", "eat"));
//        [2,4],[0,2],[0,4]

        int[] arr1 = {1,5,2,1};
        int[] arr2 = {3,1,1,4};
        System.out.println(new WeeklyContest411().maxEnergyBoost(arr1, arr2));*/
//        System.out.println(new JustForPractice().minimumTotal(listOfLists));
//
////        String temp = "31";
//        ListNode first = new ListNode(2);
//        ListNode first1 = new ListNode(3);
//        ListNode first2 = new ListNode(1);
//        ListNode first3 = new ListNode(4);
//        ListNode first4 = new ListNode(5);
//        ListNode first5 = new ListNode(2);
//        ListNode head = new ListNode(0);
//        head.next = first;
//        first.next = first2;
//        first2.next = first3;
//        first3.next = first4;
//        first4.next = first5;
//        ListNode temp = new WeeklyContest406().modifiedList(ara, head);
//
//        while (temp != null)    {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
/*
["a","aa","aaa","aaaa","aaab","aaac","aaad","aab","aaba","aabb","aabc","aabd","aac","aaca","aacb","aacc","aacd","aad","aada","aadb","aadc","aadd","ab","aba","abaa","abab","abac","abad","abb","abba","abbb","abbc","abbd","abc","abca","abcb","abcc","abcd","abd","abda","abdb","abdc","abdd","ac","aca","acaa","acab","acac","acad","acb","acba","acbb","acbc","acbd","acc","acca","accb","accc","accd","acd","acda","acdb","acdc","acdd","ad","ada","adaa","adab","adac","adad","adb","adba","adbb","adbc","adbd","adc","adca","adcb","adcc","adcd","add","adda","addb","addc","addd","b","ba","baa","baaa","baab","baac","baad","bab","baba","babb","babc","babd","bac","baca","bacb","bacc","bacd","bad","bada","badb","badc","badd","bb","bba","bbaa","bbab","bbac","bbad","bbb","bbba","bbbb","bbbc","bbbd","bbc","bbca","bbcb","bbcc","bbcd","bbd","bbda","bbdb","bbdc","bbdd","bc","bca","bcaa","bcab","bcac","bcad","bcb","bcba","bcbb","bcbc","bcbd","bcc","bcca","bccb","bccc","bccd","bcd","bcda","bcdb","bcdc","bcdd","bd","bda","bdaa","bdab","bdac","bdad","bdb","bdba","bdbb","bdbc","bdbd","bdc","bdca","bdcb","bdcc","bdcd","bdd","bdda","bddb","bddc","bddd","c","ca","caa","caaa","caab","caac","caad","cab","caba","cabb","cabc","cabd","cac","caca","cacb","cacc","cacd","cad","cada","cadb","cadc","cadd","cb","cba","cbaa","cbab","cbac","cbad","cbb","cbba","cbbb","cbbc","cbbd","cbc","cbca","cbcb","cbcc","cbcd","cbd","cbda","cbdb","cbdc","cbdd","cc","cca","ccaa","ccab","ccac","ccad","ccb","ccba","ccbb","ccbc","ccbd","ccc","ccca","cccb","cccc","cccd","ccd","ccda","ccdb","ccdc","ccdd","cd","cda","cdaa","cdab","cdac","cdad","cdb","cdba","cdbb","cdbc","cdbd","cdc","cdca","cdcb","cdcc","cdcd","cdd","cdda","cddb","cddc","cddd","d","da","daa","daaa","daab","daac","daad","dab","daba","dabb","dabc","dabd","dac","daca","dacb","dacc","dacd","dad","dada","dadb","dadc","dadd","db","dba","dbaa","dbab","dbac","dbad","dbb","dbba","dbbb","dbbc","dbbd","dbc","dbca","dbcb","dbcc","dbcd","dbd","dbda","dbdb","dbdc","dbdd","dc","dca","dcaa","dcab","dcac","dcad","dcb","dcba","dcbb","dcbc","dcbd","dcc","dcca","dccb","dccc","dccd","dcd","dcda","dcdb","dcdc","dcdd","dd","dda","ddaa","ddab","ddac","ddad","ddb","ddba","ddbb","ddbc","ddbd","ddc","ddca","ddcb","ddcc","ddcd","ddd","ddda","dddb","dddc","dddd"]
 */