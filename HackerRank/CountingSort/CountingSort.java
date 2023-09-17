import java.util.*;

public class CountingSort {
	
    /*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
    public static List<Integer> solution(List<Integer> arr) {
		// List (array) for storing the result
        List<Integer> countOfNumbers = new ArrayList<>(100);
        // Instantiate the list with one-hundred 0's.
        for(int i = 0; i < 100; i++){
            countOfNumbers.add(0);
        }
        // Loop through every number in "arr"
        for(int i = 0; i < arr.size(); i++){
        	// Get the current number of found in "arr"
            Integer currentNumber = arr.get(i);
            // Get the current count of "currentNumber"
            Integer currentCount = countOfNumbers.get(currentNumber);
            // Add 1 to the currentCount
            countOfNumbers.set(currentNumber, ++currentCount);
        }
        // Return the result
        return countOfNumbers;
    }

}