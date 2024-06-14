/*
 * You are given two strings s and t of the same length and an integer maxCost.
 * You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
 * Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.
 * 
 * Constraints:
 *      1 <= s.length <= 10^5
 *      t.length == s.length
 *      0 <= maxCost <= 10^6
 *      s and t consist of only lowercase English letters.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        int currCost = 0;
        int leftI = 0;
        int rightI = 0;
        int sLen = s.length();
        for(; rightI < sLen; rightI++) {
            currCost += Math.abs(chS[rightI] - chT[rightI]);
            if(currCost > maxCost) {
                currCost -= Math.abs(chS[leftI] - chT[leftI]);
                leftI++;
            }
        }
        return rightI - leftI;
    }
}
