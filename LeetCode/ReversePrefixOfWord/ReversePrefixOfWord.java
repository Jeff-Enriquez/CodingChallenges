/*
 * Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.
 * For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
 * Return the resulting string.
 * 
 * Constraints:
 *      1 <= word.length <= 250
 *      word consists of lowercase English letters.
 *      ch is a lowercase English letter.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        char[] chArray = word.toCharArray();
        int leftIdx = 0;
        int rightIdx = -1;
        for(int i = 0; i < chArray.length; i++){
            if(chArray[i] == ch) {
                rightIdx = i;
                break;
            }
        }
        if(rightIdx == -1)
            return word;
        do {
            char temp = chArray[leftIdx];
            chArray[leftIdx] = chArray[rightIdx];
            chArray[rightIdx] = temp;
        } while(++leftIdx < --rightIdx);
        return new String(chArray);
    }
}
