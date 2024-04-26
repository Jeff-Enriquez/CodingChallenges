class Solution {
    /*
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     *
     * Time Complexity: O(n) where n = prices.length
	 * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int maxPrice = -1;
        // Start from the end of the array
        for(int i = prices.length - 1; i >= 0; i--) {
            int currPrice = prices[i];
            int currProfit = maxPrice - currPrice;
            // Keep track of the max price (when you sell)
            if(currPrice > maxPrice) {
                maxPrice = currPrice;
            // Check if you bought this day, would it be your max profit?
            } else if(currProfit > maxProfit) {
                maxProfit = currProfit;
            }
        }
        return maxProfit;
    }
}