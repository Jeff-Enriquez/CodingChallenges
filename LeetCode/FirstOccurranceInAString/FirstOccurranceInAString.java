/*
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Constraints:
 *      1 <= haystack.length, needle.length <= 10^4
 *      haystack and needle consist of only lowercase English characters.
 * 
 * Time Complexity: O(h * n)
 * Space Complexity: O(1)
 *      h = haystack.length()
 *      n = needle.length()
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
        // Loop through the entire haystack string
        for(int i = 0; i < haystack.length(); i++) {
            int hIdx = i;
            int nIdx = 0;
            // Check if needle can be found at this index of haystack
            while(hIdx < haystack.length() && nIdx < needle.length()) {
                if(haystack.charAt(hIdx) == needle.charAt(nIdx)) {
                    hIdx++;
                    nIdx++;
                } else {
                    break;
                }
            }
            // Needle has been found in haystack
            if(nIdx == needle.length()){
                return hIdx - needle.length();
            }
        }
        return -1;
    }
}