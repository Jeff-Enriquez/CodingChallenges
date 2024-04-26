class Solution {
    /*
     * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
     * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
     *     0 <= j <= nums[i] and
     *     i + j < n
     * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
     *
     * Time Complexity: O(n) where n = nums.length
	 * Space Complexity: O(1)
     */
    public int jump(int[] nums) {
        // No jumps if length is 1
        if(nums.length == 1)
            return 0;
        // Track number of jumps
        int jumpCount = 0;
        int i = 0;
        // Loop through entire array
        while(i < nums.length) {
            // Track how many steps left in the current jump
            int stepsRemaining = nums[i];
            // Check if you can reach the end
            if(stepsRemaining + i >= nums.length - 1) {
                jumpCount++;
                break;
            }
            // index of the next place to jump
            int jumpTo = -1;
            int bestJump = -1; // used to calculate the best place to jump
            //
            // Check all possible positions that the current index can jump to
            int j = i;
            while(stepsRemaining-- > 0 && ++j < nums.length) {
                // Calculate the best jump position
                if(nums[j] - stepsRemaining > bestJump) {
                    jumpTo = j;
                    bestJump = nums[j] - stepsRemaining;
                }
            }
            // Increment jump count
            jumpCount++;
            // Jump to new position
            i = jumpTo;
        }
        return jumpCount;
    }
}