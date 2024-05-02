/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Constraints:
 *      1 <= strs.length <= 200
 *      0 <= strs[i].length <= 200
 *      strs[i] consists of only lowercase English letters.
 * 
 * Time Complexity: O(n * s) 
 * Space Complexity: O(s)
 *      n = strs.length
 *      s = strs[i].length
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        // First string when sorted lexicographically
        String firstStr = strs[0];
        // Last string when sorted lexicographically
        String lastStr = strs[0];
        // Find the first and last string
        for(int i = 1; i < strs.length; i++) {
            if(firstStr.compareTo(strs[i]) < 0)
                firstStr = strs[i];
            else if(lastStr.compareTo(strs[i]) > 0)
                lastStr = strs[i];
        }
        // Find the shared prefix of the two strings - if one exists
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < firstStr.length() && i < lastStr.length(); i++)
            if(firstStr.charAt(i) == lastStr.charAt(i))
                prefix.append(firstStr.charAt(i));
            else
                break;
        return prefix.toString();
    }
}