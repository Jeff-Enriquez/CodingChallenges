import java.util.*;
/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *      1. Open brackets must be closed by the same type of brackets.
 *      2. Open brackets must be closed in the correct order.
 *      3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Constraints:
 *      1 <= s.length <= 10^4
 *      s consists of parentheses only '()[]{}'.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        // Of all the parentheses '}' has the largest value of 125
        int[] mapping = new int[126];
        // Map the closed parentheses to the open parentheses
        mapping[')'] = '(';
        mapping[']'] = '[';
        mapping['}'] = '{';
        // Java's preferred implementation of Stack (Stack is legacy code)
        Deque<Character> stack = new ArrayDeque<>();
        // Loop through all the characters of the string
        for(Character c : s.toCharArray()) {
            // If the value is zero, it is an open parenthesis
            if(mapping[c] == 0)
                stack.push(c);
            // If the size is zero, there is no matching parenthesis
            else if(stack.size() == 0)
                return false;
            else {
                Character prevC = stack.pop();
                // Check if current parenthesis matches with the previous
                if(prevC != mapping[c])
                    return false;
            }
        }
        // No matching parentheses
        if(stack.size() > 0)
            return false;
        return true;
    }
}
