package Two_Pointer;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMax239 {

    public static void main(String[] args) {
        SlidingWindowMax239 m = new SlidingWindowMax239();

        int[] nums = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };

        for (int i : m.maxSlidingWindow(nums, 3)) {

            System.out.println(i);

        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int slow = 0;
        int fast = 0;
        int[] results = new int[nums.length - k + 1];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (fast < nums.length) {

            if (slow == 0 && fast < k) {
                pq.add(nums[fast]);
            } else {

                pq.add(nums[fast]);
                pq.remove(nums[slow]);
                slow++;
            }

            if (fast + 1 - k >= 0) {
                results[fast + 1 - k] = pq.peek();
            }

            fast++;

        }

        return results;

    }

}
