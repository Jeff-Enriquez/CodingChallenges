/*
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * 
 * 
 * Constraints:
 *      1 <= target <= 10^9
 *      1 <= nums.length <= 10^5
 *      1 <= nums[i] <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minimalLength = nums.length + 1;
        int firstIdx = 0;
        int lastIdx = 0;
        int sum = nums[firstIdx];
        while(lastIdx < nums.length - 1 || sum >= target) {
            if(sum >= target) {
                if(lastIdx - firstIdx + 1 < minimalLength)
                    minimalLength = lastIdx - firstIdx + 1;
                sum -= nums[firstIdx++];
            } else {
                sum += nums[++lastIdx];
            }
        }
        if(minimalLength == nums.length + 1)
            return 0;
        return minimalLength;
    }
}