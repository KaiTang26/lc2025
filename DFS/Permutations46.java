package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations46 {

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 2, 3 };

        Permutations46 p = new Permutations46();

        System.out.println(p.permute(nums));

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        helper(nums, 0, new ArrayList<>(), results, new HashSet<>());

        return results;

    }

    private void helper(int[] nums, int startIndex, List<Integer> subset, List<List<Integer>> results,
            Set<Integer> set) {

        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(i)) {
                continue;
            }

            subset.add(nums[i]);
            set.add(i);

            helper(nums, i + 1, subset, results, set);
            subset.remove(subset.size() - 1);
            set.remove(i);
        }

    }

}
