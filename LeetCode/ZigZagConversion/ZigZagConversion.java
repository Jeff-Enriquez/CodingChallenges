/*
 * https://leetcode.com/problems/zigzag-conversion/description/
 * 
 * Time Complexity: O(s)
 * Space Complexity: O(s)
 *      s = s.length()
 */
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length())
            return s;
        char[] chars = new char[s.length()];
        int cIdx = 0;
        // First Row
        int step = ((numRows - 1) * 2);
        for(int i = 0; i < s.length();) {
            chars[cIdx++] = s.charAt(i);
            i += step;
        }
        // Middle Rows
        for(int row = 1; row < numRows - 1; row++) {
            int i = row;
            int firstStep = step - (row * 2);
            int secondStep = step - firstStep;
            while(i < s.length()) {
                chars[cIdx++] = s.charAt(i);
                i += firstStep;
                if(i < s.length()) {
                    chars[cIdx++] = s.charAt(i);
                    i += secondStep;
                }
            }
        }
        // Last Row
        for(int i = numRows - 1; i < s.length();) {
            chars[cIdx++] = s.charAt(i);
            i += step;
        }
        return new String(chars);
    }
}