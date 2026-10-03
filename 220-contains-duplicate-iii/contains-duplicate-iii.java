import java.util.TreeSet;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long current = nums[i];

            // Find the smallest value in the window that is >= current
            Long ceil = window.ceiling(current);

            if (ceil != null && ceil - current <= valueDiff) {
                return true;
            }

            // Find the largest value in the window that is <= current
            Long floor = window.floor(current);

            if (floor != null && current - floor <= valueDiff) {
                return true;
            }

            window.add(current);

            // Keep only elements whose index difference from i is at most indexDiff
            if (i >= indexDiff) {
                window.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}