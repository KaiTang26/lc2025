public class SearchInsertPositon35 {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;

            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        if (nums[start] > target) {
            return start;
        }

        if (nums[end] < target) {
            return end + 1;
        }

        if (nums[end] > target && nums[start] < target) {
            return end;
        }

        return -1;

    }
}
