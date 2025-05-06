package April26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);

        backTrack(nums, new ArrayList<>(), new HashSet<>(), ans);

        return ans;

    }

    private void backTrack(int[] nums, List<Integer> subList, Set<Integer> hashSet, List<List<Integer>> ans) {

        if (hashSet.size() == nums.length) {

            ans.add(new ArrayList<>(subList));

            return;

        }

        for (int i = 0; i < nums.length; i++) {

            if (hashSet.contains(i)) {
                continue;
            }

            if (i != 0 && nums[i] == nums[i - 1] && !hashSet.contains(i - 1)) {
                continue;
            }

            subList.add(nums[i]);
            hashSet.add(i);

            backTrack(nums, subList, hashSet, ans);

            subList.remove(subList.size() - 1);
            hashSet.remove(i);

        }

    }

}
