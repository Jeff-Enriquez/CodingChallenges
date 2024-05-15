/*
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 * 
 * Constraints:
 *      1 <= s.length, t.length <= 5 * 10^4
 *      s and t consist of lowercase English letters.
 * 
 * Time Constraint: O(s + t)
 * Space Complexity: O(1)
 *      s = s.length()
 *      t = t.length()
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // Anagram not possible
        if(s.length() != t.length())
            return false;
        int n = s.length();
        // Store count of characters
        int[] chars = new int[26];
        // Count characters of s
        for(int i = 0; i < n; i++)
            chars[s.charAt(i) - 'a']++;
        // Substract characters of t
        for(int i = 0; i < n; i++)
            chars[t.charAt(i) - 'a']--;
        // If anagram, all counts will equal 0
        for(int i = 0; i < 26; i++)
            if(chars[i] != 0)
                return false;
        return true;
    }
}
