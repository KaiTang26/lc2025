package April26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        Arrays.sort(candidates);

        backTrack(candidates, 0, new ArrayList<>(), ans, target, 0);

        return ans;

    }

    private void backTrack(int[] candidates, int start, List<Integer> subList, List<List<Integer>> ans, int target,
            int sum) {

        if (sum == target) {
            ans.add(new ArrayList<>(subList));
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            subList.add(candidates[i]);

            backTrack(candidates, i + 1, subList, ans, target, sum + candidates[i]);

            subList.remove(subList.size() - 1);

        }
    }

}
