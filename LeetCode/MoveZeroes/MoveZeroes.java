/*
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * 
 * Constraints:
 *      1 <= nums.length <= 10^4
 *      -2^31 <= nums[i] <= 2^31 - 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int firstZeroIdx = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                if(firstZeroIdx == -1)
                    firstZeroIdx = i;
            } 
            else if(firstZeroIdx != -1) {
                nums[firstZeroIdx++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
