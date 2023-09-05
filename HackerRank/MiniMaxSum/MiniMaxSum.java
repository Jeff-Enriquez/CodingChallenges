import java.util.*;

// https://www.hackerrank.com/challenges/mini-max-sum/problem
public class MiniMaxSum {
	
	/*
	 * Solution with for loop
	 * Time Complexity: O(n) where n is the size of the array
	 * 					O(1) with hackerrank constraint - since the array size will always be 5
	 * Space Complexity O(1)
	 */
	public static void solution1(List<Integer> arr) {
		// We will iterate through the array, adding the sum, and keep track of the min / max elements.
		
		// The max value an element in the array can be is 10^9. We will set the minNum to Long.MAX_VALUE (2^63 - 1) which is greater than 10^9.
		long minNum = arr.get(0);
		// The min value an element in the array can be is 1 so we will set the maxNum to 0.  
		long maxNum = arr.get(0);
		
		// Get the sum of the array
		long arrSum = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			// Get the current element of the array
			long currentNum = arr.get(i);
			// Add to the sum
			arrSum += currentNum;
			// Check if this element is the smallest number in the array
			if(currentNum < minNum)
				minNum = currentNum;
			// Check if this element is the largest number in the array
			if(currentNum > maxNum) {
				maxNum = currentNum;
			}
		}
		
		// The min value is the sum of the array minus the largest element.
		long minSum = arrSum - maxNum;
		// The max value is the sum of the array minus the smallest element.
		long maxSum = arrSum - minNum;
		
		// Print result
		System.out.println(minSum + " " + maxSum);
	}
	
}