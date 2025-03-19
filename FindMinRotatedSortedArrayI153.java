public class FindMinRotatedSortedArrayI153 {

    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int lastNum = nums[end];

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] <= lastNum) {
                end = mid;
            } else {
                start = mid;
            }

        }

        if (nums[start] <= lastNum) {
            return nums[start];
        } else {
            return nums[end];
        }

    }

}
