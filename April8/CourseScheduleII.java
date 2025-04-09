package April8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
        }

        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (int[] p : prerequisites) {

            int pre = p[1];
            int post = p[0];

            if (!adj.containsKey(pre)) {
                adj.put(pre, new HashSet<>());
            }
            adj.get(pre).add(post);
            indegree.put(post, indegree.get(post) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int c : indegree.keySet()) {

            if (indegree.get(c) == 0) {
                queue.offer(c);
            }

        }

        int[] orders = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();
            orders[index] = course;
            index++;

            if (adj.containsKey(course)) {

                for (int next : adj.get(course)) {

                    indegree.put(next, indegree.get(next) - 1);

                    if (indegree.get(next) == 0) {
                        queue.offer(next);
                    }

                }
            }

        }

        if (index == numCourses) {

            return orders;

        } else {
            return new int[] {};
        }

    }

}
