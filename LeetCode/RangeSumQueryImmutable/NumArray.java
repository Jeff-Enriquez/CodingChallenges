/*
 * Given an integer array nums, handle multiple queries of the following type:
 *      1. Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 * Implement the NumArray class:
 *      - NumArray(int[] nums) Initializes the object with the integer array nums.
 *      - int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 * 
 * Constraints:
 *      1 <= nums.length <= 10^4
 *      -10^5 <= nums[i] <= 10^5
 *      0 <= left <= right < nums.length
 *      At most 10^4 calls will be made to sumRange.
 */
public class NumArray {
    int[] prefix;

    /*
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            prefix[i] = prefix[i-1] + nums[i];
    }
    
    /*
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int sumRange(int left, int right) {
        if(left == 0)
            return prefix[right];
        return prefix[right] - prefix[left - 1];
    }
}
