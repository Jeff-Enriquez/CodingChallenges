/*
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * Constraints:
 *      1 <= s.length <= 10^4
 *      s consists of only English letters and spaces ' '.
 *      There will be at least one word in s.
 * 
 * Time Complexity: O(n) 
 * Space Complexity: O(1)
 *      n = length of empty spaces at end of string + length last word
 */

class Solution {
    public int lengthOfLastWord(String s) {
        int charCount = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ')
                charCount++;
            else if(charCount > 0)
                break;
        }
        return charCount;
    }
}