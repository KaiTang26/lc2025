package LinkList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubarraySumEqualsK560 {

    public static void main(String[] args) {
        SubarraySumEqualsK560 m = new SubarraySumEqualsK560();

        int[] nums = new int[] { -1, -1, 1 };

        System.out.println(m.subarraySum(nums, 1));

    }

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (prefix.containsKey(sum - k)) {
                // P[j+1]-k = P[i]
                count = count + prefix.get(sum - k);
            }

            if (prefix.containsKey(sum)) {
                prefix.put(sum, prefix.get(sum) + 1);
            } else {
                prefix.put(sum, 1);
            }

        }

        return count;

    }
}
