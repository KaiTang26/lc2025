package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);

        helper(candidates, 0, target, new ArrayList<>(), results);

        return results;

    }

    private void helper(int[] candidates, int startIndex, int target, List<Integer> subset,
            List<List<Integer>> results) {

        if (sum(subset) == target) {
            results.add(new ArrayList<>(subset));
        }

        if (sum(subset) > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (i != 0 && candidates[i - 1] == candidates[i] && i > startIndex) {
                continue;
            }

            subset.add(candidates[i]);

            helper(candidates, i + 1, target, subset, results);

            subset.remove(subset.size() - 1);

        }

    }

    private int sum(List<Integer> subset) {
        int sum = 0;

        for (int s : subset) {
            sum = sum + s;
        }

        return sum;
    }

}
