/**
 * QuickSort Partition Function Template
 * This template shows different approaches to implementing the partition
 * function
 * which is the core of the QuickSort algorithm.
 */
public class QuickSortPartitionTemplate {

    public static int partitionWithFirstElementPivot(int[] arr, int start, int end) {
        // Base case check (can be omitted if handled by the main sort function)
        if (start >= end)
            return start;

        // Select pivot (in this case, first element)
        int pivot = arr[start];

        // Initialize pointers
        int left = start; // Starts from beginning and moves right
        int right = end; // Starts from end and moves left

        // Main partitioning loop
        while (left <= right) {
            // Find an element on left side greater than or equal to pivot
            while (left <= right && arr[left] < pivot) {
                left++;
            }

            // Find an element on right side less than or equal to pivot
            while (left <= right && arr[right] > pivot) {
                right--;
            }

            // Swap elements if pointers haven't crossed
            if (left <= right) {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                // Move pointers
                left++;
                right--;
            }
        }

        // right now points to the last element less than pivot
        // left points to the first element greater than pivot
        return right; // Return the position where pivot belongs
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            // Get partitioning index
            int pivotIndex = partitionWithFirstElementPivot(arr, start, end);

            // Recursively sort elements before and after partition
            quickSort(arr, start, pivotIndex);
            quickSort(arr, pivotIndex + 1, end);
        }
    }
}