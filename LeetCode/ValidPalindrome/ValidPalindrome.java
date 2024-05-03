/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Constraints:
 *      1 <= s.length <= 2 * 105
 *      s consists only of printable ASCII characters.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isPalindrome(String s) {
        int rightIdx = s.length() - 1;
        for(int leftIdx = 0; leftIdx < rightIdx; leftIdx++) {
            int leftChar = convertToLowerCase((int)s.charAt(leftIdx));
            if(isValidCharacter(leftChar)) {
                int rightChar = 0;
                do {
                    rightChar = convertToLowerCase((int)s.charAt(rightIdx--));
                } while(!isValidCharacter(rightChar) && rightIdx >= leftIdx);
                if(leftChar != rightChar)
                    return false;
            }
        }
        return true;
    }

    // The integer value of A - Z is 65 - 90. 
    // If you add 32, it becomes a lowercase character because the integer value of a - z is 97 - 122.
    private int convertToLowerCase(int c) {
        return (c >= 65 && c <= 90) ? c + 32 : c;
    }

    // Valid Characters are: 
        // 0 - 9 | integer value of 48 - 57
        // a - z | integer value of 97 - 122
    private boolean isValidCharacter(int c) {
        return ((c >= 48 && c <= 57) || (c >= 97 && c <= 122));
    }
}