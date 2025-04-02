package April2;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[start]) {

                if (nums[mid] <= target) {
                    start = mid;
                } else if (nums[mid] > target && target >= nums[start]) {
                    end = mid;

                } else {
                    start = mid;

                }

            } else {

                if (nums[mid] == target) {
                    start = mid;
                } else if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target && nums[end] >= target) {
                    start = mid;

                } else {
                    end = mid;
                }

            }

        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;

    }

}
