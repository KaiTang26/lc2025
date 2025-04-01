package April1;

public class FindFirstAndLast34 {

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[] { -1, -1 };

        if (nums == null || nums.length == 0) {

            return ans;

        }

        ans[0] = searchFirst(nums, target);

        ans[1] = searchLast(nums, target);

        return ans;

    }

    private int searchFirst(int[] nums, int target) {

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

        return -1;

    }

    private int searchLast(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }

        }

        if (nums[end] == target) {
            return end;
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;

    }

}
