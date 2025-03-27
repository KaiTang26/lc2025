package Two_Pointer;

import java.util.Arrays;

public class MaxNumberOfKSumPairs1679 {

    public static void main(String[] args) {
        MaxNumberOfKSumPairs1679 v = new MaxNumberOfKSumPairs1679();

        int[] nums = new int[] { 1, 2, 3, 4 };

        System.out.println(v.maxOperations(nums, 5));
    }

    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);

        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length && right > 0 && left < right) {

            int sum = nums[left] + nums[right];

            System.out.println("sum: " + sum);

            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum > k) {
                right--;
            } else {
                left++;
            }

        }

        return count;

    }

}
