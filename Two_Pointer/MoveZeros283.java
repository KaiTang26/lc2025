package Two_Pointer;

public class MoveZeros283 {

    public static void main(String[] args) {
        MoveZeros283 m = new MoveZeros283();

        int[] nums = new int[] { 0 };

        m.moveZeroes(nums);

        for (int i : nums) {

            System.out.println(i);

        }

    }

    public void moveZeroes(int[] nums) {

        int nonZero = 0;
        int zero = 0;

        while (nonZero < nums.length && zero < nums.length) {

            while (nonZero < nums.length && nums[nonZero] == 0) {
                nonZero++;

            }

            while (zero < nums.length && nums[zero] != 0) {
                zero++;
            }

            // swtich value

            if (nonZero < nums.length && zero < nums.length) {
                if (nums[zero] == 0 && nums[nonZero] != 0 && nonZero > zero) {

                    nums[zero] = nums[nonZero];
                    nums[nonZero] = 0;

                    zero++;
                    nonZero++;
                } else if (nums[zero] == 0 && nums[nonZero] != 0 && nonZero < zero) {
                    nonZero++;
                } else {
                    zero++;
                    nonZero++;
                }

            }

        }

    }

}
