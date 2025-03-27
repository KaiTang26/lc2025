package Two_Pointer;

public class SortColors75 {

    public static void main(String[] args) {

        SortColors75 s = new SortColors75();

        int[] nums = new int[] { 2, 0, 1 };

        s.sortColors(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void sortColors(int[] nums) {

        int lastPositionOfZero = partition(nums, 0, nums.length - 1, 0);
        partition(nums, lastPositionOfZero + 1, nums.length - 1, 1);

    }

    private int partition(int[] nums, int start, int end, int pv) {

        int left = start;
        int right = end;

        while (left <= right) {

            while (left <= right && nums[left] == pv) {
                left++;
            }

            while (left <= right && nums[right] != pv) {
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

        return right;

    }

}
