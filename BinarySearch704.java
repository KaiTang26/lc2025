public class BinarySearch704 {

    public static void main(String[] args) {

        int[] arr = { -1, 0, 3, 5, 9, 12 };

        int ans = search(arr, 2);
        System.out.println("Ans: " + ans);
    }

    public static int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        // start<end loop end at same number
        // start+1<end loop end at 2 number void dead loop
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;

            } else {
                end = mid;
            }

        }

        if (nums[start] == target) {
            return start;

        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

}
