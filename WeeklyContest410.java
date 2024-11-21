import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeeklyContest410 {
    private int goodNode;
    private int count;

    public int countGoodNodes(int[][] edges) {
        for (int i=0; i<edges.length; i++)  {
            int temp = edges[i][0];
            int temp1 = edges[i][1];
            if (temp > temp1)   {
                edges[i][0] = temp1;
                edges[i][1] = temp;
            }
        }
//        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = null;
        this.goodNode = 0;
        for (int[] row: edges)  {
            int node1 = row[0];
            int node2 = row[1];

            if (root == null)   {
                root = new TreeNode(node1);
                map.put(node1, root);
                TreeNode newNode = new TreeNode(node2);
                if (root.childList == null)
                    root.childList = new ArrayList<>();

                map.put(node2, newNode);
                root.childList.add(newNode);
            }   else {
                if (map.containsKey(node1)) {
                    var temp = map.get(node1);
                    TreeNode newNode = new TreeNode(node2);
                    map.put(node2, newNode);
                    if (temp.childList == null)
                        temp.childList = new ArrayList<>();

                    temp.childList.add(newNode);
                }   else if (map.containsKey(node2))    {
                    var temp = map.get(node2);
                    TreeNode newNode = new TreeNode(node1);
                    map.put(node1, newNode);
                    if (temp.childList == null)
                        temp.childList = new ArrayList<>();

                    temp.childList.add(newNode);
                }
            }
        }
        preorder(root);
        return this.goodNode;
    }
    private void preorder(TreeNode root)    {
        if (root == null)
            return;

        if (root.childList == null)    {
             this.goodNode++;
             return;
        }

        if (root.childList != null)  {
            int[] ara = new int[root.childList.size()];
            int i=0;
            for (var temp: root.childList)  {
                countChild(temp);
                ara[i++] = this.count;
                this.count = 0;
            }
            this.count = ara[0];
            boolean check = true;
            for (int j=0; j<ara.length; j++)    {
                if (ara[j] != this.count)   {
                    check = false;
                    break;
                }
            }
            if (check)
                this.goodNode++;

            this.count = 0;
        }
        for (var temp: root.childList)
            preorder(temp);
    }
    private void countChild(TreeNode root)   {
        if (root == null)
            return;

        this.count++;
        if (root.childList != null) {
            for (var temp: root.childList)
                countChild(temp);
        }
    }
}


/* Easy one:
public int finalPositionOfSnake(int n, List<String> commands) {
        int[][] grid = new int[n][n];
        int count = 0, ii = 0, jj = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                grid[i][j] = count++;
            }
        }
        for (var str: commands) {
            if (str.equals("RIGHT"))
                jj++;
            else if (str.equals("DOWN"))
                ii++;
            else if (str.equals("UP"))
                ii--;
            else if(str.equals("LEFT"))
                jj--;
        }
        return grid[ii][jj];
    }
 */