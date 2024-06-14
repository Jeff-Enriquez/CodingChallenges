/*
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 * 
 * Constraints:
 *      1 <= s.length <= 10^5
 *      s consists of lowercase English letters.
 *      1 <= k <= s.length
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int maxVowelCount = 0;
        int vowelCount = 0;
        char[] chArray = s.toCharArray();
        char c;
        for(int i = 0; i < k; i++) {
            c = chArray[i];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowelCount++;
        }
        if(vowelCount == k)
            return vowelCount;
        maxVowelCount = vowelCount;
        for(int i = k; i < s.length(); i++) {
            c = chArray[i];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowelCount++;
            c = chArray[i - k];
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowelCount--;
            if(vowelCount == k)
                return vowelCount;
            maxVowelCount = Math.max(vowelCount, maxVowelCount);
        }
        return maxVowelCount;
    }    
}
