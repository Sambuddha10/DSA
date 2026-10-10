class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long totalDiff = 0;
        int maxDiff = 0;
        long k = (long) k1 + k2;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        // If we can eliminate every difference, answer is 0.
        if (totalDiff <= k) {
            return 0L;
        }

        // Binary search the smallest possible maximum remaining difference.
        int lo = 0, hi = maxDiff;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            long needed = 0;
            for (int d : diff) {
                if (d > mid) {
                    needed += d - mid;
                }
            }

            if (needed <= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        int cap = lo;

        // Apply the cap and count leftover operations.
        for (int i = 0; i < n; i++) {
            if (diff[i] > cap) {
                k -= diff[i] - cap;
                diff[i] = cap;
            }
        }

        // Spend leftover operations on entries currently equal to cap.
        if (k > 0) {
            for (int i = 0; i < n && k > 0; i++) {
                if (diff[i] == cap) {
                    diff[i]--;
                    k--;
                }
            }
        }

        long ans = 0;
        for (int d : diff) {
            ans += (long) d * d;
        }

        return ans;
    }
}