class Solution {
    /*
     * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
     * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
     * Constraints:
     *      n == citations.length
     *      1 <= n <= 5000
     *      0 <= citations[i] <= 1000
     * 
     * Time Complexity: O(n) where n = citations.length
	 * Space Complexity: O(1)
     */
    public int hIndex(int[] citations) {
        // Utilize Counting Sort to sort citations
        int[] countSortCitations = new int[5000];
        for(int i = 0; i < citations.length; i++){
            countSortCitations[citations[i]]++;
        }
        // Starting from the back of the array, count the total number of citations.
        // Once index i is greater or equal to the total citation count, you have your h-index.
        int citationCount = 0;
        for(int i = countSortCitations.length - 1; i >= 0; i--){
            citationCount += countSortCitations[i];
            if(citationCount >= i)
                return i;
        }
        return 0;
    }
}