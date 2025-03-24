package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CloneGraph133 {

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        List<Node> allNodes = getAllNodes(node);

        Map<Node, Node> nodeMap = mappingNodes(allNodes);

        for (Node n : allNodes) {

            Node newNode = nodeMap.get(n);

            for (Node i : n.neighbors) {

                newNode.neighbors.add(nodeMap.get(i));

            }

        }

        return nodeMap.get(node);

    }

    private List<Node> getAllNodes(Node node) {

        List<Node> resutls = new ArrayList<>();

        Set<Node> allNodes = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        allNodes.add(node);

        while (!queue.isEmpty()) {

            Node n = queue.poll();

            if (!allNodes.contains(n)) {
                for (Node i : n.neighbors) {
                    if (!allNodes.contains(i)) {
                        queue.offer(i);
                        allNodes.add(i);
                    }
                }

                resutls.add(n);

            }

        }

        return resutls;

    }

    private Map<Node, Node> mappingNodes(List<Node> allNodes) {

        Map<Node, Node> nodeMap = new HashMap<>();

        for (Node n : allNodes) {
            Node newN = new Node(n.val, new ArrayList<>());
            nodeMap.put(n, newN);

        }

        return nodeMap;

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
