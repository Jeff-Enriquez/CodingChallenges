// https://www.hackerrank.com/challenges/caesar-cipher-1/problem
public class CaesarCipher {
	
	/*
	 * Time Complexity: O(n) where n = s.length
	 * Space Complexity: O(n) where n = s.length
	 */
	public static String caesarCipher(String s, int k) {
		// Reduce the size of k if >= 26. Rotating 26 is the same as rotating 0.
		if(k >= 26)
			k %= 26;
		char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		// Since we are making a lot of modifications to the string, it is better to use StringBuilder (better performance).
		StringBuilder str = new StringBuilder();
		// Loop through every character of the given string
		for(Character c : s.toCharArray()) {
			// Get the integer value of the current character
			int numValue = c;
			// The index of the new cipher character
			int index = k;
			// all characters from a - z
			if(numValue >= 97 && numValue <= 122)
				index += numValue - 97;
			// all characters from A - Z
			else if(numValue >= 65 && numValue <= 90)
				index += numValue - 65;
			// non alphabetic characters
			else {
				// Append the character to the string
				str.append(c);
				// Continue to the next character
				continue;
			}
			// Keep index within bounds of the array
			if(index >= 26)
				index %= 26;
			// Retrieve the cipher character
			Character cipher = alphabet[index];
			// If the character in the string was uppercase, set cipher character to uppercase
			if(numValue <= 90)
				cipher = Character.toUpperCase(cipher);
			// Append the cipher character to the new string
			str.append(cipher);
		}
		// Return the new cipher string
		return str.toString();
    }
    
}
