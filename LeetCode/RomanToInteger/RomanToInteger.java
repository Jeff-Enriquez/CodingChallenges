/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *      Symbol       Value
 *      I             1
 *      V             5
 *      X             10
 *      L             50
 *      C             100
 *      D             500
 *      M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90. 
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * 
 * Constraints:
 *      1 <= s.length <= 15
 *      s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 *      It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
class Solution {
    // Store the Roman Integer Value of each Character in an array. Use the charValue as the index of the array. This allows for O(1) lookup time.
    // We need a size of 22 because the difference between the charValue of the smallest letter 'C' and the largest letter 'X' is 21.
    private final int[] romanLetterValues = new int[22];
    {
        // index = charValue - 67. We subtract 67 because C is the smallest charValue we are storing.
        romanLetterValues[0] = 100;     // C (0 = 67 - 67)
        romanLetterValues[1] = 500;     // D (1 = 68 - 67)
        romanLetterValues[6] = 1;       // I (6 = 73 - 67)
        romanLetterValues[9] = 50;      // L (9 = 76 - 67)
        romanLetterValues[10] = 1000;   // M (10 = 77 - 67)
        romanLetterValues[19] = 5;      // V (19 = 86 - 67)
        romanLetterValues[21] = 10;     // X (21 = 88 - 67)
    }
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        // Traverse string from right to left - O(n) time
        for(int i = s.length() - 1; i >= 0; i--) {
            // Get the value of the roman letter - O(1) time.
            int value = romanLetterValues[((int) s.charAt(i)) - 67];
            // If the previous value was greater than the current, subtract the current value from the total
            if(value < prevValue)
                total -= value;
            // Otherwise, add the current value to the total
            else
                total += value;
            // Update the prev value.
            prevValue = value;
        }
        // return total
        return total;
    }
}