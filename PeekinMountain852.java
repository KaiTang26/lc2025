public class PeekinMountain852 {

    public int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                // increated
                end = mid;
            } else {
                start = mid;
            }
        }

        if (arr[start] > arr[end]) {
            return start;
        } else {
            return end;
        }

    }

}
