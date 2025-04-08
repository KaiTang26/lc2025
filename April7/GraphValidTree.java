package April7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {

            adj.put(i, new HashSet<Integer>());

        }

        for (int[] edge : edges) {

            int node1 = edge[0];
            int node2 = edge[1];

            adj.get(node1).add(node2);
            adj.get(node2).add(node1);

        }

        Set<Integer> vistedNodes = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        vistedNodes.add(0);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            Set<Integer> linkedNodes = adj.get(node);

            for (int i : linkedNodes) {

                if (!vistedNodes.contains(i)) {

                    queue.offer(i);
                    vistedNodes.add(i);

                }

            }

        }

        return vistedNodes.size() == n;

    }

}
