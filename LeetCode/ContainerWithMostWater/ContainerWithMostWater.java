/*
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 * 
 * Constraints:
 *      n == height.lengt
 *      2 <= n <= 10
 *      0 <= height[i] <= 104
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int maxArea(int[] heights) {
        int leftIdx = 0;
        int rightIdx = heights.length - 1;
        int length = rightIdx;
        int maxArea = 0;
        while(leftIdx < rightIdx) {
            int height = 0;
            if(heights[leftIdx] == heights[rightIdx]) {
                height = heights[leftIdx];
                leftIdx++;
                rightIdx--;
            } else if(heights[leftIdx] > heights[rightIdx]) {
                height = heights[rightIdx];
                rightIdx--;
            } else {
                height = heights[leftIdx];
                leftIdx++;
            }
            int area = length * height;
            if(area > maxArea)
                maxArea = area;
            length = rightIdx - leftIdx;
        }
        return maxArea;
    }
}