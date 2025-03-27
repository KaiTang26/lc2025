package HashHeap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII264 {

    public int nthUglyNumber(int n) {

        long ans = 1;

        int[] uglyFactor = new int[] { 2, 3, 5 };
        Set<Long> visitedNums = new HashSet<>();

        PriorityQueue<Long> pq = new PriorityQueue<>(); // min heap

        pq.offer(1L);
        visitedNums.add(1L);

        for (int i = 0; i < n; i++) {

            ans = pq.poll();

            for (int f : uglyFactor) {

                long newUglyNum = ans * f;

                if (!visitedNums.contains(newUglyNum)) {

                    visitedNums.add(newUglyNum);
                    pq.offer(newUglyNum);

                }

            }

        }

        return (int) ans;

    }

}
