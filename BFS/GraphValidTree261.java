package BFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length == n - 1) {

            Map<Integer, Set<Integer>> adjList = new HashMap<>();

            for (int i = 0; i < n; i++) {
                adjList.put(i, new HashSet<>());
            }

            for (int i = 0; i < edges.length; i++) {

                int node1 = edges[i][0];
                int node2 = edges[i][1];

                adjList.get(node1).add(node2);
                adjList.get(node2).add(node1);
            }

            Set<Integer> vistedNodes = new HashSet<>();

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(0);
            vistedNodes.add(0);

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int i : adjList.get(node)) {

                    if (!vistedNodes.contains(i)) {

                        queue.offer(i);
                        vistedNodes.add(i);

                    }

                }

            }

            return vistedNodes.size() == n;

        }

        return false;

    }

}
