public class MergeSortedArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temps = new int[m + n];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temps[k] = nums1[i];
                i++;
            } else {
                temps[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            temps[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            temps[k] = nums2[j];
            j++;
            k++;
        }

        for (int l = 0; l < m + n; l++) {
            nums1[l] = temps[l];
        }

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Merge nums1 and nums2 from back to front
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If nums2 still has elements, copy them
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

}
