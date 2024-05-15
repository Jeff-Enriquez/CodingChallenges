import java.util.*;
/*
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
 * 
 * Constraints:
 *      1 <= s.length <= 5 * 10^4
 *      t.length == s.length
 *      s and t consist of any valid ascii character
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *      n = t.length() + s.length()
 *      k = unique characters of string t
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMappedToT = new HashMap<>();
        Set<Character> completedMappings = new HashSet<>();
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // If current s char is not already mapped, map it to current t char
            Character previouslyMapped = sMappedToT.putIfAbsent(sChar, tChar);
            // If character is already mapped with a different character
            if(previouslyMapped != null && previouslyMapped != tChar)
                return false;
            // If this is the first mapping of s char to t char AND t char has already been mapped to before
            if(previouslyMapped == null && completedMappings.contains(tChar))
                    return false;
            // Add t char to completed mappings
            completedMappings.add(tChar);
        }
        return true;
    }
}
