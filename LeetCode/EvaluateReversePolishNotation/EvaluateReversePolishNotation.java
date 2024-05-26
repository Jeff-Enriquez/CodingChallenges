import java.util.*;
/*
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 *      The valid operators are '+', '-', '*', and '/'.
 *      Each operand may be an integer or another expression.
 *      The division between two integers always truncates toward zero.
 *      There will not be any division by zero.
 *      The input represents a valid arithmetic expression in a reverse polish notation.
 *      The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * 
 * Constraints:
 *      1 <= tokens.length <= 10^4
 *      tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // Save tokens to a stack
        Deque<Integer> deque = new ArrayDeque<>();
        // This is a map of all arithmetic expressions
        int minC = '*';
        boolean[] isOps = new boolean[58 - minC];
        isOps['*' - minC] = true;
        isOps['-' - minC] = true;
        isOps['+' - minC] = true;
        isOps['/' - minC] = true;

        // Traverse through every token
        for(String s : tokens)
            // If the token is of length 1, it is possible it is an arithmetic operation
            if(s.length() == 1 && isOps[s.charAt(0) - minC])
                // Add the result to the stack
                deque.addFirst(
                    // Retrieve the last two numbers and perform the arithmetic operation
                    performOp(s.charAt(0), deque.removeFirst(), deque.removeFirst())
                    );
            else
                // The token is a number, add it to the stack
                deque.addFirst(Integer.valueOf(s));

        // Return the result of RPN evaluation
        return deque.removeFirst();
    }
    
    /*
     * Helper method. Performs the given arithmetic operation on the two numbers. 
     */
    private int performOp(Character op, int num1, int num2) {
        if('+' == op)
            return num2 + num1;
        else if('-' == op)
            return num2 - num1;
        else if('*' == op)
            return num2 * num1;
        else
            return num2 / num1;
    }
}
