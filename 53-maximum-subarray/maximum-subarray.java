class Solution {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at nums[i],
            // or extend the previous subarray.
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Track the best subarray sum found so far.
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}