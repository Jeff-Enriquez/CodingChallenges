import java.util.*;
/*
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * 
 * Constraints:
 *      1 <= s.length <= 3 * 10^5
 *      s consists of digits, '+', '-', '(', ')', and ' '.
 *      s represents a valid expression.
 *      '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 *      '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 *      There will be no two consecutive operators in the input.
 *      Every number and running calculation will fit in a signed 32-bit integer.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BasicCalculator {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int value = 0;
        int sign = 1;
        // Traverse through all characters
        for(Character c : s.toCharArray()) {
            // If it is a digit, update the current value
            if(Character.isDigit(c))
                // We multiple 10 because we are looping through one character at a time
                value = value * 10 + (c - '0');
            else if(c == '+') {
                // add the current value to the result (multiply by the previous sign)
                result += value * sign;
                // reset the value
                value = 0;
                // update the sign
                sign = 1;
            }
            else if(c == '-') {
                // add the current value to the result (multiply by the previous sign)
                result += value * sign;
                // reset the value
                value = 0;
                // update the sign
                sign = -1;
            }
            else if(c == '(') {
                // Add the current result and sign to the stack
                stack.addFirst(result);
                stack.addFirst(sign);
                // Reset the current result and sign
                result = 0;
                sign = 1;
            }
            else if(c == ')') {
                // Add the current value to the result
                result += value * sign;
                // reset the value
                value = 0;
                // Multiply by the previous sign
                result *= stack.removeFirst();
                // Add the previous result
                result += stack.removeFirst();
            }
        }
        // Add the last value to the result
        return result + value * sign;
    }
}
