import java.util.*;
// https://www.hackerrank.com/challenges/maxsubarray/problem
public class TheMaximumSubarray {
    /*
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static List<Integer> maxSubarray(List<Integer> arr) {
		// Only get the positive numbers of the array
		int maxSubSequence = arr.stream().filter(num -> num > 0).reduce(0, Integer::sum);
		// If it returned zero, then it is possible all numbers of the array are negative. Get the largest number.
		if(maxSubSequence == 0)
			maxSubSequence = arr.stream().max(Comparator.naturalOrder()).orElse(0);
		// Find the max subarray
		int maxSubArray = 0;
		// Iterate through all numbers of the array
		int i = 0;
		while(i < arr.size()) {
			int num = arr.get(i++);
			// If the number is less than 0, skip
			if(num <= 0)
				continue;
			int tempSubArray = num;
			// Check if this subarray is the largest
			if(tempSubArray > maxSubArray)
				maxSubArray = tempSubArray;
			// Iterate through the rest of the array
			int j = i;
			while(j < arr.size()) {
				int n = arr.get(j++);
				tempSubArray += n;
				// If the number is less than 0, break to the next subarray
				if(tempSubArray <= 0)
					break;
				// Check if this subarray is the largest
				if(tempSubArray > maxSubArray)
					maxSubArray = tempSubArray;
			}
			if(j == arr.size())
				break;
			i = j;
		}
		// If max sub array is 0, it is possible all numbers in the array are negative.
		// If that is the case, assign the maxSubSequence to maxSubArray.
		if(maxSubArray == 0) {
			maxSubArray = maxSubSequence;
		}
		return List.of(maxSubArray, maxSubSequence);
    }
}
