/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * 
 * Example:
 *      Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 *      Output: 6
 *      Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * 
 * Constraints:
 *      n == height.length
 *      1 <= n <= 2 * 104
 *      0 <= height[i] <= 105
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int trap(int[] heights) {
        int totalWater = 0;
        int possibleWater = 0;
        int greatestHeight = 0;
        int lastGreatestHeightIndex = 0;
        // Find the last index of the greatest height (If two indexes have the same height, you will save the last index)
        for(int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if(height >= greatestHeight) {
                greatestHeight = height;
                lastGreatestHeightIndex = i;
            }
        }
        greatestHeight = 0;
        // Traverse array left to right up until last greatest height
        for(int i = 0; i <= lastGreatestHeightIndex; i++) {
            int height = heights[i];
            // If there is a new greatest height, save possibleWater
            if(height >= greatestHeight) {
                greatestHeight = height;
                totalWater += possibleWater;
                possibleWater = 0; // reset possible water
            }
            // If smaller than greatestHeight, increase possibleWater
            if(height < greatestHeight) {
                possibleWater += greatestHeight - height;
            }
        }
        greatestHeight = 0;
        possibleWater = 0;
        // Traverse array right to left up until last greatest height
        for(int i = heights.length - 1; i >= lastGreatestHeightIndex; i--) {
            int height = heights[i];
            // If there is a new greatest height, save possibleWater
            if(height >= greatestHeight) {
                greatestHeight = height;
                totalWater += possibleWater;
                possibleWater = 0; // reset possible water
            }
            // If smaller than greatestHeight, increase possibleWater
            if(height < greatestHeight) {
                possibleWater += greatestHeight - height;
            }
        }
        return totalWater;
    }
}