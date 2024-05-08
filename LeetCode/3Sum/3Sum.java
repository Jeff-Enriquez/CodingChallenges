/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Constraints:
 *      3 <= nums.length <= 3000
 *      -10^5 <= nums[i] <= 10^5
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array
        Arrays.sort(nums);
        // Traverse array left to right. i is first pointer
        for (int i = 0; i < nums.length; i++) {
        	// Avoid duplicates
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            // left and right pointers
            int j = i + 1;
            int k = nums.length - 1;
            // while left pointer is less than right pointer
            while (j < k) {
            	// Get the total
                int total = nums[i] + nums[j] + nums[k];
                // Move the right pointer
                if (total > 0) {
                    k--;
                // Move the left pointer
                } else if (total < 0) {
                    j++;
                // Add to result list
                } else {
                	result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    // Avoid duplicates
                    while (nums[j] == nums[j-1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return result;        
    }
}