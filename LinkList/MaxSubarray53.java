package LinkList;

public class MaxSubarray53 {

    public static void main(String[] args) {
        MaxSubarray53 m = new MaxSubarray53();

        int[] nums = new int[] { -2, -1 };

        System.out.println(m.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int Max = Integer.MIN_VALUE;
        int minPrefixSum = 0;

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            prefixSum = prefixSum + nums[i];
            Max = Math.max(Max, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum); // Sum(i~j) = PrefixSum[j + 1] - PrefixSum[i]

            // System.out.println("data: " + prefixSum);
            // System.out.println("minPrefixSum: " + minPrefixSum);

        }
        return Max;

    }

}
