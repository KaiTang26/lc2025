package HashHeap;

import java.util.PriorityQueue;

public class KClosetPointsToOrigin973 {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int d = x * x + y * y;

            Point p = new Point(point, d);

            pq.offer(p);
        }

        int[][] ans = new int[k][];

        for (int i = 0; i < k; i++) {
            Point p = pq.poll();

            ans[i] = p.point;
        }

        return ans;

    }

}

class Point {

    int distance;
    int[] point;

    public Point(int[] point, int distance) {

        this.distance = distance;
        this.point = point;

    }
}
