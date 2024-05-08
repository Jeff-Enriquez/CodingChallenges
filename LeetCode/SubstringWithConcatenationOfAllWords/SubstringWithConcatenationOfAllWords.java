package LeetCode.SubstringWithConcatenationOfAllWords;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    /*
     * You are given a string s and an array of strings words. All the strings of words are of the same length.
     * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
     *      For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
     * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
     * 
     * Constraints:
     *      1 <= s.length <= 10^4
     *      1 <= words.length <= 5000
     *      1 <= words[i].length <= 30
     *      s and words[i] consist of lowercase English letters.
     * 
     * Time Complexity: O(w + l^2 + s)
     * Space Complexity: O(w + (s / l))
     *      w = words.length
     *      l = words[i].length()
     *      s = s.length()
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        if(s.length() < wordLength * words.length)
            return result;
        HashMap<String, Integer> wordSet = new HashMap<>();
        // O(w)
        // Save all words to a hashmap, this improves lookup speed
        for(String word : words)
            wordSet.put(word, wordSet.getOrDefault(word, 0) + 1);

        // O(l)
        // The starting point of the traversal through the string 's'.
        // The starting point will be each index from 0 to the length of words[i].length
        for(int i = 0; i < wordLength && i + wordLength * words.length <= s.length(); i++) {
            HashMap<String, Integer> currentWordSet = new HashMap<>();
            // Currently, the "window" does not contain any matches for words
            int wordsFound = 0;
            int j = 0;
            int k = 0;
            // O(l)
            // Capture the initial "window"
            for(; k < words.length; k++) {
                String subStr = s.substring(i + j, i + j + wordLength);
                int count = wordSet.getOrDefault(subStr, 0);
                if(count != 0) {
                    int currentCount = currentWordSet.getOrDefault(subStr, 0) + 1;
                    currentWordSet.put(subStr, currentCount);
                    // Match was found
                    if(currentCount <= count) {
                        wordsFound++;
                    } 
                }
                j += wordLength;
            }
            if(wordsFound == words.length){
                result.add(i);
            }
            // O(s / l)
            // Traverse through the rest of the string
            for(; i + j + wordLength <= s.length(); j += wordLength) {
                // Remove previous substring
                String subStr = s.substring(i + j - (wordLength * words.length), i + j + wordLength - (wordLength * words.length));
                int count = wordSet.getOrDefault(subStr, 0);
                if(count != 0) {
                    int currentCount = currentWordSet.get(subStr) - 1;
                    currentWordSet.put(subStr, currentCount);
                    // A matched word was removed
                    if(currentCount < count) {
                        wordsFound--;
                    }
                }
                // Add next substring
                subStr = s.substring(i + j, i + j + wordLength);
                count = wordSet.getOrDefault(subStr, 0);
                if(count != 0) {
                    int currentCount = currentWordSet.getOrDefault(subStr, 0) + 1;
                    currentWordSet.put(subStr, currentCount);
                    // Match found
                    if(currentCount <= count) {
                        wordsFound++;
                    }
                }
                // Check if match
                if(wordsFound == words.length){
                    result.add(i + j - (wordLength * words.length) + wordLength);
                }
            }
        }
        return result;
    }
}
