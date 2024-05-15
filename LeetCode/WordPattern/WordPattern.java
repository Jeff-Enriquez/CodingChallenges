import java.util.*;
/*
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * 
 * Constraints:
 *      1 <= pattern.length <= 300
 *      pattern contains only lower-case English letters.
 *      1 <= s.length <= 3000
 *      s contains only lowercase English letters and spaces ' '.
 *      s does not contain any leading or trailing spaces.
 *      All the words in s are separated by a single space.
 * 
 * Time Complexity: O(p * s)
 * Space Complexity: O(s)
 *      p = p.length()
 *      s = words of string s
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] pChars = new String[26];
        Set<String> matched = new HashSet<>();
        int prevIdx = 0;
        // O(p) - time complexity
        for(int i = 0; i < pattern.length(); i++) {
            int pChar = pattern.codePointAt(i) - 'a';
            int nextIdx = nextIndex(s, prevIdx);
            // There are no more words of string s to match
            if(nextIdx == prevIdx)
                return false;
            // Get next substring
            String str = s.substring(prevIdx, nextIdx);
            prevIdx = nextIdx + 1;
            // Confirm that current string matches previous if it's been mapped before
            // O(s/2) - time complexity
            if(pChars[pChar] != null && !pChars[pChar].equals(str))
                return false;
            // String has already been matched to another letter
            // O(s/2) - time complexity
            if(pChars[pChar] == null && matched.contains(str))
                return false;
            // Update mappings
            matched.add(str);
            pChars[pChar] = str;
        }
        // If additional words exist
        if(prevIdx < s.length())
            return false;
        return true;
    }
    private int nextIndex(String s, int prevIdx) {
        int i = prevIdx;
        for(; i < s.length(); i++) {
            if(s.charAt(i) == ' ')
                break;
        }
        return i;
    }
}
