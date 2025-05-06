package April26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);

        backTrack(nums, 0, new ArrayList<>(), ans);

        return ans;

    }

    private void backTrack(int[] nums, int start, List<Integer> subList, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(subList));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            subList.add(nums[i]);

            backTrack(nums, i + 1, subList, ans);

            subList.remove(subList.size() - 1);
        }

    }

}
