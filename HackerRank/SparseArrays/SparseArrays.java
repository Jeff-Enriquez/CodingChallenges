import java.util.*;

// https://www.hackerrank.com/challenges/sparse-arrays/problem
public class SparseArrays {
	
	/*
	 * Time Complexity: O(s + q) where s = strings.size() and q = queries.size()
	 * Space Complexity: O(q) where q = queries.size()
	 */
	public static List<Integer> solution(List<String> strings, List<String> queries) {
		// Key: each unique query in the queries array
		// Value: the count of those queries found in the strings array
		Map<String, Integer> queriesCount = new HashMap<>();
		
		// Add all the keys (queries) to the HashMap
		for(String query : queries)
			queriesCount.put(query, 0);
		
		// Loop through all of the strings
		for(String string : strings) {
			// If that string is found in the HashMap, it will return a value, otherwise it will return null.
			Integer count = queriesCount.get(string);
			// If a value is found, increment the count - how many times the query was found in the strings array.
			if(count != null)
				queriesCount.put(string, ++count);
		}
		
		// The problem states we need to return an array. Create an array to store the queries count.
		List<Integer> results = new ArrayList<>(queries.size());
		
		// Loop through the queries array
		for(String query : queries) {
			// Add each query count to the array
			results.add(queriesCount.get(query));
		}
		
		// Return the array of counts
		return results;
	}
	
}
