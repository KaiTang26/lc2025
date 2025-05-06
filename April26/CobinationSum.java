package April26;

import java.util.ArrayList;
import java.util.List;

public class CobinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return ans;
        }

        backTrack(candidates, target, 0, 0, new ArrayList<>(), ans);

        return ans;

    }

    private void backTrack(int[] candidates, int target, int sum, int start, List<Integer> subList,
            List<List<Integer>> ans) {

        if (sum == target) {
            ans.add(new ArrayList<>(subList));
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            subList.add(candidates[i]);

            backTrack(candidates, target, sum + candidates[i], i, subList, ans);

            subList.remove(subList.size() - 1);
        }

    }

}
