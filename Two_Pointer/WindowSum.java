package Two_Pointer;

import LinkList.SubarraySumEqualsK560;

public class WindowSum {

    public static void main(String[] args) {
        WindowSum m = new WindowSum();

        int[] nums = new int[] { 1, 2, 7, 8, 5 };

        for (int i : m.winSum(nums, 3)) {

            System.out.println(i);

        }

    }

    public int[] winSum(int[] nums, int k) {

        int slow = 0;
        int fast = 0;
        int sum = 0;

        int[] results = new int[nums.length - k + 1];

        while (fast < nums.length) {

            if (slow == 0 && fast - slow < k) {
                sum = sum + nums[fast];
            } else {

                sum = sum + nums[fast] - nums[slow];
                slow++;

            }

            if (fast + 1 - k >= 0) {
                results[fast + 1 - k] = sum;
            }

            fast++;

        }

        return results;

    }

}
