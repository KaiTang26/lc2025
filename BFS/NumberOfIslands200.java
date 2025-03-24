package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands200 {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {

                if (grid[m][n] == '1') {
                    // start BFS to
                    int[] coordinate = new int[] { m, n };

                    findWholeIsland(coordinate, grid);

                    count++;
                }

            }
        }

        return count;

    }

    private void findWholeIsland(int[] coordinate, char[][] grid) {

        int[] deltaX = { 1, 0, -1, 0 };
        int[] deltaY = { 0, 1, 0, -1 };

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(coordinate);

        while (!queue.isEmpty()) {

            int[] preCoor = queue.poll();
            int m = preCoor[0];
            int n = preCoor[1];
            grid[m][n] = '0';

            for (int i = 0; i < 4; i++) {

                int newM = m + deltaX[i];
                int newN = n + deltaY[i];

                if (isInbound(newM, grid.length) && isInbound(newN, grid[0].length) && grid[newM][newN] == '1') {

                    int[] newCoor = { newM, newN };

                    queue.offer(newCoor);

                }
            }

        }

    }

    private boolean isInbound(int newIndex, int upperBound) {
        return newIndex >= 0 && newIndex < upperBound;
    }

}
