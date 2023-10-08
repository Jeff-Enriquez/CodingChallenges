import java.util.*;
// https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem
public class GridChallenge {

	/*
	 * Time Complexity: O(g * s * log(s)), where g = grid.size() and s = the size of the string in the grid
	 * Space Complexity: O(s), where s = the size of the string in the grid
	 */
	public static String gridChallenge(List<String> grid) {
		// Sort each string
        for(int i = 0; i < grid.size(); i++){ // O(g)
            char[] characters = grid.get(i).toCharArray();
            Arrays.sort(characters); // O(s * log(s)) 
            StringBuilder sortedStr = new StringBuilder();
            sortedStr.append(characters); // O(s)
            grid.set(i, sortedStr.toString());
        }
        // Check if columns are in alphabetical order
        for(int i = 0; i < grid.size() - 1; i++) { // O(g)
        	String str1 = grid.get(i);
        	String str2 = grid.get(i + 1);
        	for(int j = 0; j < str1.length(); j++) { // O(s)
        		char c1 = str1.charAt(j);
        		char c2 = str2.charAt(j);
        		if(c1 > c2)
        			return "NO";
        	}
        }
        return "YES";
    }
	
}
