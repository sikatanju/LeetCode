import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {
    private List<Integer> list;
    private int index = -1;
    public BinarySearchTreeIterator(TreeNode root) {
        this.list = new ArrayList<>();
        traverseInOrder(root);
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index < list.size()-1;
    }

    private void traverseInOrder(TreeNode node) {
        if (node == null)
            return;

        traverseInOrder(node.left);
        this.list.add(node.val);
        traverseInOrder(node.right);
    }

//    class BSTIterator {
//        private List<Integer> list;
//        private int index = -1;
//        public BSTIterator(TreeNode root) {
//            this.list = new ArrayList<>();
//            traverseInOrder(root);
//        }
//
//        public int next() {
//            return list.get(++index);
//        }
//
//        public boolean hasNext() {
//            return index < list.size()-1;
//        }
//
//        private void traverseInOrder(TreeNode node) {
//            if (node == null)
//                return;
//
//            traverseInOrder(node.left);
//            this.list.add(node.val);
//            traverseInOrder(node.right);
//        }
//    }
}
