class Solution {
    /*
     * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
     * Return true if you can reach the last index, or false otherwise.
     *
     * Time Complexity: O(n) where n = nums.length
	 * Space Complexity: O(1)
     */
    public boolean canJump(int[] nums) {
        int steps = nums[0];
        // Impossible if the first step is 0 and the array is greater than 1
        if(steps == 0 && nums.length != 1)
            return false;
        // Loop through the rest of the steps
        // You do not need to check the last step, it is ok to reach 0 steps on the last step
        for(int i = 1; i < nums.length - 1; i++) {
            // as you step through the array, your step value goes down
            // if you reach a number in the array that is greater than your current step value - that becomes the new step value
            if(nums[i] > --steps)
                steps = nums[i];
            // you can no longer proceed through the array
            if(steps == 0)
                return false;
        }
        // You have stepped through the entire array
        return true;
    }
}