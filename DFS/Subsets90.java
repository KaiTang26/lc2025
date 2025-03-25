package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), results);

        return results;

    }

    private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results) {

        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {

            if (i != 0 && nums[i - 1] == nums[i] && i > startIndex) {
                continue;
            }

            subset.add(nums[i]);
            helper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);

        }

    }

}
