import java.util.*;

public class Pangrams {
	
	/*
	 * Time Complexity: O(26n), where n is the size of string s
	 * 						-> drop the constant
	 * 						-> O(n)
	 * Space Complexity: O(1)
	 */
	public static String solution1(String s) {
		// Instantiate our alphabet as an array
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // Change all letters of String s to lowercase
		s = s.toLowerCase();
		// Iterate through all letters of the alphabet
        for(int l = 0; l < letters.length; l++) {
        	// The current letter of the alphabet
        	char letter = letters[l];
        	// If the letter is found in the string
        	boolean isFound = false;
        	// Iterate through String s
        	for(int i = 0; i < s.length(); i++) {
        		// The current character of String s
        		char charAtI = s.charAt(i);
        		// If the character is found
        		if(charAtI == letter) {
        			isFound = true;
        			break;
        		}
        	}
        	// If a letter was not found in String s
        	if(!isFound)
        		return "not pangram";
        }
        // All letters were found in String s
        return "pangram";
	}

	/*
	 * Better O(n) time than solution1 - for large strings.
	 * 
	 * Time Complexity: O(n), where n is the size of string s
	 * Space Complexity: O(1)
	 */
	public static String solution2(String s) {
		// Instantiate our alphabet as an array
		char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		// Instantiate our alphabet as a Set
		Set<Character> alphabet = new HashSet<>();
        for(char letter : letters)
            alphabet.add(letter);
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
