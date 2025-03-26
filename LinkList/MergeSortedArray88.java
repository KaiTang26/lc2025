package LinkList;

public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {

            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }

        int size = m + n;

        while (size != 0 && m > 0 && n > 0) {

            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[size - 1] = nums2[n - 1];
                n--;
            } else {
                nums1[size - 1] = nums1[m - 1];
                nums1[m - 1] = 0;
                m--;
            }
            size--;

        }

        while (size != 0 && n > 0) {

            nums1[size - 1] = nums2[n - 1];
            n--;
            size--;

        }

    }

}
