import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (lastIndex.containsKey(nums[i])) {
                int previousIndex = lastIndex.get(nums[i]);

                if (i - previousIndex <= k) {
                    return true;
                }
            }

            // Store/update the most recent index of this number
            lastIndex.put(nums[i], i);
        }

        return false;
    }
}