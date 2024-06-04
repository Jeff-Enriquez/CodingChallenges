/*
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 * 
 * Constraints:
 *      1 <= nums.length <= 10^5
 *      -10^9 <= nums[i] <= 10^9
 *      0 <= k <= 10^5
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
import java.util.*;
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> seen = new HashMap<>();
        Integer i2;
        for(int i = 0; i < nums.length; i++) {
            if((i2 = seen.put(nums[i], i)) != null && i - i2 <= k)
                return true;
        }
        return false;
    }
}
