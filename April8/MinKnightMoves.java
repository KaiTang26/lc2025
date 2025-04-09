package April8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinKnightMoves {

    public static void main(String[] args) {

        MinKnightMoves m = new MinKnightMoves();

        System.out.println(m.minKnightMoves(2, 112));

    }

    public int minKnightMoves(int x, int y) {

        int[] xChange = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
        int[] yChange = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };

        int count = 0;

        if (x == 0 && y == 0) {
            return count;
        }

        Queue<Coodinate> queue = new LinkedList<>();

        boolean[][] visited = new boolean[607][607];

        Coodinate start = new Coodinate(0, 0);

        queue.offer(start);
        visited[0 + 302][0 + 302] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            count++;

            for (int j = 0; j < size; j++) {

                Coodinate step = queue.poll();

                int stepX = step.x;
                int stepY = step.y;

                for (int i = 0; i < 8; i++) {

                    int dx = stepX + xChange[i];
                    int dy = stepY + yChange[i];

                    Coodinate newStep = new Coodinate(dx, dy);

                    if (dx == x && dy == y) {

                        return count;
                    }

                    if (!visited[dx + 302][dy + 302]) {

                        queue.offer(newStep);
                        visited[dx + 302][dy + 302] = true;
                    }

                }

            }

        }

        return count;

    }

}

class Coodinate {

    int x;
    int y;

    public Coodinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
