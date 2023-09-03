import java.util.*;

// https://www.hackerrank.com/challenges/plus-minus
public class PlusMinus {
	
    /*
     * Solution1 - solved with for loop
     * Time Complexity: O(n), where n = array size
     * Space Complexity: O(1)
     */
	public static void solution(List<Integer> arr) {
        // Get the count of positive, negative, and zero values in the array
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;
		
		// Loop through the array to get the counts
		for(int i = 0; i < arr.size(); i++) {
			int currentNum = arr.get(i);
			if(currentNum > 0)
				positiveCount++;
			else if(currentNum < 0)
				negativeCount++;
			else
				zeroCount++;
		}
		
		// Get the ratios of each.
		// The result must be a decimal precision of 6. We will use the double primitive because it exceeds that requirement.
		double denominator = arr.size();
		double positiveRatio = positiveCount / denominator;
		double negativeRatio = negativeCount / denominator;
		double zeroRatio = zeroCount / denominator;
		
		// Print the results but only print the first 6 decimal places.
		System.out.println(
				String.format("%.6f", positiveRatio)
				);
		System.out.println(
				String.format("%.6f", negativeRatio)
				);
		System.out.println(
				String.format("%.6f", zeroRatio)
				);
    }
}
