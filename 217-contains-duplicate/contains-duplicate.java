import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // add() returns false if num already exists in the set
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}