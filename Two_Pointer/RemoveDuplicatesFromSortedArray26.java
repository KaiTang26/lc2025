package Two_Pointer;

public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {

        int duplicateArrayIndex = 0;
        int uniqueArrayIndex = 0;

        while (duplicateArrayIndex < nums.length) {

            if (nums[duplicateArrayIndex] != nums[uniqueArrayIndex]) {
                uniqueArrayIndex++;
                nums[uniqueArrayIndex] = nums[duplicateArrayIndex];
            }
            duplicateArrayIndex++;

        }

        return uniqueArrayIndex + 1;

    }

}
