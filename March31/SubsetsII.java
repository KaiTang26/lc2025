package March31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        helper(nums, 0, new ArrayList<>(), ans);

        return ans;

    }

    public void helper(int[] nums, int start, List<Integer> subset, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {

            if (i != 0 && nums[i - 1] == nums[i] && i > start) {
                continue;
            }

            subset.add(nums[i]);

            helper(nums, i + 1, subset, ans);

            subset.remove(subset.size() - 1);

        }

    }

}
