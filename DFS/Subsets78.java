package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets78 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return answer;
        }

        Arrays.sort(nums);

        // DFS travals not DC
        subsetsHelper(nums, new ArrayList<>(), answer);

        return answer;

    }

    private void subsetsHelper(int[] nums, List<Integer> subset, List<List<Integer>> answer) {

        answer.add(new ArrayList<>(subset));

        for (int i = 0; i < nums.length; i++) {

            subset.add(nums[i]);

            subsetsHelper(nums, subset, answer);

            subset.remove(subset.size() - 1);

        }

    }

}
