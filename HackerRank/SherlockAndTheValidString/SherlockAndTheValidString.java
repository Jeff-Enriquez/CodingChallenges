import java.util.*;
import java.util.stream.*;
// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
public class SherlockAndTheValidString {

    /*
     * Time Complexity: O(n) where n = s.length()
     * Space Complexity: O(n) where n = s.length() (max is 26 given the constraints of the problem)
     */
	public static String isValid(String s) {
		// Convert the string to a map where
			// key = each unique character
			// value = number of times the character appears in the string
		Map<Character, Long> countCharacters = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		// Extract the values (counts) from the map to a list
		List<Long> counts = countCharacters.values().stream()
				.collect(Collectors.toList());
		// Convert the list to a map where
			// key = count
			// value = how many times that count occurs
		Map<Long, Long> countOfCounts = countCharacters.values().stream()
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		List<Long> keys = new ArrayList<>(countOfCounts.keySet());
		List<Long> values = new ArrayList<>(countOfCounts.values());
		
		// No characters need to be deleted
		if(keys.size() == 1)
			return "YES";
		// At least two characters need to be deleted
		if(keys.size() >= 3)
			return "NO";
		// At least one of the two values must be 1. Otherwise, at least two characters need to be deleted.
		if(values.get(0) != 1 && values.get(1) != 1)
			return "NO";
		// If one of the keys is 1 and the value is 1, then only one character needs to be deleted.
		if((keys.get(0) == 1 && values.get(0) == 1) || (keys.get(1) == 1 && values.get(1) == 1))
			return "YES";
		// If the difference between the keys is not 1, then at least two characters need to be deleted.
		if(Math.abs(keys.get(0) - keys.get(1)) != 1)
			return "NO";
	
		return "YES";
    }
	
	public static void main(String[] args) {
		System.out.println(isValid("aabbcd")); // Expected Result: NO 
		System.out.println(isValid("abcdefghhgfedecba")); // Expected Result: YES
	}
}
