// [Tip for implementing solution](https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/)
class Solution {
    /*
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * 
     * Constraints:
     *      2 <= nums.length <= 105
     *      -30 <= nums[i] <= 30
     *      The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * 
     * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
     * 
     * Time Complexity: O(n) where n = nums.length
	 * Space Complexity: O(n)
     *      - extra space O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] answers = new int[size];

        // Calculate the prefixProduct, store it in the answers array
        answers[0] = nums[0];
        for(int i = 1; i < size - 1; i++)
            answers[i] = answers[i-1] * nums[i];

        // For tracking the suffixProduct
        int suffixProduct = nums[size - 1];
        // Calculate the answer
        answers[size - 1] = answers[size - 2];
        for(int i = size - 2; i > 0; i--) {
            answers[i] = answers[i-1] * suffixProduct;
            suffixProduct *= nums[i];
        }
        answers[0] = suffixProduct;
        return answers;
    }
}