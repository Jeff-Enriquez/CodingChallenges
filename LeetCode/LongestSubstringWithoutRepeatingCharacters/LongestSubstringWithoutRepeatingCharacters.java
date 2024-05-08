import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * Given a string s, find the length of the longest substring without repeating characters.
     * Constraints:
     *      0 <= s.length <= 5 * 10^4
     *      s consists of English letters, digits, symbols and spaces.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        // Track characters of substring
        Set<Character> characters = new HashSet<>();
        // Track longest substring
        int longestSubstring = 0;
        // Create two pointers
        int leftIdx = 0;
        int rightIdx = 0;
        // Continue while the right idx is less than the size of the string
        while(rightIdx < s.length()) {
            Character rightC = s.charAt(rightIdx++);
            // Add the character to the set and check if the character already exists.
            while(!characters.add(rightC)) {
                // Check if this is the longest substring
                if(rightIdx - leftIdx - 1 > longestSubstring)
                    longestSubstring = rightIdx - leftIdx - 1;
                // Remove the left most character from the set
                characters.remove(s.charAt(leftIdx++));
            }
        }
        // Check if final size is the longest substring
        if(characters.size() > longestSubstring)
            longestSubstring = characters.size();
        return longestSubstring;
    }
}