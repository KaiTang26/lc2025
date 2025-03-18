
public class QuickSort912 {
    public int[] sortArray(int[] nums) {

        partition(nums, 0, nums.length - 1);

        return nums;

    }

    private void partition(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;

        int pivot = nums[start];

        while (left <= right) {

            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        partition(nums, start, right);
        partition(nums, left, end);
    }

}
