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
        int rightI = 0;
        int sum = 0;
        while(rightI < nums.length && sum < target)
            sum += nums[rightI++];
        if(sum < target)
            return 0;
        int leftI = 0;
        while(rightI < nums.length) {
            sum -= nums[leftI++];
            sum += nums[rightI++];
            while(sum - nums[leftI] >= target)
                sum -= nums[leftI++];
        }
        while(sum - nums[leftI] >= target)
            sum -= nums[leftI++];
        return rightI - leftI;
    }
}