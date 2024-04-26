class Solution {
    /*
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
     * Find and return the maximum profit you can achieve.
     *
     * Time Complexity: O(n) where n = prices.length
	 * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            // if the buying today and selling tomorrow is greater than 0, add it to the profits
            int diff = prices[i+1] - prices[i];
            if(diff > 0)
                totalProfit += diff;
        }
        return totalProfit;
    }
}