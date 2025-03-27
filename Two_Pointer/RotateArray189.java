package Two_Pointer;

public class RotateArray189 {

    public static void main(String[] args) {

        System.out.println(3 % 2);
    }

    public void rotate(int[] nums, int k) {

        if (k == 0 || nums.length == 1) {
            return;
        }

        int offset = k > nums.length ? k % nums.length : k;

        int index = nums.length - offset;

        reverse(nums, 0, index);
        reverse(nums, index, nums.length);
        reverse(nums, 0, nums.length);

    }

    private void reverse(int[] nums, int start, int end) {

        int left = start;
        int right = end - 1;

        while (right >= 0 && left < nums.length && left < right) {

            int temp = nums[left];

            nums[left] = nums[right];

            nums[right] = temp;

            left++;
            right--;

        }

    }

}
