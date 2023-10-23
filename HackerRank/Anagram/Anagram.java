import java.util.*;
// https://www.hackerrank.com/challenges/anagram/problem
public class Anagram {
	/*
	 * Time Complexity: O(n) where n = s.length()
	 * Space Complexity: O(q) where q is the unique count of characters in s. Given the constraint of the problem, the max is 26 - all lower case letters of the alphabet.
	 */
	public static int anagram(String s) {
		// If the length of the string is odd then a solution is not possible
		if(s.length() % 2 != 0)
			return -1;
		// Store the count of the characters in the string
		Map<Character, Integer> charCount = new HashMap<>();
		// Increment the count of characters in the first half of the string
		for(int i = 0; i < s.length()/2; i++) {
			char c = s.charAt(i);
			int count = charCount.getOrDefault(c, 0);
			charCount.put(c, ++count);
		}
		// Decrement the count of characters in the second half of the string
		for(int i = s.length()/2; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = charCount.getOrDefault(c, 0);
			charCount.put(c, --count);
		}
		// If a character count in charCount is 0 then it appears the same number of times in both halves of the string
		// If there are any character counts that are not 0 then the number of positive counts will equal the number of negative counts
		// The sum of the positive counts will give us our answer: the minimum number of characters to change to make the two substrings anagrams of each other
		return charCount.values()
				.stream()
				.filter(num -> num > 0) // Only get the positive numbers
				.reduce(0, Integer::sum); // Sum all of those numbers
	}
}
