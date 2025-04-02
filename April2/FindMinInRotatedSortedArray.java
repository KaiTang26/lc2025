package April2;

public class FindMinInRotatedSortedArray {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }

        }

        return Math.min(nums[start], nums[end]);

    }

}
