import java.util.*;

// https://www.hackerrank.com/challenges/sparse-arrays/problem
public class SparseArrays {

    /*
     * Time Complexity: O(n^x) where n = queries.size() and x = strings.size()
     * Space Complexity: O(n) where n = queries.size()
     */
	public static List<Integer> solution1(List<String> strings, List<String> queries) {
		// Variable to store the results
		List<Integer> results = new ArrayList<>();
		// Initialize the results
		for(int i = 0; i < queries.size(); i++)
			results.add(0);
		
		// Time Complexity: O(n)
		// Loop through all of the queries
		for(int q = 0; q < queries.size(); q++) {
			String query = queries.get(q);
			// Time Complexity: O(x)
			// For each query, loop through all of the strings
			for(int s = 0; s < strings.size(); s++) {
				String string = strings.get(s);
				// If the query equals the string, increment the count
				if(query.equals(string)){
					Integer currentCount = results.get(q);
					currentCount++;
					results.set(q, currentCount);
				}
			}
		}
		
		return results;
	}
	
	/*
	 * Time Complexity: O(n) where n = queries.size() + strings.size()
	 * Space Complexity: O(n) where n = queries.size()
	 */
	public static List<Integer> solution2(List<String> strings, List<String> queries) {
		// Variable to store the results
		List<Integer> results = new ArrayList<>(queries.size());
		
		// Key = the string in the strings array
		// Value = how many times the string appears in the strings array
		HashMap<String, Integer> countStrings = new HashMap<>();
		
		// Time Complexity: O(n)
		// Set the count of every string in the strings array
		for(String string : strings) {
			Integer count = countStrings.getOrDefault(string, 0);
			countStrings.put(string, ++count);
		}
		
		// Time Complexity: O(n)
		// Get the count of every query in the strings array
		for(String query : queries) {
			Integer count = countStrings.getOrDefault(query, 0);
			results.add(count);
		}
			
		return results;
	}
	
}
