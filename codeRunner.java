// This class is just to run new problem code... :)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class codeRunner {
    public static void main(String[] args) {
        int[] ara = {1,2,2};
        System.out.println(new SubsetsII().subsetsWithDup(ara));
    }
}

/*{
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O'}};*/
/*

//        TreeNode root = new TreeNode(3);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node4 = new TreeNode(4);
//
//        root.left = node5;
//        root.right = node1;
//        node5.left = node6;
//        node5.right = node2;
//        node1.left = node0;
//        node1.right = node8;
//        node2.left = node7;
//        node2.right = node4;
//
//        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, node6, node4));

        TreeNode rightRR = new TreeNode(1);
        TreeNode rightRL = new TreeNode(5);
        TreeNode rightR = new TreeNode(11);

//        rightR.left = rightRL;
//        rightR.right = rightRR;

        TreeNode leftLR = new TreeNode(1);
        TreeNode leftLL = new TreeNode(3);
        TreeNode leftL = new TreeNode(3);

        leftL.left = leftLL;
        leftL.right = leftLR;

        TreeNode leftRR = new TreeNode(1);
        TreeNode leftRL = new TreeNode(7);
        TreeNode leftR = new TreeNode(2);

        leftR.right = leftRR;


        TreeNode rightL = new TreeNode(13);

        TreeNode right = new TreeNode(-3);
        right.right = rightR;
        // right.left = rightL;
        TreeNode left3 = new TreeNode(1000000000);

        TreeNode left2 = new TreeNode(1000000000);

        TreeNode left1 = new TreeNode(294967296);

        left1.left = left2;
        left2.left = left3;

        TreeNode left = new TreeNode(1000000000);
        left.left = left1;
//        left.left = leftL;
//        left.right = leftR;

        TreeNode root = new TreeNode(1000000000);
//        root.right = right;
        root.left = left;


//        TreeNode rightRR = new TreeNode(1);
//        TreeNode rightRL = new TreeNode(5);
//        TreeNode rightR = new TreeNode(4);
//
//        rightR.left = rightRL;
//        rightR.right = rightRR;
//
//        TreeNode leftLR = new TreeNode(2);
//        TreeNode leftLL = new TreeNode(7);
//        TreeNode leftL = new TreeNode(11);
//
//        leftL.left = leftLL;
//        leftL.right = leftLR;
//
//        TreeNode rightL = new TreeNode(13);
//        TreeNode right = new TreeNode(8);
//        right.right = rightR;
//        right.left = rightL;

        TreeNode left = new TreeNode(-3);
        // left.left = leftL;

        TreeNode root = new TreeNode(-2);
        // root.right = right;
        root.left = left;

        new PathSumII().pathSum(root, -5);
//        TreeNode rw = new TreeNode(1);
//        TreeNode r = new TreeNode(4);
//        r.right = rw;
//        TreeNode rr = new TreeNode(13);
//        TreeNode rrr = new TreeNode(8);
//        rrr.right = r;
//        rrr.left = rr;
//
//        TreeNode sr = new TreeNode(2);
//        TreeNode s = new TreeNode(7);
//        TreeNode ss = new TreeNode(11);
//        ss.left = s;
//        ss.right = sr;
//        TreeNode sss = new TreeNode(4);
//        // sss.right = s;
//        sss.left = ss;
//
//        TreeNode root = new TreeNode(5);
//        root.left = sss;
//        root.right = rrr;

        TreeNode root = new TreeNode(5);
//        TreeNode sss = new TreeNode(1);
//        root.left = sss;
//        TreeNode rrr = new TreeNode(2);
//        root.right = rrr;

        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4);
        four.next = five;
        ListNode fourII = new ListNode(5);
        // fourII.next = four;
        ListNode three = new ListNode(4);
        three.next = fourII;
        ListNode threeII = new ListNode(3);
        // threeII.next = three;
        ListNode two = new ListNode(2);
        two.next = threeII;
        ListNode oneIII = new ListNode(2  );
        // oneIII.next = two;
        ListNode oneII = new ListNode(2);
        oneII.next = oneIII;
        ListNode root = new ListNode(1);
        root.next = oneII;
        // new JustForPractice().deleteDuplicates(root);
                ListNode four = new ListNode(0);
        ListNode fourII = new ListNode(1);
        fourII.next = four;
        ListNode three = new ListNode(6);
        three.next = fourII;
        ListNode threeII = new ListNode(5);
        threeII.next = three;
        ListNode two = new ListNode(2);
        two.next = threeII;
        ListNode oneIII = new ListNode(3);
        oneIII.next = two;
        ListNode oneII = new ListNode(4);
        oneII.next = oneIII;
        ListNode root = new ListNode(4);
        root.next = oneII;
 */



/*

        TreeNode r = new TreeNode(9);
        TreeNode rr = new TreeNode(6);
        TreeNode rrr = new TreeNode(7);
        rrr.left = rr;
        rrr.right = r;
        TreeNode s = new TreeNode(3);
        TreeNode ss = new TreeNode(1);
        TreeNode sss = new TreeNode(2);
        sss.right = s;
        sss.left = ss;
        TreeNode root = new TreeNode(4);
        root.left = sss;
        root.right = rrr;

        TreeNode root = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        two.left = three;
        two.right = four;
        root.left = two;

        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        five.right = six;
        root.right = five;
 */