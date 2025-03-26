package LinkList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Boolean> intersections = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            if (!intersections.containsKey(i)) {
                intersections.put(i, false);
            }
        }

        for (int i : nums2) {

            if (intersections.containsKey(i) && !intersections.get(i)) {
                intersections.put(i, true);
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;

    }

}
