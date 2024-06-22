import java.util.*;
/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once
 * 
 * Constraints:
 *      1 <= strs.length <= 10^4
 *      0 <= strs[i].length <= 100
 *      strs[i] consists of lowercase English letters.
 * 
 * Time Complexity: O(c)
 * Space Complexity: O(s)
 *      c = all characters within strs array. The more characters, the longer the time.
 *      s = strs.length. The longer the length the more space is used.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> groupedAnagrams = new HashMap<>();
        // Traverse through list of strings
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            // Instantiate new list to store characters of the string
            List<Integer> chars = new ArrayList<>(26);
            for(int k = 0; k < 26; k++) 
                chars.add(0);
            // Traverse through characters of string
            for(Character c : s.toCharArray()) {
                int idx = c - 'a';
                chars.set(idx, chars.get(idx) + 1);
            }
            // Get existing list of strings for list of characters
            List<String> list = groupedAnagrams.getOrDefault(chars, new ArrayList<>());
            list.add(s);
            groupedAnagrams.put(chars, list);            
        }
        return new ArrayList<>(groupedAnagrams.values());
    }

    /*
     * More robust solution. Accounts for any character.
     * Time Complexity: O(n * m)
     * Space Complexity: O(n * m)
     *      n = the number of strings
     *      m = the average length of the strings
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<Map<Character,Integer>, List<String>> groupedAnagrams = new HashMap<>();
        for(String str : strs) {
            Map<Character, Integer> characterCount = new HashMap<>();
            char[] chArray = str.toCharArray();
            for(Character c : chArray) {
                characterCount.put(c, characterCount.getOrDefault(c, 0) + 1);
            }
            List<String> list = groupedAnagrams.getOrDefault(characterCount, new ArrayList<String>());
            list.add(str);
            groupedAnagrams.put(characterCount, list);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
}
