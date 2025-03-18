import java.util.Arrays;

public class MergeSort912 {

    public int[] sortArray(int[] nums) {

        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length;

        int[] nums1 = sortArray(Arrays.copyOfRange(nums, 0, len / 2));

        int[] nums2 = sortArray(Arrays.copyOfRange(nums, len / 2, len));

        return merge(nums1, nums2);

    }

    private int[] merge(int[] nums1, int[] nums2) {

        int[] sortedNums = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                sortedNums[k] = nums1[i];
                i++;
            } else {
                sortedNums[k] = nums2[j];
                j++;
            }
            k++;

        }

        while (i < nums1.length) {
            sortedNums[k] = nums1[i];
            i++;
            k++;

        }

        while (j < nums2.length) {
            sortedNums[k] = nums2[j];
            j++;
            k++;

        }

        return sortedNums;

    }

}
