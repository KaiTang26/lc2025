package April8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        DFS(nums, 0, new ArrayList<>(), ans);

        return ans;

    }

    private void DFS(int[] nums, int start, List<Integer> sub, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(sub));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            sub.add(nums[i]);

            DFS(nums, i + 1, sub, ans);

            sub.remove(sub.size() - 1);

        }

    }

}
