package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII47 {

    public static void main(String[] args) {

        int[] nums = new int[] { 1, 1, 2 };

        PermutationsII47 p = new PermutationsII47();

        System.out.println(p.permuteUnique(nums));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        Arrays.sort(nums);

        helper(nums, new ArrayList<>(), results, new HashSet<>());

        return results;

    }

    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> results, Set<Integer> set) {

        if (subset.size() == nums.length) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(i)) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) {
                continue;
            }

            subset.add(nums[i]);
            set.add(i);
            helper(nums, subset, results, set);
            set.remove(i);
            subset.remove(subset.size() - 1);
        }

    }

}
