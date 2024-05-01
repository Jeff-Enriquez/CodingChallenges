/*
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * 
 * Constraints:
 *      n == ratings.length
 *      1 <= n <= 2 * 10^4
 *      0 <= ratings[i] <= 2 * 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // Traverse array from left to right
        // Any child with a higher rating than their left neighbor gets 1 more candy than their left neighbor has.
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        // Traverse array from right to left
        // Any child with a higher rating than their right neighbor gets 1 more candy than their right neighbor has.
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1] && candies[i] <= candies[i+1])
                candies[i] = candies[i+1] + 1;
        }
        // Add the total number of candies
        int totalCandies = ratings.length; // each child gets 1 candy
        for(int i = 0; i < candies.length; i++) {
            totalCandies += candies[i];
        }
        return totalCandies;
    }
}