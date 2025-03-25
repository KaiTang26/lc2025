package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumI39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return results;
        }

        helper(candidates, 0, new LinkedList<>(), results, target);

        return results;

    }

    private void helper(int[] candidates, int startIndex, List<Integer> subset, List<List<Integer>> results,
            int target) {

        if (sum(subset) == target) {
            results.add(new ArrayList<>(subset));
        }

        if (sum(subset) > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            subset.add(candidates[i]);

            helper(candidates, i, subset, results, target);

            subset.remove(subset.size() - 1);
        }

    }

    private int sum(List<Integer> subset) {

        int sum = 0;

        for (int n : subset) {
            sum = sum + n;
        }

        return sum;

    }

}
