package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges994 {

    static int EMPTY_CELL = 0;
    static int FRESH_ORANGE = 1;
    static int ROTTEN_ORANGE = 2;

    public static void main(String[] args) {

        int[][] grid = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        RottingOranges994 r = new RottingOranges994();

        int ans = r.orangesRotting(grid);

        System.out.println(ans);

    }

    public int orangesRotting(int[][] grid) {

        int minutes = -1;

        List<int[]> fristCors = findFirstRottenOrange(grid);

        if (fristCors.isEmpty() && stillHaveFreshOrange(grid)) {
            return -1;
        }

        if (fristCors.isEmpty() && !stillHaveFreshOrange(grid)) {
            return 0;
        }

        minutes = countMinutes(fristCors, grid);

        if (stillHaveFreshOrange(grid)) {
            return -1;
        }

        return minutes;

    }

    private boolean stillHaveFreshOrange(int[][] grid) {

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == FRESH_ORANGE) {

                    return true;

                }
            }
        }

        return false;

    }

    private List<int[]> findFirstRottenOrange(int[][] grid) {

        List<int[]> rottenOrangeCoors = new ArrayList<>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {

                if (grid[x][y] == ROTTEN_ORANGE) {

                    rottenOrangeCoors.add(new int[] { x, y });

                }

            }
        }

        return rottenOrangeCoors;

    }

    private int countMinutes(List<int[]> coordinates, int[][] grid) {

        int minutes = -1;
        int[] dxs = new int[] { 1, 0, -1, 0 };
        int[] dys = new int[] { 0, 1, 0, -1 };

        Queue<int[]> queue = new LinkedList<>();
        for (int[] co : coordinates) {
            queue.offer(co);
        }

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] currCoodinate = queue.poll();
                int currX = currCoodinate[0];
                int currY = currCoodinate[1];

                for (int i = 0; i < 4; i++) {

                    int newX = currX + dxs[i];
                    int newY = currY + dys[i];

                    if (isInBound(newX, grid.length) && isInBound(newY, grid[0].length)
                            && grid[newX][newY] == FRESH_ORANGE) {

                        queue.offer(new int[] { newX, newY });

                        grid[newX][newY] = ROTTEN_ORANGE;

                    }

                }

            }

            minutes++;

        }

        return minutes;

    }

    private boolean isInBound(int val, int upperBound) {

        return val >= 0 && val < upperBound;

    }

}
