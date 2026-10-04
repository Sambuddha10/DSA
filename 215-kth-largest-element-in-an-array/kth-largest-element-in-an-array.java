import java.util.concurrent.ThreadLocalRandom;

class Solution {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        // kth largest = (n - k)th smallest index, using 0-based indexing
        int targetIndex = n - k;

        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // This line will never be reached for valid input
    }

    private int partition(int[] nums, int left, int right) {
        // Random pivot reduces the chance of worst-case behavior
        int randomIndex = ThreadLocalRandom.current().nextInt(left, right + 1);

        swap(nums, randomIndex, right);

        int pivot = nums[right];
        int smallerIndex = left;

        // Move values smaller than pivot to the left
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, smallerIndex);
                smallerIndex++;
            }
        }

        // Put pivot into its final sorted position
        swap(nums, smallerIndex, right);

        return smallerIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}