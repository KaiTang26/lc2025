package April8;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    BFS(grid, i, j);

                    count++;

                }

            }
        }

        return count;

    }

    private void BFS(char[][] grid, int i, int j) {

        int[] xChange = new int[] { -1, 0, 1, 0 };
        int[] yChange = new int[] { 0, 1, 0, -1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        grid[i][j] = '0';

        while (!queue.isEmpty()) {

            int[] cood = queue.poll();

            int x = cood[0];
            int y = cood[1];

            for (int k = 0; k < 4; k++) {

                int dx = x + xChange[k];
                int dy = y + yChange[k];

                if (inBound(dx, grid.length) && inBound(dy, grid[0].length) && grid[dx][dy] == '1') {
                    queue.offer(new int[] { dx, dy });
                    grid[dx][dy] = '0';
                }

            }

        }
    }

    private boolean inBound(int v, int upperBound) {

        return v >= 0 && v < upperBound;

    }

}
