import java.util.*;

public class MiniMaxSum {
	
	/*
	 * Time Complexity: O(1): Since the array size will always be 5, the time is constant 
	 * Space Complexity O(1): Since the array size will always be 5, the space is constant
	 */
	public static void solution(List<Integer> arr) {
		// We will iterate through the array, adding the sum, and keep track of the min / max elements.
		
		// The max value an element in the array can be is 10^9. We will set the minNum to Long.MAX_VALUE (2^63 - 1) which is greater than 10^9.
		long minNum = Long.MAX_VALUE;
		// The min value an element in the array can be is 1 so we will set the maxNum to 0.  
		long maxNum = 0;
		
		// Get the sum of the array
		long arrSum = 0;
		for(int i = 0; i < arr.size(); i++) {
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
	

	// For executing sample questions
	public static void main(String[] args) {
		solution(List.of(1, 3, 5, 7, 9));
			// Expected result: 16 24
		solution(List.of(769082435, 210437958, 673982045, 375809214, 380564127));
			// Expected result: 10 14
	}
	
}