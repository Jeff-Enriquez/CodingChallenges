/*
 * Given a string s, reverse the string according to the following rules:
 *      All the characters that are not English letters remain in the same position.
 *      All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 * 
 * Constraints:
 *      1 <= s.length <= 100
 *      s consists of characters with ASCII values in the range [33, 122].
 *      s does not contain '\"' or '\\'.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        int rightIdx = len;
        int leftIdx = -1;
        char[] chArray = s.toCharArray();
        char leftC, rightC;
        while(++leftIdx < --rightIdx) {
            leftC = chArray[leftIdx];
            while(leftIdx < rightIdx && !Character.isLetter(leftC)) {
                leftC = chArray[++leftIdx];
            }
            rightC = chArray[rightIdx];
            while(leftIdx < rightIdx && !Character.isLetter(rightC)) {
                rightC = chArray[--rightIdx];
            }
            chArray[leftIdx] = rightC;
            chArray[rightIdx] = leftC;
        }
        return new String(chArray);
    }
}
