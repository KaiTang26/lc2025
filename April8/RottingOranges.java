package April8;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    int EMPTY_CELL = 0;
    int FRESH_ORG = 1;
    int ROTTEN_ORG = 2;

    public int orangesRotting(int[][] grid) {

        int count = BFS(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == FRESH_ORG) {
                    // BFS
                    return -1;
                }

            }
        }

        return count;

    }

    private int BFS(int[][] grid) {

        int count = 0;
        int[] xChange = new int[] { -1, 0, 1, 0 };
        int[] yChange = new int[] { 0, 1, 0, -1 };

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == ROTTEN_ORG) {

                    queue.offer(new int[] { i, j });

                }

            }
        }

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] rottenOrg = queue.poll();
                int oX = rottenOrg[0];
                int oY = rottenOrg[1];

                for (int k = 0; k < 4; k++) {

                    int dx = oX + xChange[k];
                    int dy = oY + yChange[k];

                    if (inBound(dx, grid.length) && inBound(dy, grid[0].length) && grid[dx][dy] == FRESH_ORG) {

                        grid[dx][dy] = ROTTEN_ORG;
                        queue.offer(new int[] { dx, dy });

                    }

                }

            }

            if (!queue.isEmpty()) {
                count++;
            }
        }

        return count;

    }

    private boolean inBound(int v, int upperBound) {

        return v >= 0 && v < upperBound;

    }

}
