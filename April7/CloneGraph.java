package April7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        map.put(node, new Node(node.val, new ArrayList<>()));

        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            Node newNode = map.get(oldNode);

            for (Node n : oldNode.neighbors) {

                if (!map.containsKey(n)) {
                    queue.offer(n);
                    map.put(n, new Node(n.val, new ArrayList<>()));
                }

                newNode.neighbors.add(map.get(n));

            }

        }

        return map.get(node);

    }

}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
