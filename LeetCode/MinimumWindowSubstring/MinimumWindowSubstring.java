import java.util.*;
public class MinimumWindowSubstring {
    /*
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "". The testcases will be generated such that the answer is unique.
     * 
     * Constraints:
     *      m == s.length
     *      n == t.length
     *      1 <= m, n <= 10^5
     *      s and t consist of uppercase and lowercase English letters.
     * 
     * Time Complexity: O(s)
     * Space Complexity: O(s)
     *      In Big O Notation we drop the non-dominant terms. In this solution, 
     *      O(t) will always be less than or equal to O(s). Thus, 
     *      O(t) is a non-dominant term and can be dropped.
     */
    public String minWindow(String s, String t) {
        // No window is possible
        if(s.length() < t.length())
            return "";
        // Retrieve the first occurrance if it exists
        if(t.length() == 1) {
            return s.contains(t) ? t : "";
        }
        // Store character count to integer array for faster lookup time
        int[] tCharacterCount = new int[123];
        for(char c: t.toCharArray()){
            tCharacterCount[c]++;
        }
        // Track indexes of the window
        int leftIdx = 0;
        int rightIdx = t.length();
        // Track how many t characters the window contains
        int charactersFound = 0;
        // Store indexes of the found characters in the existing window. This is for optimization.
        Queue<Integer> indexes = new ArrayDeque<>();
        // Get the initial window
        int[] windowCharacterCount = new int[123];
        for(int i = 0; i < rightIdx; i++) {
            int codePoint = s.codePointAt(i);
            if(tCharacterCount[codePoint] > 0) {
                if(windowCharacterCount[codePoint]++ < tCharacterCount[codePoint])
                    charactersFound++;
                indexes.add(i);
            }
        }
        // The substring was found in the initial window
        if(charactersFound == t.length()) {
            return s.substring(0, t.length());
        }
        String smallestWindow = "";
        while(rightIdx < s.length()) {
            // Increase the window until all characters of the t are found
            while(charactersFound < t.length() && rightIdx < s.length()) {
                int codePoint = s.codePointAt(rightIdx);
                if(tCharacterCount[codePoint] > 0) {
                    if(windowCharacterCount[codePoint]++ < tCharacterCount[codePoint])
                        charactersFound++;
                    indexes.add(rightIdx);
                }
                rightIdx++;
            }
            // Decrease the window until 1 character of t is missing
            while(charactersFound == t.length() && indexes.size() > 1) {
                leftIdx = indexes.poll();
                int codePoint = s.codePointAt(leftIdx);
                if(windowCharacterCount[codePoint]-- == tCharacterCount[codePoint]) {
                    charactersFound--;
                    if(smallestWindow == "" || smallestWindow.length() > rightIdx - leftIdx) {
                        smallestWindow = s.substring(leftIdx, rightIdx);
                    }
                    leftIdx = indexes.peek();
                }
            }
        }
        return smallestWindow;
    }
}
