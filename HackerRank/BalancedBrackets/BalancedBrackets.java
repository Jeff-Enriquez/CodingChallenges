import java.util.*;
// https://www.hackerrank.com/challenges/balanced-brackets/problem
public class BalancedBrackets {
	
	/*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 		n = size of string 's'
	 */
	public static String isBalanced(String s) {
		// Tracks opening brackets
		Stack<Character> stack = new Stack<>();
		// Map the closing brackets to the opening
		Map<Character, Character> brackets = Map.of('}', '{', ']', '[', ')', '(');
		// Set of opening brackets
		Set<Character> openingBrackets = Set.of('{', '[', '(');
		
		// Iterate through every character of the string
		for(Character c : s.toCharArray())
			// If c is an opening bracket, add to the stack
			if(openingBrackets.contains(c))
				stack.push(c);
			// If the closing bracket matches the last opening bracket on the stack
			else if(!stack.empty() && stack.peek().equals(brackets.get(c)))
				stack.pop();
			// Unbalanced brackets
			else
				return "NO";

		// Unbalanced brackets
		if(!stack.empty())
			return "NO";
		
		// Balanced brackets
		return "YES";
	}
	
}
