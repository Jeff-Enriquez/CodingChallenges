/*
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * 
 * Constraints:
 *      1 <= nums.length <= 10^5
 *      nums[i] is either 0 or 1.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
import java.util.*;
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int maxLen = 0;
        int currLen = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if(sum == 0)
                maxLen = i + 1;
            else if(prefixSum.containsKey(sum))
                maxLen = Math.max(maxLen, i - prefixSum.get(sum));
            else
                prefixSum.put(sum, i);
        }
        return maxLen;
    }
}
