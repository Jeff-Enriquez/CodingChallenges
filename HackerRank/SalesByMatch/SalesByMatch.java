import java.util.*;
public class SalesByMatch {
    /*
	 * Time Complexity: O(n), n is the same as the size of "ar"
	 * Space Complexity: O(n), n is the same as the size of "ar"
	 */
    public static int solution(int n, List<Integer> ar) {
		// Keep track of the pair count
		int pairCount = 0;
		// Store the counts of socks
        Map<Integer, Integer> socks = new HashMap<>();
        // Iterate through all the socks in the array
        for(Integer sock : ar) {
        	// Get the current count of that sock
        	Integer currentCount = socks.getOrDefault(sock, 0);
        	// Add one to that count
        	socks.put(sock, ++currentCount);
        }
        // Loop through all the counts of the socks
        for(Integer count : socks.values()) {
        	// Add the number of pairs of each sock to the pairCount
        	pairCount += (count / 2);
        }
        // Return the pairCount
        return pairCount;
    }
}
