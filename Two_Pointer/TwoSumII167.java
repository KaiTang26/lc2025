package Two_Pointer;

public class TwoSumII167 {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < numbers.length && right > 0 && left < right) {

            int sum = numbers[right] + numbers[left];

            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            } else if (sum > target) {

                right--;

            } else {

                left++;

            }

        }

        return result;

    }

}
