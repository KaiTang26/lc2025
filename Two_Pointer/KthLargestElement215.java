package Two_Pointer;

public class KthLargestElement215 {

    public static void main(String[] args) {

        KthLargestElement215 k = new KthLargestElement215();

        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };

        System.out.println("ans: " + k.findKthLargest(nums, 2));

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public int findKthLargest(int[] nums, int k) {

        return partition(nums, 0, nums.length - 1, nums.length - k);

    }

    private int partition(int[] nums, int start, int end, int indexK) {

        if (start >= end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pv = nums[(right + left) / 2];
        System.out.println("Pv " + pv);

        while (left <= right) {

            while (left <= right && nums[left] < pv) {
                left++;
            }

            while (left <= right && nums[right] > pv) {
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

        if (indexK <= right) {

            return partition(nums, start, right, indexK);

        }

        if (indexK >= left) {
            return partition(nums, left, end, indexK);
        }

        return nums[right + 1];

    }

}
