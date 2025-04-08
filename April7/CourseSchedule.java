package April7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            adj.put(i, new HashSet<>());
        }

        for (int[] edge : prerequisites) {

            int pre = edge[1];
            int post = edge[0];

            adj.get(pre).add(post);
            indegree.put(post, indegree.get(post) + 1);

        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            int inde = indegree.get(i);

            if (inde == 0) {
                queue.offer(i);
            }

        }

        int numberOfVisted = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            for (int next : adj.get(course)) {

                indegree.put(next, indegree.get(next) - 1);

                if (indegree.get(next) == 0) {
                    queue.offer(next);
                }

            }

            numberOfVisted++;

        }

        return numberOfVisted == numCourses;

    }

}
