class Solution {
    /*
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
	 * Time Complexity: O(n) where n = nums.length
	 * Space Complexity: O(1)
	 */

    // Example: nums = {1,2,3,4,5}, k = 2
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        // Reverse the entire array {5,4,3,2,1}
        reverse(nums, 0, nums.length - 1);
        // Reverse up to k index {4,5,3,2,1}
        reverse(nums, 0, k - 1);
        // Reverse after k index {4,5,1,2,3}
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int startI, int endI){
        while(startI < endI) {
            int tempNum = nums[startI];
            nums[startI] = nums[endI];
            nums[endI] = tempNum;
            startI++;
            endI--;
        }
    }
}