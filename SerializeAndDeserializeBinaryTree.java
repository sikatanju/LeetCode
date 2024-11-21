import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SerializeAndDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null)   {
            return "";
        }

        StringBuilder str = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())    {
            TreeNode node = queue.poll();
            if (node == null)   {
                str.append("null ");
                continue;
            }
            str.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return str.toString();
    }
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] list = data.split(" ");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        queue.offer(root);

        for (int i=1; i<list.length; i++)   {
            TreeNode tempRoot = queue.poll();
            if (!list[i].equals("null"))   {
                TreeNode leftNode = new TreeNode(Integer.parseInt(list[i]));
                tempRoot.left = leftNode;
                queue.offer(leftNode);
            }
            i++;
            if(!list[i].equals("null"))    {
                TreeNode rightNode = new TreeNode(Integer.parseInt(list[i]));
                tempRoot.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}
/* Best runtime: 1ms:
public class Codec {
    private static final int MODULO = 90;
    private static final int SHIFT = 1001;
    StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        fill(root);
        return sb.toString();
    }

    private void encode(int code) {
        sb.append((char)(code / MODULO + '!'));
        sb.append((char)(code % MODULO + '!'));
    }

    private void fill(TreeNode node) {
        if (node == null) return;
        int flag = 0;
        if (node.left != null) {
            flag += 1;
        }
        if (node.right != null) {
            flag += 2;
        }
        int code = (node.val + SHIFT) * 4 + flag;
        encode(code);
        fill(node.left);
        fill(node.right);
    }

    // Decodes your encoded data to tree.
    String data;
    int pos;

    private TreeNode deserialize() {
        int code = (data.charAt(pos) - '!') * MODULO + data.charAt(pos + 1) - '!';
        pos += 2;
        TreeNode node = new TreeNode(code / 4 - SHIFT);
        if ((code % 4  & 1) == 1) {
            node.left = deserialize();
        }
        if ((code % 4  & 2) == 2) {
            node.right = deserialize();
        }
        return node;
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        this.data = data;
        pos = 0;
        return deserialize();
    }
}

*/

/* Second best runtime: 2ms

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(sb, root);
        return sb.toString();
    }

    private void serialize(StringBuilder sb, TreeNode root) {
        if(root == null){
            sb.append('#');
            return;
        }

        sb.append('^');
        sb.append(root.val);
        serialize(sb, root.left);
        serialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        TreeNode node;
        if(data.charAt(index) == '#'){
            node = null;
            index ++;
        }else{
            int i = index + 1;
            while(data.charAt(i) == '-' || Character.isDigit(data.charAt(i))){
                i ++;
            }
            int num = Integer.valueOf(data.substring(index + 1, i));
            index = i;
            node = new TreeNode(num);
            node.left = deserialize(data);
            node.right = deserialize(data);
        }

        return node;
    }
}

 */
