/*
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 * 
 * Constraints:
 *      2 <= numbers.length <= 3 * 10^4
 *      -1000 <= numbers[i] <= 1000
 *      numbers is sorted in non-decreasing order.
 *      -1000 <= target <= 1000
 *      The tests are generated such that there is exactly one solution.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Create two pointers: rightIdx and leftIdx
        int rightIdx = numbers.length - 1;
        // Traverse through numbers left to right
        for(int leftIdx = 0; leftIdx < numbers.length; leftIdx++) {
            // Traverse through numbers right to left
            for(; rightIdx > leftIdx; rightIdx--) {
                // Calculate the sum of both indexes
                int sum = numbers[leftIdx] + numbers[rightIdx];
                // If the sum is smaller than the target, increase the left indexe
                if(sum < target)
                    break;
                // If the sum equals the target, return indexes
                else if(target == sum)
                    return new int[]{leftIdx + 1, rightIdx + 1};
                // else, innter-loop continues, right index is incremented
            }
        }
        return new int[]{-1, -1};
    }
}
