class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int num : nums) {
            int left = 0;
            int right = size;

            // Find the first index whose value is >= num
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Replace a tail or extend the longest subsequence length
            tails[left] = num;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}