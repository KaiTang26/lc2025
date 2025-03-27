package Two_Pointer;

public class SortArrayByParity905 {

    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < nums.length && right > 0 && left < right) {

            while (left < nums.length && left < right && nums[left] % 2 == 0) {
                left++;

            }

            while (right > 0 && left < right && nums[right] % 2 != 0) {
                right--;
            }

            if (left < nums.length && right > 0 && left < right) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }

            left++;
            right--;

        }

        return nums;

    }

}
