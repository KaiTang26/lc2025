import java.util.HashMap;
import java.util.Map;

class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> targetPositionMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int complement = target - number;
            if (targetPositionMap.containsKey(complement)) {
                return new int[]{targetPositionMap.get(complement), i};
            }
            targetPositionMap.put(number, i);
        }

        return new int[0];

    }

    public static void main(String[] args) {

        TwoSum1 ts = new TwoSum1();

        int[] input = { 2, 7, 11, 15 };

        int[] result = ts.twoSum(input, 9);

        System.out.print(result[0]);

        System.out.print(result[1]);

    }
}