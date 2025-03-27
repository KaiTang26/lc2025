package Two_Pointer;

import java.util.Arrays;

public class TwoSumLessThanK1099 {

    public int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);

        int ans = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length && right > 0 && left < right) {

            int sum = nums[left] + nums[right];

            if (sum > k) {
                right--;
            } else {

                ans = Math.max(ans, sum);

                left++;
            }

        }

        return -1;

    }

}
