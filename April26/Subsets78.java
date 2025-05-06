import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {

            return ans;

        }

        backTrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backTrack(int[] nums, int start, List<Integer> subList, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(subList));

        for (int i = start; i < nums.length; i++) {

            subList.add(nums[i]);

            backTrack(nums, i + 1, subList, ans);

            subList.remove(subList.size() - 1);

        }

    }
}