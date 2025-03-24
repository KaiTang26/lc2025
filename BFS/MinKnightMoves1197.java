package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinKnightMoves1197 {

    public int minKnightMoves(int x, int y) {

        int minSteps = 0;

        if (x == 0 && y == 0) {
            return minSteps;
        }

        int[] dx = new int[] { 1, 1, -1, -1, 2, 2, -2, -2 };
        int[] dy = new int[] { 2, -2, 2, -2, 1, -1, 1, -1 };

        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[607][607];

        queue.offer(new Coordinate(0, 0));
        visited[0 + 302][0 + 302] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            minSteps++;

            for (int s = 0; s < size; s++) {

                Coordinate coordinate = queue.poll();

                int currX = coordinate.x;
                int currY = coordinate.y;

                for (int i = 0; i < 8; i++) {

                    int newX = currX + dx[i];
                    int newY = currY + dy[i];

                    if (newX == x && newY == y) {

                        return minSteps;
                    } else {

                        if (!visited[newX + 302][newY + 302]) {
                            visited[newX + 302][newY + 302] = true;
                            queue.offer(new Coordinate(newX, newY));

                        }

                    }
                }

            }

        }

        return minSteps;

    }

}

class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
