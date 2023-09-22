import java.util.*;
// https://www.hackerrank.com/challenges/pangrams/problem
public class Pangrams {
	/*
	 * Time Complexity: O(n), where n is the size of string s
	 * Space Complexity: O(1)
	 */
	public static String solution(String s) {
		// Instantiate our alphabet as an array
		List<Character> letters = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
		// Instantiate our alphabet as a Set
		Set<Character> alphabet = new HashSet<>(letters);
        // Change all letters of String s to lowercase
        s = s.toLowerCase();
        // Iterate through every letter of String s
        for(int i = 0; i < s.length(); i++){
        	// The current character of the string
            Character c = s.charAt(i);
            // Remove the character from the alphabet
            alphabet.remove(c);
            // If no letters are remaining in the alphabet, return "pangram"
            if(alphabet.isEmpty())
                return "pangram";
        }
        // Some letters of the alphabet were not found in String s
        return "not pangram";
    }
	
}
