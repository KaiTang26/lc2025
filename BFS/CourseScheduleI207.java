package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseScheduleI207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            adjList.put(i, new ArrayList());
        }

        for (int[] p : prerequisites) {
            int pre = p[1];
            int post = p[0];

            indegree.put(post, indegree.get(post) + 1);
            adjList.get(pre).add(post);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }

        int[] orders = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int cousrce = queue.poll();
            orders[index] = cousrce;
            index++;

            for (int i : adjList.get(cousrce)) {

                indegree.put(i, indegree.get(i) - 1);

                if (indegree.get(i) == 0) {
                    queue.offer(i);
                }

            }
        }

        if (index == numCourses) {
            return orders;
        } else {
            return new int[0];
        }

    }

}
