/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * 
 * Constraints:
 *      1 <= ransomNote.length, magazine.length <= 10^5
 *      ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Stores all letters of the alphabet
        int[] ransomNoteLetters = new int[26];
        int[] magazineLetters = new int[26];
        // Count all ransomNote letters
        for(int i = 0; i < ransomNote.length(); i++)
            ransomNoteLetters[ransomNote.codePointAt(i) - 'a']++;
        // Count all magazine letters
        for(int i = 0; i < magazine.length(); i++)
            magazineLetters[magazine.codePointAt(i) - 'a']++;
        // Confirm if ransomNote can be constructud using letters from magazine
        // Loop through all letters of alphabet
        for(int i = 0; i < 26; i++)
            // if magazine doesn't have enough letters
            if(magazineLetters[i] < ransomNoteLetters[i])
                return false;
        return true;
    }
}
