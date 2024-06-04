/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Constraints:
 *      2 <= nums.length <= 10^4
 *      -10^9 <= nums[i] <= 10^9
 *      -10^9 <= target <= 10^9
 *      Only one valid answer exists.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.*;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // Check if the second num needed to equal the target exists
            if(numMap.get(target - nums[i]) != null)
                return new int[] {numMap.get(target - nums[i]), i};
            // Add the current num to the hashmap,
                // check if that num already existed and if two of them equals the target,
            else if(numMap.put(nums[i], i) != null && nums[i] * 2 == target)
                return new int[] {numMap.get(nums[i]), i};
        }
        // Will never reach here
        return new int[]{};
    }
}
