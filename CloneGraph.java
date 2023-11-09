import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (node.neighbors.size() == 0) {
            Node temp = new Node(1);
            return temp;
        }

        Set<Node> set = new HashSet<>();
        Map<Integer, List<Node>> map = new HashMap<>();
        Map<Integer, Node> nodeMap = new HashMap<>();

        getAllNode(node, set, map);
        int size = set.size();

        for (int i=1; i<=size; i++) {
            Node root = new Node(i);
            nodeMap.put(i, root);
        }

        for (int i=1; i<=size; i++) {
            var tempRoot = nodeMap.get(i);

            for (var tempNode: map.get(i))
                tempRoot.neighbors.add(nodeMap.get(tempNode.val));
        }

        return nodeMap.get(1);
    }

    private void getAllNode(Node root, Set<Node> visited, Map<Integer, List<Node>> map)   {
        System.out.println(root);
        visited.add(root);
        map.put(root.val, root.neighbors);

        for (var node: root.neighbors)  {
            if (!visited.contains(node))
                getAllNode(node, visited, map);
        }
    }
}
